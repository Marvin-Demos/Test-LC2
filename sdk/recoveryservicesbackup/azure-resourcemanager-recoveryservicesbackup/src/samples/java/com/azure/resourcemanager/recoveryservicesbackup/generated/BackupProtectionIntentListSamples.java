// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.
// Code generated by Microsoft (R) AutoRest Code Generator.

package com.azure.resourcemanager.recoveryservicesbackup.generated;

/**
 * Samples for BackupProtectionIntent List.
 */
public final class BackupProtectionIntentListSamples {
    /*
     * x-ms-original-file:
     * specification/recoveryservicesbackup/resource-manager/Microsoft.RecoveryServices/stable/2025-02-01/examples/
     * AzureWorkload/BackupProtectionIntent_List.json
     */
    /**
     * Sample code: List protection intent with backupManagementType filter.
     * 
     * @param manager Entry point to RecoveryServicesBackupManager.
     */
    public static void listProtectionIntentWithBackupManagementTypeFilter(
        com.azure.resourcemanager.recoveryservicesbackup.RecoveryServicesBackupManager manager) {
        manager.backupProtectionIntents().list("myVault", "myRG", null, null, com.azure.core.util.Context.NONE);
    }
}
