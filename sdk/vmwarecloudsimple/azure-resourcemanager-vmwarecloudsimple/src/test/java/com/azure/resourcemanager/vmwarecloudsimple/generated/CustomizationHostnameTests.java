// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.
// Code generated by Microsoft (R) AutoRest Code Generator.

package com.azure.resourcemanager.vmwarecloudsimple.generated;

import com.azure.core.util.BinaryData;
import com.azure.resourcemanager.vmwarecloudsimple.models.CustomizationHostname;
import com.azure.resourcemanager.vmwarecloudsimple.models.CustomizationHostnameType;
import org.junit.jupiter.api.Assertions;

public final class CustomizationHostnameTests {
    @org.junit.jupiter.api.Test
    public void testDeserialize() throws Exception {
        CustomizationHostname model = BinaryData.fromString("{\"name\":\"vyvnqqyb\",\"type\":\"VIRTUAL_MACHINE_NAME\"}")
            .toObject(CustomizationHostname.class);
        Assertions.assertEquals("vyvnqqyb", model.name());
        Assertions.assertEquals(CustomizationHostnameType.VIRTUAL_MACHINE_NAME, model.type());
    }

    @org.junit.jupiter.api.Test
    public void testSerialize() throws Exception {
        CustomizationHostname model
            = new CustomizationHostname().withName("vyvnqqyb").withType(CustomizationHostnameType.VIRTUAL_MACHINE_NAME);
        model = BinaryData.fromObject(model).toObject(CustomizationHostname.class);
        Assertions.assertEquals("vyvnqqyb", model.name());
        Assertions.assertEquals(CustomizationHostnameType.VIRTUAL_MACHINE_NAME, model.type());
    }
}
