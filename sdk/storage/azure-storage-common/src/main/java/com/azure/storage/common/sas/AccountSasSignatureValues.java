// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.

package com.azure.storage.common.sas;

import com.azure.core.util.Configuration;
import com.azure.storage.common.StorageSharedKeyCredential;
import com.azure.storage.common.implementation.Constants;
import com.azure.storage.common.implementation.StorageImplUtils;

import java.time.OffsetDateTime;

/**
 * Used to initialize parameters for a Shared Access Signature (SAS) for an Azure Storage account. Once all the
 * values here are set, use the generateSas method on the desired service client to obtain a representation of the SAS
 * which can then be applied to a new client using the .sasToken(String) method on the desired client builder.
 *
 * @see <a href=https://docs.microsoft.com/azure/storage/common/storage-sas-overview>Storage SAS overview</a>
 * @see <a href=https://docs.microsoft.com/rest/api/storageservices/create-account-sas>Create an account SAS</a>
 */
public final class AccountSasSignatureValues {
    private static final String VERSION = Configuration.getGlobalConfiguration()
        .get(Constants.PROPERTY_AZURE_STORAGE_SAS_SERVICE_VERSION, Constants.SAS_SERVICE_VERSION);

    /**
     * Pin down to highest version that worked with string to sign defined here.
     */
    private static final String VERSION_DEPRECATED_SHARED_KEY_SAS_STRING_TO_SIGN;

    static {
        String version = Configuration.getGlobalConfiguration()
            .get(Constants.PROPERTY_AZURE_STORAGE_SAS_SERVICE_VERSION, "2020-10-02");
        if (version.compareTo("2020-10-02") > 0) {
            version = "2020-10-02";
        }
        VERSION_DEPRECATED_SHARED_KEY_SAS_STRING_TO_SIGN = version;
    }

    private SasProtocol protocol;
    private OffsetDateTime startTime;
    private OffsetDateTime expiryTime;
    private String permissions;
    private SasIpRange sasIpRange;
    private String services;
    private String resourceTypes;
    private String encryptionScope;

    /**
     * Initializes a new {@link AccountSasSignatureValues} object.
     *
     * @deprecated Please use {@link #AccountSasSignatureValues(OffsetDateTime, AccountSasPermission, AccountSasService,
     * AccountSasResourceType)}
     */
    @Deprecated
    public AccountSasSignatureValues() {
    }

    /**
     * Initializes a new {@link AccountSasSignatureValues} object.
     *
     * @param expiryTime The time after which the SAS will no longer work.
     * @param permissions {@link AccountSasPermission} allowed by the SAS.
     * @param services {@link AccountSasService} targeted by the SAS.
     * @param resourceTypes {@link AccountSasResourceType} targeted by the SAS.
     */
    public AccountSasSignatureValues(OffsetDateTime expiryTime, AccountSasPermission permissions,
        AccountSasService services, AccountSasResourceType resourceTypes) {
        StorageImplUtils.assertNotNull("expiryTime", expiryTime);
        StorageImplUtils.assertNotNull("services", services);
        StorageImplUtils.assertNotNull("permissions", permissions);
        StorageImplUtils.assertNotNull("resourceTypes", resourceTypes);

        this.expiryTime = expiryTime;
        this.services = services.toString();
        this.resourceTypes = resourceTypes.toString();
        this.permissions = permissions.toString();
    }

    /**
     * Gets the service version that is targeted, if {@code null} or empty the latest service version targeted by the
     * library will be used.
     *
     * @return the service version that is targeted, if {@code null} or empty the latest service version targeted by the
     * library will be used.
     */
    public String getVersion() {
        return VERSION;
    }

    /**
     * Sets the service version that is targeted. Leave this {@code null} or empty to target the version used by the
     * library.
     *
     * @param version Target version to set
     * @return the updated AccountSasSignatureValues object.
     * @deprecated The version is set to the latest version of sas. Users should stop calling this API as it is now
     * treated as a no-op.
     */
    @Deprecated
    public AccountSasSignatureValues setVersion(String version) {
        // no-op
        return this;
    }

    /**
     * Gets the {@link SasProtocol} which determines the HTTP protocol that will be used.
     *
     * @return the {@link SasProtocol} which determines the HTTP protocol that will be used.
     */
    public SasProtocol getProtocol() {
        return protocol;
    }

    /**
     * Sets the {@link SasProtocol} which determines the HTTP protocol that will be used.
     *
     * @param protocol Protocol to set
     * @return the updated AccountSasSignatureValues object.
     */
    public AccountSasSignatureValues setProtocol(SasProtocol protocol) {
        this.protocol = protocol;
        return this;
    }

    /**
     * Gets when the SAS will take effect.
     *
     * @return when the SAS will take effect.
     */
    public OffsetDateTime getStartTime() {
        return startTime;
    }

    /**
     * Sets when the SAS will take effect.
     *
     * @param startTime Start time to set
     * @return the updated AccountSasSignatureValues object.
     */
    public AccountSasSignatureValues setStartTime(OffsetDateTime startTime) {
        this.startTime = startTime;
        return this;
    }

    /**
     * Gets the time after which the SAS will no longer work.
     *
     * @return the time after which the SAS will no longer work.
     */
    public OffsetDateTime getExpiryTime() {
        return expiryTime;
    }

    /**
     * Sets the time after which the SAS will no longer work.
     *
     * @param expiryTime Expiry time to set
     * @return the updated AccountSasSignatureValues object.
     * @deprecated Please use {@link #AccountSasSignatureValues(OffsetDateTime, AccountSasPermission, AccountSasService,
     * AccountSasResourceType)} to specify the expiry time.
     */
    @Deprecated
    public AccountSasSignatureValues setExpiryTime(OffsetDateTime expiryTime) {
        this.expiryTime = expiryTime;
        return this;
    }

    /**
     * Gets the operations the SAS user may perform.
     *
     * @return The operations the SAS user may perform. Please refer to {@link AccountSasPermission} to help determine
     * which permissions are allowed.
     */
    public String getPermissions() {
        return permissions;
    }

    /**
     * Sets the operations the account SAS user may perform. Please refer to {@link AccountSasPermission} for help
     * constructing the permissions string.
     *
     * @param permissions Permissions to set.
     * @return the updated AccountSasSignatureValues object.
     * @throws NullPointerException if {@code permissions} is null.
     * @deprecated Please use {@link #AccountSasSignatureValues(OffsetDateTime, AccountSasPermission, AccountSasService,
     * AccountSasResourceType)} to specify the allowed permissions.
     */
    @Deprecated
    public AccountSasSignatureValues setPermissions(AccountSasPermission permissions) {
        StorageImplUtils.assertNotNull("permissions", permissions);
        this.permissions = permissions.toString();
        return this;
    }

    /**
     * Gets the {@link SasIpRange} which determines the IP ranges that are allowed to use the SAS.
     * @return the {@link SasIpRange} which determines the IP ranges that are allowed to use the SAS.
     */
    public SasIpRange getSasIpRange() {
        return sasIpRange;
    }

    /**
     * Sets the {@link SasIpRange} which determines the IP ranges that are allowed to use the SAS.
     *
     * @param sasIpRange Allowed IP range to set
     * @return the updated AccountSasSignatureValues object.
     * @see <a href=https://docs.microsoft.com/rest/api/storageservices/create-service-sas#specifying-ip-address-or-ip-range>Specifying IP Address or IP range</a>
     */
    public AccountSasSignatureValues setSasIpRange(SasIpRange sasIpRange) {
        this.sasIpRange = sasIpRange;
        return this;
    }

    /**
     * Gets the services accessible with this SAS. Please refer to {@link AccountSasService} to help determine which
     * services are accessible.
     *
     * @return the services accessible with this SAS. Please refer to {@link AccountSasService} to help determine which
     * services are accessible.
     */
    public String getServices() {
        return services;
    }

    /**
     * Sets the services accessible with this SAS. Please refer to {@link AccountSasService} to construct this value.
     *
     * @param services Allowed services string to set
     * @return the updated AccountSasSignatureValues object.
     * @deprecated Please use {@link #AccountSasSignatureValues(OffsetDateTime, AccountSasPermission, AccountSasService,
     * AccountSasResourceType)} to specify the services being targeted.
     */
    @Deprecated
    public AccountSasSignatureValues setServices(String services) {
        this.services = services;
        return this;
    }

    /**
     * Gets the resource types accessible with this SAS. Please refer to {@link AccountSasResourceType} to help
     * determine the resource types that are accessible.
     *
     * @return the resource types accessible with this SAS. Please refer to {@link AccountSasResourceType} to help
     * determine the resource types that are accessible.
     */
    public String getResourceTypes() {
        return resourceTypes;
    }

    /**
     * Sets the resource types accessible with this SAS. Please refer to {@link AccountSasResourceType} to construct
     * this value.
     *
     * @param resourceTypes Allowed resource types string to set
     * @return the updated AccountSasSignatureValues object.
     * @deprecated Please use {@link #AccountSasSignatureValues(OffsetDateTime, AccountSasPermission, AccountSasService,
     * AccountSasResourceType)} to specify the resource types being targeted.
     */
    @Deprecated
    public AccountSasSignatureValues setResourceTypes(String resourceTypes) {
        this.resourceTypes = resourceTypes;
        return this;
    }

    /**
     * Gets the encryption scope that will be applied to any write operations performed with the sas
     *
     * @return An encryption scope that will be applied to any write operations performed with the sas
     */
    public String getEncryptionScope() {
        return encryptionScope;
    }

    /**
     * Sets the encryption scope that will be applied to any write operations performed with the sas
     *
     * @param encryptionScope the encryption scope to set
     * @return the updated AccountSasSignatureValues object.
     */
    public AccountSasSignatureValues setEncryptionScope(String encryptionScope) {
        this.encryptionScope = encryptionScope;
        return this;
    }

    /**
     * Generates a {@link AccountSasQueryParameters} object which contains all SAS query parameters for authenticating
     * requests.
     *
     * <p><strong>Notes on SAS generation</strong></p>
     * <ul>
     * <li>If {@link #setVersion(String) version} is not set, the latest service version is used.</li>
     * <li>The following parameters are required to generate a SAS:
     *     <ul>
     *         <li>{@link #setExpiryTime(OffsetDateTime) expiryTime}</li>
     *         <li>{@link #setServices(String) services}</li>
     *         <li>{@link #setPermissions(AccountSasPermission) permissions}</li>
     *         <li>{@link #setResourceTypes(String) resourceTypes}</li>
     *     </ul>
     * </li>
     * </ul>
     *
     * <p>For samples, see class level JavaDocs.</p>
     *
     * @param storageSharedKeyCredentials Credentials for the storage account.
     * @return A new {@link AccountSasQueryParameters} used for authenticating requests.
     * @throws RuntimeException If the HMAC-SHA256 signature for {@code storageSharedKeyCredentials} fails to generate.
     * @throws NullPointerException If any of {@code storageSharedKeyCredentials}, {@code services},
     * {@code resourceTypes}, {@code expiryTime}, or {@code permissions} is null.
     * @see <a href=https://docs.microsoft.com/rest/api/storageservices/create-account-sas>Create an account SAS</a>
     * @deprecated Please use the generateAccountSas(AccountSasSignatureValues) method on the desired service client
     * after initializing {@link AccountSasSignatureValues}.
     */
    @Deprecated
    public AccountSasQueryParameters
        generateSasQueryParameters(StorageSharedKeyCredential storageSharedKeyCredentials) {
        StorageImplUtils.assertNotNull("storageSharedKeyCredentials", storageSharedKeyCredentials);
        StorageImplUtils.assertNotNull("services", this.services);
        StorageImplUtils.assertNotNull("resourceTypes", this.resourceTypes);
        StorageImplUtils.assertNotNull("expiryTime", this.expiryTime);
        StorageImplUtils.assertNotNull("permissions", this.permissions);

        // Signature is generated on the un-url-encoded values.
        String signature = storageSharedKeyCredentials.computeHmac256(stringToSign(storageSharedKeyCredentials));

        return new AccountSasQueryParameters(VERSION_DEPRECATED_SHARED_KEY_SAS_STRING_TO_SIGN, this.services,
            resourceTypes, this.protocol, this.startTime, this.expiryTime, this.sasIpRange, this.permissions,
            signature);
    }

    private String stringToSign(final StorageSharedKeyCredential storageSharedKeyCredentials) {
        return String.join("\n", storageSharedKeyCredentials.getAccountName(),
            AccountSasPermission.parse(this.permissions).toString(), // guarantees ordering
            this.services, resourceTypes,
            this.startTime == null ? "" : Constants.ISO_8601_UTC_DATE_FORMATTER.format(this.startTime),
            Constants.ISO_8601_UTC_DATE_FORMATTER.format(this.expiryTime),
            this.sasIpRange == null ? "" : this.sasIpRange.toString(),
            this.protocol == null ? "" : this.protocol.toString(), VERSION_DEPRECATED_SHARED_KEY_SAS_STRING_TO_SIGN, ""
        // Account SAS requires an additional newline character
        );
    }
}
