// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.
// Code generated by Microsoft (R) AutoRest Code Generator.

package com.azure.resourcemanager.botservice.generated;

import com.azure.core.util.BinaryData;
import com.azure.resourcemanager.botservice.models.SkypeChannel;
import com.azure.resourcemanager.botservice.models.SkypeChannelProperties;
import org.junit.jupiter.api.Assertions;

public final class SkypeChannelTests {
    @org.junit.jupiter.api.Test
    public void testDeserialize() throws Exception {
        SkypeChannel model = BinaryData.fromString(
            "{\"channelName\":\"SkypeChannel\",\"properties\":{\"enableMessaging\":false,\"enableMediaCards\":true,\"enableVideo\":false,\"enableCalling\":true,\"enableScreenSharing\":true,\"enableGroups\":false,\"groupsMode\":\"ebwpucwwfvo\",\"callingWebHook\":\"vmeueci\",\"incomingCallRoute\":\"hzceuojgjrwjue\",\"isEnabled\":false},\"etag\":\"wmcdytdxwi\",\"provisioningState\":\"nrjawgqwg\",\"location\":\"ni\"}")
            .toObject(SkypeChannel.class);
        Assertions.assertEquals("wmcdytdxwi", model.etag());
        Assertions.assertEquals("ni", model.location());
        Assertions.assertEquals(false, model.properties().enableMessaging());
        Assertions.assertEquals(true, model.properties().enableMediaCards());
        Assertions.assertEquals(false, model.properties().enableVideo());
        Assertions.assertEquals(true, model.properties().enableCalling());
        Assertions.assertEquals(true, model.properties().enableScreenSharing());
        Assertions.assertEquals(false, model.properties().enableGroups());
        Assertions.assertEquals("ebwpucwwfvo", model.properties().groupsMode());
        Assertions.assertEquals("vmeueci", model.properties().callingWebhook());
        Assertions.assertEquals("hzceuojgjrwjue", model.properties().incomingCallRoute());
        Assertions.assertEquals(false, model.properties().isEnabled());
    }

    @org.junit.jupiter.api.Test
    public void testSerialize() throws Exception {
        SkypeChannel model = new SkypeChannel().withEtag("wmcdytdxwi")
            .withLocation("ni")
            .withProperties(new SkypeChannelProperties().withEnableMessaging(false)
                .withEnableMediaCards(true)
                .withEnableVideo(false)
                .withEnableCalling(true)
                .withEnableScreenSharing(true)
                .withEnableGroups(false)
                .withGroupsMode("ebwpucwwfvo")
                .withCallingWebhook("vmeueci")
                .withIncomingCallRoute("hzceuojgjrwjue")
                .withIsEnabled(false));
        model = BinaryData.fromObject(model).toObject(SkypeChannel.class);
        Assertions.assertEquals("wmcdytdxwi", model.etag());
        Assertions.assertEquals("ni", model.location());
        Assertions.assertEquals(false, model.properties().enableMessaging());
        Assertions.assertEquals(true, model.properties().enableMediaCards());
        Assertions.assertEquals(false, model.properties().enableVideo());
        Assertions.assertEquals(true, model.properties().enableCalling());
        Assertions.assertEquals(true, model.properties().enableScreenSharing());
        Assertions.assertEquals(false, model.properties().enableGroups());
        Assertions.assertEquals("ebwpucwwfvo", model.properties().groupsMode());
        Assertions.assertEquals("vmeueci", model.properties().callingWebhook());
        Assertions.assertEquals("hzceuojgjrwjue", model.properties().incomingCallRoute());
        Assertions.assertEquals(false, model.properties().isEnabled());
    }
}
