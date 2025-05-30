// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.
// Code generated by Microsoft (R) AutoRest Code Generator.

package com.azure.resourcemanager.elasticsan.generated;

import com.azure.core.credential.AccessToken;
import com.azure.core.http.HttpClient;
import com.azure.core.http.rest.PagedIterable;
import com.azure.core.management.profile.AzureProfile;
import com.azure.core.models.AzureCloud;
import com.azure.core.test.http.MockHttpResponse;
import com.azure.resourcemanager.elasticsan.ElasticSanManager;
import com.azure.resourcemanager.elasticsan.models.Volume;
import com.azure.resourcemanager.elasticsan.models.VolumeCreateOption;
import com.azure.resourcemanager.elasticsan.models.XMsAccessSoftDeletedResources;
import java.nio.charset.StandardCharsets;
import java.time.OffsetDateTime;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import reactor.core.publisher.Mono;

public final class VolumesListByVolumeGroupMockTests {
    @Test
    public void testListByVolumeGroup() throws Exception {
        String responseStr
            = "{\"value\":[{\"properties\":{\"volumeId\":\"rfdwoyu\",\"creationData\":{\"createSource\":\"None\",\"sourceId\":\"iefozbhdmsml\"},\"sizeGiB\":4730263742485000003,\"storageTarget\":{\"targetIqn\":\"ft\",\"targetPortalHostname\":\"ae\",\"targetPortalPort\":2084931512,\"provisioningState\":\"SoftDeleting\",\"status\":\"Unhealthy\"},\"managedBy\":{\"resourceId\":\"lfaoqzpiyylhaln\"},\"provisioningState\":\"Succeeded\"},\"id\":\"csphkaiv\",\"name\":\"itqscywuggwoluhc\",\"type\":\"bwemhairs\"}]}";

        HttpClient httpClient
            = response -> Mono.just(new MockHttpResponse(response, 200, responseStr.getBytes(StandardCharsets.UTF_8)));
        ElasticSanManager manager = ElasticSanManager.configure()
            .withHttpClient(httpClient)
            .authenticate(tokenRequestContext -> Mono.just(new AccessToken("this_is_a_token", OffsetDateTime.MAX)),
                new AzureProfile("", "", AzureCloud.AZURE_PUBLIC_CLOUD));

        PagedIterable<Volume> response = manager.volumes()
            .listByVolumeGroup("grtwae", "u", "zkopb", XMsAccessSoftDeletedResources.FALSE,
                com.azure.core.util.Context.NONE);

        Assertions.assertEquals(VolumeCreateOption.NONE, response.iterator().next().creationData().createSource());
        Assertions.assertEquals("iefozbhdmsml", response.iterator().next().creationData().sourceId());
        Assertions.assertEquals(4730263742485000003L, response.iterator().next().sizeGiB());
        Assertions.assertEquals("lfaoqzpiyylhaln", response.iterator().next().managedBy().resourceId());
    }
}
