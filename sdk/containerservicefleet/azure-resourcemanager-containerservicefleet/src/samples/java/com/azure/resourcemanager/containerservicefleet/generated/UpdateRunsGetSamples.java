// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.
// Code generated by Microsoft (R) TypeSpec Code Generator.

package com.azure.resourcemanager.containerservicefleet.generated;

/**
 * Samples for UpdateRuns Get.
 */
public final class UpdateRunsGetSamples {
    /*
     * x-ms-original-file: 2025-03-01/UpdateRuns_Get_MaximumSet_Gen.json
     */
    /**
     * Sample code: Gets an UpdateRun resource. - generated by [MaximumSet] rule.
     * 
     * @param manager Entry point to ContainerServiceFleetManager.
     */
    public static void getsAnUpdateRunResourceGeneratedByMaximumSetRule(
        com.azure.resourcemanager.containerservicefleet.ContainerServiceFleetManager manager) {
        manager.updateRuns().getWithResponse("rgfleets", "fleet1", "fleet1", com.azure.core.util.Context.NONE);
    }

    /*
     * x-ms-original-file: 2025-03-01/UpdateRuns_Get.json
     */
    /**
     * Sample code: Gets an UpdateRun resource.
     * 
     * @param manager Entry point to ContainerServiceFleetManager.
     */
    public static void
        getsAnUpdateRunResource(com.azure.resourcemanager.containerservicefleet.ContainerServiceFleetManager manager) {
        manager.updateRuns().getWithResponse("rg1", "fleet1", "run1", com.azure.core.util.Context.NONE);
    }
}
