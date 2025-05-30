// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.
// Code generated by Microsoft (R) AutoRest Code Generator.

package com.azure.resourcemanager.elasticsan.generated;

import com.azure.core.util.BinaryData;
import com.azure.resourcemanager.elasticsan.models.VolumeNameList;
import java.util.Arrays;
import org.junit.jupiter.api.Assertions;

public final class VolumeNameListTests {
    @org.junit.jupiter.api.Test
    public void testDeserialize() throws Exception {
        VolumeNameList model
            = BinaryData.fromString("{\"volumeNames\":[\"krtswbxqz\"]}").toObject(VolumeNameList.class);
        Assertions.assertEquals("krtswbxqz", model.volumeNames().get(0));
    }

    @org.junit.jupiter.api.Test
    public void testSerialize() throws Exception {
        VolumeNameList model = new VolumeNameList().withVolumeNames(Arrays.asList("krtswbxqz"));
        model = BinaryData.fromObject(model).toObject(VolumeNameList.class);
        Assertions.assertEquals("krtswbxqz", model.volumeNames().get(0));
    }
}
