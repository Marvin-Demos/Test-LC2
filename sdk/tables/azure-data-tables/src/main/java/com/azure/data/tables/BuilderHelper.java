// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.

package com.azure.data.tables;

import com.azure.core.credential.AzureNamedKeyCredential;
import com.azure.core.credential.AzureSasCredential;
import com.azure.core.credential.TokenCredential;
import com.azure.core.http.HttpClient;
import com.azure.core.http.HttpHeader;
import com.azure.core.http.HttpHeaderName;
import com.azure.core.http.HttpHeaders;
import com.azure.core.http.HttpPipeline;
import com.azure.core.http.HttpPipelineBuilder;
import com.azure.core.http.policy.AddDatePolicy;
import com.azure.core.http.policy.AddHeadersPolicy;
import com.azure.core.http.policy.AzureSasCredentialPolicy;
import com.azure.core.http.policy.HttpLogOptions;
import com.azure.core.http.policy.HttpLoggingPolicy;
import com.azure.core.http.policy.HttpPipelinePolicy;
import com.azure.core.http.policy.HttpPolicyProviders;
import com.azure.core.http.policy.RequestIdPolicy;
import com.azure.core.http.policy.RetryOptions;
import com.azure.core.http.policy.RetryPolicy;
import com.azure.core.http.policy.UserAgentPolicy;
import com.azure.core.util.ClientOptions;
import com.azure.core.util.Configuration;
import com.azure.core.util.CoreUtils;
import com.azure.core.util.TracingOptions;
import com.azure.core.util.logging.ClientLogger;
import com.azure.core.util.tracing.Tracer;
import com.azure.core.util.tracing.TracerProvider;
import com.azure.data.tables.implementation.CosmosPatchTransformPolicy;
import com.azure.data.tables.implementation.NullHttpClient;
import com.azure.data.tables.implementation.StorageAuthenticationSettings;
import com.azure.data.tables.implementation.StorageConnectionString;
import com.azure.data.tables.implementation.StorageConstants;
import com.azure.data.tables.implementation.TableBearerTokenChallengeAuthorizationPolicy;
import com.azure.data.tables.implementation.TableUtils;
import com.azure.data.tables.implementation.TablesConstants;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.StringJoiner;
import java.util.stream.Collectors;
import java.util.stream.Stream;

final class BuilderHelper {
    private static final Map<String, String> PROPERTIES = CoreUtils.getProperties("azure-data-tables.properties");
    private static final String CLIENT_NAME = PROPERTIES.getOrDefault("name", "UnknownName");
    private static final String CLIENT_VERSION = PROPERTIES.getOrDefault("version", "UnknownVersion");
    private static final String COSMOS_ENDPOINT_SUFFIX = "cosmos.azure.";
    private static final String TABLES_TRACING_NAMESPACE_VALUE = "Microsoft.Tables";

    public static final ClientOptions DEFAULT_CLIENT_OPTIONS = new ClientOptions();

    static HttpPipeline buildPipeline(AzureNamedKeyCredential azureNamedKeyCredential,
        AzureSasCredential azureSasCredential, TokenCredential tokenCredential, String sasToken, String endpoint,
        RetryPolicy retryPolicy, RetryOptions retryOptions, HttpLogOptions logOptions, ClientOptions clientOptions,
        HttpClient httpClient, List<HttpPipelinePolicy> perCallAdditionalPolicies,
        List<HttpPipelinePolicy> perRetryAdditionalPolicies, Configuration configuration, ClientLogger logger,
        boolean enableTenantDiscovery) {
        configuration = (configuration == null) ? Configuration.getGlobalConfiguration() : configuration;
        logOptions = (logOptions == null) ? new HttpLogOptions() : logOptions;

        if (retryPolicy != null && retryOptions != null) {
            throw logger.logExceptionAsWarning(
                new IllegalStateException("'retryPolicy' and 'retryOptions' cannot both be set"));
        } else if (retryPolicy == null) {
            retryPolicy = retryOptions == null ? new RetryPolicy() : new RetryPolicy(retryOptions);
        }

        // Closest to API goes first, closest to wire goes last.
        List<HttpPipelinePolicy> policies = new ArrayList<>();

        if (endpoint == null) {
            throw logger.logExceptionAsError(
                new IllegalStateException("An 'endpoint' is required to create a client. Use builders' 'endpoint()' or"
                    + " 'connectionString()' methods to set this value."));
        } else if (endpoint.contains(COSMOS_ENDPOINT_SUFFIX)) {
            policies.add(new CosmosPatchTransformPolicy());
        }

        ClientOptions localClientOptions = clientOptions != null ? clientOptions : DEFAULT_CLIENT_OPTIONS;

        policies.add(new UserAgentPolicy(CoreUtils.getApplicationId(localClientOptions, logOptions), CLIENT_NAME,
            CLIENT_VERSION, configuration));
        policies.add(new RequestIdPolicy());

        List<HttpHeader> httpHeaderList = new ArrayList<>();

        localClientOptions.getHeaders()
            .forEach(header -> httpHeaderList.add(new HttpHeader(header.getName(), header.getValue())));

        policies.add(new AddHeadersPolicy(new HttpHeaders(httpHeaderList)));

        // Add per call additional policies.
        policies.addAll(perCallAdditionalPolicies);
        HttpPolicyProviders.addBeforeRetryPolicies(policies);

        // Add retry policy.
        policies.add(retryPolicy);

        policies.add(new AddDatePolicy());

        HttpPipelinePolicy credentialPolicy;

        if (azureNamedKeyCredential != null) {
            credentialPolicy = new TableAzureNamedKeyCredentialPolicy(azureNamedKeyCredential);
        } else if (azureSasCredential != null) {
            credentialPolicy = new AzureSasCredentialPolicy(azureSasCredential, false);
        } else if (sasToken != null) {
            credentialPolicy = new AzureSasCredentialPolicy(new AzureSasCredential(sasToken), false);
        } else if (tokenCredential != null) {
            credentialPolicy = new TableBearerTokenChallengeAuthorizationPolicy(tokenCredential, enableTenantDiscovery,
                TableUtils.isCosmosEndpoint(endpoint) ? TablesConstants.COSMOS_SCOPE : StorageConstants.STORAGE_SCOPE);
        } else {
            throw logger.logExceptionAsError(
                new IllegalStateException("A form of authentication is required to create a client. Use a builder's "
                    + "'credential()', 'sasToken()' or 'connectionString()' methods to set a form of authentication."));
        }

        policies.add(credentialPolicy);

        // Add per retry additional policies.
        policies.addAll(perRetryAdditionalPolicies);
        HttpPolicyProviders.addAfterRetryPolicies(policies); //should this be between 3/4?

        policies.add(new HttpLoggingPolicy(logOptions));
        policies.add(new TableScrubEtagPolicy());

        return new HttpPipelineBuilder().policies(policies.toArray(new HttpPipelinePolicy[0]))
            .httpClient(httpClient)
            .tracer(createTracer(clientOptions))
            .clientOptions(localClientOptions)
            .build();
    }

    static HttpPipeline buildNullClientPipeline() {
        HttpPipelinePolicy[] policies = {
            new AddHeadersPolicy(
                new HttpHeaders().set(HttpHeaderName.ACCEPT, "application/json;odata=minimalmetadata")) };

        return new HttpPipelineBuilder().policies(policies).httpClient(new NullHttpClient()).build();
    }

    static void validateCredentials(AzureNamedKeyCredential azureNamedKeyCredential,
        AzureSasCredential azureSasCredential, TokenCredential tokenCredential, String sasToken,
        String connectionString, ClientLogger logger) {
        List<Object> usedCredentials
            = Stream.of(azureNamedKeyCredential, azureSasCredential, tokenCredential, sasToken, connectionString)
                .filter(Objects::nonNull)
                .collect(Collectors.toList());

        // Only allow two forms of authentication when 'connectionString' and 'sasToken' are provided. Validate that
        // both contain the same SAS settings.
        if (usedCredentials.size() == 2 && connectionString != null && sasToken != null) {
            StorageConnectionString storageConnectionString = StorageConnectionString.create(connectionString, logger);
            StorageAuthenticationSettings authSettings = storageConnectionString.getStorageAuthSettings();

            if (authSettings.getType() == StorageAuthenticationSettings.Type.SAS_TOKEN) {
                if (sasToken.equals(authSettings.getSasToken())) {
                    return;
                } else {
                    throw logger.logExceptionAsError(new IllegalStateException("'connectionString' contains a SAS token"
                        + " with different settings than the one provided using the builder's 'sasToken()' method."));
                }
            } else if (authSettings.getType() == StorageAuthenticationSettings.Type.ACCOUNT_NAME_KEY) {
                throw logger.logExceptionAsError(new IllegalStateException("A 'connectionString' containing an account"
                    + "name and key cannot be provided alongside a 'sasToken'."));
            }

            // If the 'connectionString' auth type is not SAS_TOKEN and a 'sasToken' was provided, then multiple
            // incompatible forms of authentication were specified in the client builder.
        }

        if (usedCredentials.size() > 1) {
            StringJoiner usedCredentialsStringBuilder = new StringJoiner(", ");

            if (azureNamedKeyCredential != null) {
                usedCredentialsStringBuilder.add("azureNamedKeyCredential");
            }

            if (azureSasCredential != null) {
                usedCredentialsStringBuilder.add("azureSasCredential");
            }

            if (tokenCredential != null) {
                usedCredentialsStringBuilder.add("tokenCredential");
            }

            if (sasToken != null) {
                usedCredentialsStringBuilder.add("sasToken");
            }

            if (connectionString != null) {
                usedCredentialsStringBuilder.add("connectionString");
            }

            throw logger.logExceptionAsError(new IllegalStateException(
                "Only one form of authentication should be used. The authentication forms present are: "
                    + usedCredentialsStringBuilder + "."));
        }
    }

    private static Tracer createTracer(ClientOptions clientOptions) {
        TracingOptions tracingOptions = clientOptions == null ? null : clientOptions.getTracingOptions();
        return TracerProvider.getDefaultProvider()
            .createTracer(CLIENT_NAME, CLIENT_VERSION, TABLES_TRACING_NAMESPACE_VALUE, tracingOptions);
    }
}
