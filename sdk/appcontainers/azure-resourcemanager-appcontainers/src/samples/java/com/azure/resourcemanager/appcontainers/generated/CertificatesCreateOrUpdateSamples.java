// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.
// Code generated by Microsoft (R) AutoRest Code Generator.

package com.azure.resourcemanager.appcontainers.generated;

import com.azure.resourcemanager.appcontainers.fluent.models.CertificateInner;
import com.azure.resourcemanager.appcontainers.models.CertificateKeyVaultProperties;
import com.azure.resourcemanager.appcontainers.models.CertificateProperties;

/**
 * Samples for Certificates CreateOrUpdate.
 */
public final class CertificatesCreateOrUpdateSamples {
    /*
     * x-ms-original-file: specification/app/resource-manager/Microsoft.App/stable/2025-01-01/examples/
     * Certificate_CreateOrUpdate_FromKeyVault.json
     */
    /**
     * Sample code: Create or Update Certificate using Managed Identity.
     * 
     * @param manager Entry point to ContainerAppsApiManager.
     */
    public static void createOrUpdateCertificateUsingManagedIdentity(
        com.azure.resourcemanager.appcontainers.ContainerAppsApiManager manager) {
        manager.certificates()
            .createOrUpdateWithResponse("examplerg", "testcontainerenv", "certificate-firendly-name",
                new CertificateInner().withLocation("East US")
                    .withProperties(new CertificateProperties()
                        .withCertificateKeyVaultProperties(new CertificateKeyVaultProperties().withIdentity(
                            "/subscriptions/00000000-0000-0000-0000-000000000000/resourcegroups/test-rg/providers/microsoft.managedidentity/userassignedidentities/test-user-mi")
                            .withKeyVaultUrl("fakeTokenPlaceholder"))),
                com.azure.core.util.Context.NONE);
    }

    /*
     * x-ms-original-file:
     * specification/app/resource-manager/Microsoft.App/stable/2025-01-01/examples/Certificate_CreateOrUpdate.json
     */
    /**
     * Sample code: Create or Update Certificate.
     * 
     * @param manager Entry point to ContainerAppsApiManager.
     */
    public static void
        createOrUpdateCertificate(com.azure.resourcemanager.appcontainers.ContainerAppsApiManager manager) {
        manager.certificates()
            .createOrUpdateWithResponse("examplerg", "testcontainerenv", "certificate-firendly-name",
                new CertificateInner().withLocation("East US")
                    .withProperties(new CertificateProperties().withPassword("fakeTokenPlaceholder")
                        .withValue("Y2VydA==".getBytes())),
                com.azure.core.util.Context.NONE);
    }
}
