// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.
// Code generated by Microsoft (R) AutoRest Code Generator.

package com.azure.resourcemanager.connectedvmware.generated;

import com.azure.resourcemanager.connectedvmware.models.StopVirtualMachineOptions;

/**
 * Samples for VirtualMachineInstances Stop.
 */
public final class VirtualMachineInstancesStopSamples {
    /*
     * x-ms-original-file:
     * specification/connectedvmware/resource-manager/Microsoft.ConnectedVMwarevSphere/stable/2023-10-01/examples/
     * StopVirtualMachineInstance.json
     */
    /**
     * Sample code: StopVirtualMachine.
     * 
     * @param manager Entry point to ConnectedVMwareManager.
     */
    public static void stopVirtualMachine(com.azure.resourcemanager.connectedvmware.ConnectedVMwareManager manager) {
        manager.virtualMachineInstances()
            .stop(
                "subscriptions/fd3c3665-1729-4b7b-9a38-238e83b0f98b/resourceGroups/testrg/providers/Microsoft.HybridCompute/machines/DemoVM",
                new StopVirtualMachineOptions().withSkipShutdown(true), com.azure.core.util.Context.NONE);
    }
}
