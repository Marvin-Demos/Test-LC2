// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.
// Code generated by Microsoft (R) AutoRest Code Generator.

package com.azure.resourcemanager.securityinsights.generated;

import com.azure.core.util.BinaryData;
import com.azure.resourcemanager.securityinsights.models.AlertsDataTypeOfDataConnector;
import com.azure.resourcemanager.securityinsights.models.DataConnectorDataTypeCommon;
import com.azure.resourcemanager.securityinsights.models.DataTypeState;
import com.azure.resourcemanager.securityinsights.models.MdatpDataConnector;
import org.junit.jupiter.api.Assertions;

public final class MdatpDataConnectorTests {
    @org.junit.jupiter.api.Test
    public void testDeserialize() throws Exception {
        MdatpDataConnector model = BinaryData.fromString(
            "{\"kind\":\"MicrosoftDefenderAdvancedThreatProtection\",\"properties\":{\"tenantId\":\"uyxoaf\",\"dataTypes\":{\"alerts\":{\"state\":\"Enabled\"}}},\"etag\":\"faey\",\"id\":\"nm\",\"name\":\"gv\",\"type\":\"irpghriypoqeyh\"}")
            .toObject(MdatpDataConnector.class);
        Assertions.assertEquals("faey", model.etag());
        Assertions.assertEquals("uyxoaf", model.tenantId());
        Assertions.assertEquals(DataTypeState.ENABLED, model.dataTypes().alerts().state());
    }

    @org.junit.jupiter.api.Test
    public void testSerialize() throws Exception {
        MdatpDataConnector model = new MdatpDataConnector().withEtag("faey")
            .withTenantId("uyxoaf")
            .withDataTypes(new AlertsDataTypeOfDataConnector()
                .withAlerts(new DataConnectorDataTypeCommon().withState(DataTypeState.ENABLED)));
        model = BinaryData.fromObject(model).toObject(MdatpDataConnector.class);
        Assertions.assertEquals("faey", model.etag());
        Assertions.assertEquals("uyxoaf", model.tenantId());
        Assertions.assertEquals(DataTypeState.ENABLED, model.dataTypes().alerts().state());
    }
}
