// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.
// Code generated by Microsoft (R) AutoRest Code Generator.

package com.azure.resourcemanager.sphere.generated;

/**
 * Samples for Catalogs ListDeployments.
 */
public final class CatalogsListDeploymentsSamples {
    /*
     * x-ms-original-file: specification/sphere/resource-manager/Microsoft.AzureSphere/stable/2024-04-01/examples/
     * PostListDeploymentsByCatalog.json
     */
    /**
     * Sample code: Catalogs_ListDeployments.
     * 
     * @param manager Entry point to AzureSphereManager.
     */
    public static void catalogsListDeployments(com.azure.resourcemanager.sphere.AzureSphereManager manager) {
        manager.catalogs()
            .listDeployments("MyResourceGroup1", "MyCatalog1", null, null, null, null,
                com.azure.core.util.Context.NONE);
    }
}
