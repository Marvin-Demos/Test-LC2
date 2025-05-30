// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.
// Code generated by Microsoft (R) AutoRest Code Generator.

package com.azure.resourcemanager.mobilenetwork.models;

import com.azure.core.annotation.Fluent;
import com.azure.json.JsonReader;
import com.azure.json.JsonSerializable;
import com.azure.json.JsonToken;
import com.azure.json.JsonWriter;
import com.azure.resourcemanager.mobilenetwork.fluent.models.AttachedDataNetworkInner;
import java.io.IOException;
import java.util.List;

/**
 * Response for attached data network API service call.
 */
@Fluent
public final class AttachedDataNetworkListResult implements JsonSerializable<AttachedDataNetworkListResult> {
    /*
     * A list of data networks in a resource group.
     */
    private List<AttachedDataNetworkInner> value;

    /*
     * The URL to get the next set of results.
     */
    private String nextLink;

    /**
     * Creates an instance of AttachedDataNetworkListResult class.
     */
    public AttachedDataNetworkListResult() {
    }

    /**
     * Get the value property: A list of data networks in a resource group.
     * 
     * @return the value value.
     */
    public List<AttachedDataNetworkInner> value() {
        return this.value;
    }

    /**
     * Set the value property: A list of data networks in a resource group.
     * 
     * @param value the value value to set.
     * @return the AttachedDataNetworkListResult object itself.
     */
    public AttachedDataNetworkListResult withValue(List<AttachedDataNetworkInner> value) {
        this.value = value;
        return this;
    }

    /**
     * Get the nextLink property: The URL to get the next set of results.
     * 
     * @return the nextLink value.
     */
    public String nextLink() {
        return this.nextLink;
    }

    /**
     * Validates the instance.
     * 
     * @throws IllegalArgumentException thrown if the instance is not valid.
     */
    public void validate() {
        if (value() != null) {
            value().forEach(e -> e.validate());
        }
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public JsonWriter toJson(JsonWriter jsonWriter) throws IOException {
        jsonWriter.writeStartObject();
        jsonWriter.writeArrayField("value", this.value, (writer, element) -> writer.writeJson(element));
        return jsonWriter.writeEndObject();
    }

    /**
     * Reads an instance of AttachedDataNetworkListResult from the JsonReader.
     * 
     * @param jsonReader The JsonReader being read.
     * @return An instance of AttachedDataNetworkListResult if the JsonReader was pointing to an instance of it, or null
     * if it was pointing to JSON null.
     * @throws IOException If an error occurs while reading the AttachedDataNetworkListResult.
     */
    public static AttachedDataNetworkListResult fromJson(JsonReader jsonReader) throws IOException {
        return jsonReader.readObject(reader -> {
            AttachedDataNetworkListResult deserializedAttachedDataNetworkListResult
                = new AttachedDataNetworkListResult();
            while (reader.nextToken() != JsonToken.END_OBJECT) {
                String fieldName = reader.getFieldName();
                reader.nextToken();

                if ("value".equals(fieldName)) {
                    List<AttachedDataNetworkInner> value
                        = reader.readArray(reader1 -> AttachedDataNetworkInner.fromJson(reader1));
                    deserializedAttachedDataNetworkListResult.value = value;
                } else if ("nextLink".equals(fieldName)) {
                    deserializedAttachedDataNetworkListResult.nextLink = reader.getString();
                } else {
                    reader.skipChildren();
                }
            }

            return deserializedAttachedDataNetworkListResult;
        });
    }
}
