// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.
// Code generated by Microsoft (R) AutoRest Code Generator.

package com.azure.resourcemanager.netapp.generated;

import com.azure.core.util.BinaryData;
import com.azure.resourcemanager.netapp.models.MonthlySchedule;
import org.junit.jupiter.api.Assertions;

public final class MonthlyScheduleTests {
    @org.junit.jupiter.api.Test
    public void testDeserialize() throws Exception {
        MonthlySchedule model = BinaryData.fromString(
            "{\"snapshotsToKeep\":1731932488,\"daysOfMonth\":\"gkfpaga\",\"hour\":1249246149,\"minute\":597345805,\"usedBytes\":2549901410987606373}")
            .toObject(MonthlySchedule.class);
        Assertions.assertEquals(1731932488, model.snapshotsToKeep());
        Assertions.assertEquals("gkfpaga", model.daysOfMonth());
        Assertions.assertEquals(1249246149, model.hour());
        Assertions.assertEquals(597345805, model.minute());
        Assertions.assertEquals(2549901410987606373L, model.usedBytes());
    }

    @org.junit.jupiter.api.Test
    public void testSerialize() throws Exception {
        MonthlySchedule model = new MonthlySchedule().withSnapshotsToKeep(1731932488)
            .withDaysOfMonth("gkfpaga")
            .withHour(1249246149)
            .withMinute(597345805)
            .withUsedBytes(2549901410987606373L);
        model = BinaryData.fromObject(model).toObject(MonthlySchedule.class);
        Assertions.assertEquals(1731932488, model.snapshotsToKeep());
        Assertions.assertEquals("gkfpaga", model.daysOfMonth());
        Assertions.assertEquals(1249246149, model.hour());
        Assertions.assertEquals(597345805, model.minute());
        Assertions.assertEquals(2549901410987606373L, model.usedBytes());
    }
}
