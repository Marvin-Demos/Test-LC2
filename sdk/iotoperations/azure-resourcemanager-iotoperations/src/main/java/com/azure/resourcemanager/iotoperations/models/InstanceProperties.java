// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.
// Code generated by Microsoft (R) TypeSpec Code Generator.

package com.azure.resourcemanager.iotoperations.models;

import com.azure.core.annotation.Fluent;
import com.azure.core.util.logging.ClientLogger;
import com.azure.json.JsonReader;
import com.azure.json.JsonSerializable;
import com.azure.json.JsonToken;
import com.azure.json.JsonWriter;
import java.io.IOException;
import java.util.Map;

/**
 * The properties of the Instance resource.
 */
@Fluent
public final class InstanceProperties implements JsonSerializable<InstanceProperties> {
    /*
     * Detailed description of the Instance.
     */
    private String description;

    /*
     * The status of the last operation.
     */
    private ProvisioningState provisioningState;

    /*
     * The Azure IoT Operations version.
     */
    private String version;

    /*
     * The reference to the Schema Registry for this AIO Instance.
     */
    private SchemaRegistryRef schemaRegistryRef;

    /*
     * The features of the AIO Instance.
     */
    private Map<String, InstanceFeature> features;

    /**
     * Creates an instance of InstanceProperties class.
     */
    public InstanceProperties() {
    }

    /**
     * Get the description property: Detailed description of the Instance.
     * 
     * @return the description value.
     */
    public String description() {
        return this.description;
    }

    /**
     * Set the description property: Detailed description of the Instance.
     * 
     * @param description the description value to set.
     * @return the InstanceProperties object itself.
     */
    public InstanceProperties withDescription(String description) {
        this.description = description;
        return this;
    }

    /**
     * Get the provisioningState property: The status of the last operation.
     * 
     * @return the provisioningState value.
     */
    public ProvisioningState provisioningState() {
        return this.provisioningState;
    }

    /**
     * Get the version property: The Azure IoT Operations version.
     * 
     * @return the version value.
     */
    public String version() {
        return this.version;
    }

    /**
     * Get the schemaRegistryRef property: The reference to the Schema Registry for this AIO Instance.
     * 
     * @return the schemaRegistryRef value.
     */
    public SchemaRegistryRef schemaRegistryRef() {
        return this.schemaRegistryRef;
    }

    /**
     * Set the schemaRegistryRef property: The reference to the Schema Registry for this AIO Instance.
     * 
     * @param schemaRegistryRef the schemaRegistryRef value to set.
     * @return the InstanceProperties object itself.
     */
    public InstanceProperties withSchemaRegistryRef(SchemaRegistryRef schemaRegistryRef) {
        this.schemaRegistryRef = schemaRegistryRef;
        return this;
    }

    /**
     * Get the features property: The features of the AIO Instance.
     * 
     * @return the features value.
     */
    public Map<String, InstanceFeature> features() {
        return this.features;
    }

    /**
     * Set the features property: The features of the AIO Instance.
     * 
     * @param features the features value to set.
     * @return the InstanceProperties object itself.
     */
    public InstanceProperties withFeatures(Map<String, InstanceFeature> features) {
        this.features = features;
        return this;
    }

    /**
     * Validates the instance.
     * 
     * @throws IllegalArgumentException thrown if the instance is not valid.
     */
    public void validate() {
        if (schemaRegistryRef() == null) {
            throw LOGGER.atError()
                .log(new IllegalArgumentException(
                    "Missing required property schemaRegistryRef in model InstanceProperties"));
        } else {
            schemaRegistryRef().validate();
        }
        if (features() != null) {
            features().values().forEach(e -> {
                if (e != null) {
                    e.validate();
                }
            });
        }
    }

    private static final ClientLogger LOGGER = new ClientLogger(InstanceProperties.class);

    /**
     * {@inheritDoc}
     */
    @Override
    public JsonWriter toJson(JsonWriter jsonWriter) throws IOException {
        jsonWriter.writeStartObject();
        jsonWriter.writeJsonField("schemaRegistryRef", this.schemaRegistryRef);
        jsonWriter.writeStringField("description", this.description);
        jsonWriter.writeMapField("features", this.features, (writer, element) -> writer.writeJson(element));
        return jsonWriter.writeEndObject();
    }

    /**
     * Reads an instance of InstanceProperties from the JsonReader.
     * 
     * @param jsonReader The JsonReader being read.
     * @return An instance of InstanceProperties if the JsonReader was pointing to an instance of it, or null if it was
     * pointing to JSON null.
     * @throws IllegalStateException If the deserialized JSON object was missing any required properties.
     * @throws IOException If an error occurs while reading the InstanceProperties.
     */
    public static InstanceProperties fromJson(JsonReader jsonReader) throws IOException {
        return jsonReader.readObject(reader -> {
            InstanceProperties deserializedInstanceProperties = new InstanceProperties();
            while (reader.nextToken() != JsonToken.END_OBJECT) {
                String fieldName = reader.getFieldName();
                reader.nextToken();

                if ("schemaRegistryRef".equals(fieldName)) {
                    deserializedInstanceProperties.schemaRegistryRef = SchemaRegistryRef.fromJson(reader);
                } else if ("description".equals(fieldName)) {
                    deserializedInstanceProperties.description = reader.getString();
                } else if ("provisioningState".equals(fieldName)) {
                    deserializedInstanceProperties.provisioningState = ProvisioningState.fromString(reader.getString());
                } else if ("version".equals(fieldName)) {
                    deserializedInstanceProperties.version = reader.getString();
                } else if ("features".equals(fieldName)) {
                    Map<String, InstanceFeature> features
                        = reader.readMap(reader1 -> InstanceFeature.fromJson(reader1));
                    deserializedInstanceProperties.features = features;
                } else {
                    reader.skipChildren();
                }
            }

            return deserializedInstanceProperties;
        });
    }
}
