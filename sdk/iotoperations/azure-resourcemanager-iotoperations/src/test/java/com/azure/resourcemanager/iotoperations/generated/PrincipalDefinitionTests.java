// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.
// Code generated by Microsoft (R) TypeSpec Code Generator.

package com.azure.resourcemanager.iotoperations.generated;

import com.azure.core.util.BinaryData;
import com.azure.resourcemanager.iotoperations.models.PrincipalDefinition;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import org.junit.jupiter.api.Assertions;

public final class PrincipalDefinitionTests {
    @org.junit.jupiter.api.Test
    public void testDeserialize() throws Exception {
        PrincipalDefinition model = BinaryData.fromString(
            "{\"attributes\":[{\"mfqjhhkxbp\":\"oizpostmgrcfbun\",\"jhxxjyn\":\"jy\"},{\"wbxqzvszjfau\":\"divkrt\"},{\"qmcbxvwvxyslqbhs\":\"fdxxivetvtcqaqtd\"}],\"clientIds\":[\"blytk\"],\"usernames\":[\"pe\"]}")
            .toObject(PrincipalDefinition.class);
        Assertions.assertEquals("oizpostmgrcfbun", model.attributes().get(0).get("mfqjhhkxbp"));
        Assertions.assertEquals("blytk", model.clientIds().get(0));
        Assertions.assertEquals("pe", model.usernames().get(0));
    }

    @org.junit.jupiter.api.Test
    public void testSerialize() throws Exception {
        PrincipalDefinition model = new PrincipalDefinition()
            .withAttributes(Arrays.asList(mapOf("mfqjhhkxbp", "oizpostmgrcfbun", "jhxxjyn", "jy"),
                mapOf("wbxqzvszjfau", "divkrt"), mapOf("qmcbxvwvxyslqbhs", "fdxxivetvtcqaqtd")))
            .withClientIds(Arrays.asList("blytk"))
            .withUsernames(Arrays.asList("pe"));
        model = BinaryData.fromObject(model).toObject(PrincipalDefinition.class);
        Assertions.assertEquals("oizpostmgrcfbun", model.attributes().get(0).get("mfqjhhkxbp"));
        Assertions.assertEquals("blytk", model.clientIds().get(0));
        Assertions.assertEquals("pe", model.usernames().get(0));
    }

    // Use "Map.of" if available
    @SuppressWarnings("unchecked")
    private static <T> Map<String, T> mapOf(Object... inputs) {
        Map<String, T> map = new HashMap<>();
        for (int i = 0; i < inputs.length; i += 2) {
            String key = (String) inputs[i];
            T value = (T) inputs[i + 1];
            map.put(key, value);
        }
        return map;
    }
}
