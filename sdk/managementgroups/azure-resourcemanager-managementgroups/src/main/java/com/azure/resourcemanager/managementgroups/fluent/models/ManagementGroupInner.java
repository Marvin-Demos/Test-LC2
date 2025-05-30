// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.
// Code generated by Microsoft (R) AutoRest Code Generator.

package com.azure.resourcemanager.managementgroups.fluent.models;

import com.azure.core.annotation.Fluent;
import com.azure.core.management.ProxyResource;
import com.azure.json.JsonReader;
import com.azure.json.JsonToken;
import com.azure.json.JsonWriter;
import com.azure.resourcemanager.managementgroups.models.ManagementGroupChildInfo;
import com.azure.resourcemanager.managementgroups.models.ManagementGroupDetails;
import java.io.IOException;
import java.util.List;

/**
 * The management group details.
 */
@Fluent
public final class ManagementGroupInner extends ProxyResource {
    /*
     * The generic properties of a management group.
     */
    private ManagementGroupProperties innerProperties;

    /*
     * The type of the resource.
     */
    private String type;

    /*
     * The name of the resource.
     */
    private String name;

    /*
     * Fully qualified resource Id for the resource.
     */
    private String id;

    /**
     * Creates an instance of ManagementGroupInner class.
     */
    public ManagementGroupInner() {
    }

    /**
     * Get the innerProperties property: The generic properties of a management group.
     * 
     * @return the innerProperties value.
     */
    private ManagementGroupProperties innerProperties() {
        return this.innerProperties;
    }

    /**
     * Get the type property: The type of the resource.
     * 
     * @return the type value.
     */
    @Override
    public String type() {
        return this.type;
    }

    /**
     * Get the name property: The name of the resource.
     * 
     * @return the name value.
     */
    @Override
    public String name() {
        return this.name;
    }

    /**
     * Get the id property: Fully qualified resource Id for the resource.
     * 
     * @return the id value.
     */
    @Override
    public String id() {
        return this.id;
    }

    /**
     * Get the tenantId property: The AAD Tenant ID associated with the management group. For example,
     * 00000000-0000-0000-0000-000000000000.
     * 
     * @return the tenantId value.
     */
    public String tenantId() {
        return this.innerProperties() == null ? null : this.innerProperties().tenantId();
    }

    /**
     * Set the tenantId property: The AAD Tenant ID associated with the management group. For example,
     * 00000000-0000-0000-0000-000000000000.
     * 
     * @param tenantId the tenantId value to set.
     * @return the ManagementGroupInner object itself.
     */
    public ManagementGroupInner withTenantId(String tenantId) {
        if (this.innerProperties() == null) {
            this.innerProperties = new ManagementGroupProperties();
        }
        this.innerProperties().withTenantId(tenantId);
        return this;
    }

    /**
     * Get the displayName property: The friendly name of the management group.
     * 
     * @return the displayName value.
     */
    public String displayName() {
        return this.innerProperties() == null ? null : this.innerProperties().displayName();
    }

    /**
     * Set the displayName property: The friendly name of the management group.
     * 
     * @param displayName the displayName value to set.
     * @return the ManagementGroupInner object itself.
     */
    public ManagementGroupInner withDisplayName(String displayName) {
        if (this.innerProperties() == null) {
            this.innerProperties = new ManagementGroupProperties();
        }
        this.innerProperties().withDisplayName(displayName);
        return this;
    }

    /**
     * Get the details property: The details of a management group.
     * 
     * @return the details value.
     */
    public ManagementGroupDetails details() {
        return this.innerProperties() == null ? null : this.innerProperties().details();
    }

    /**
     * Set the details property: The details of a management group.
     * 
     * @param details the details value to set.
     * @return the ManagementGroupInner object itself.
     */
    public ManagementGroupInner withDetails(ManagementGroupDetails details) {
        if (this.innerProperties() == null) {
            this.innerProperties = new ManagementGroupProperties();
        }
        this.innerProperties().withDetails(details);
        return this;
    }

    /**
     * Get the children property: The list of children.
     * 
     * @return the children value.
     */
    public List<ManagementGroupChildInfo> children() {
        return this.innerProperties() == null ? null : this.innerProperties().children();
    }

    /**
     * Set the children property: The list of children.
     * 
     * @param children the children value to set.
     * @return the ManagementGroupInner object itself.
     */
    public ManagementGroupInner withChildren(List<ManagementGroupChildInfo> children) {
        if (this.innerProperties() == null) {
            this.innerProperties = new ManagementGroupProperties();
        }
        this.innerProperties().withChildren(children);
        return this;
    }

    /**
     * Validates the instance.
     * 
     * @throws IllegalArgumentException thrown if the instance is not valid.
     */
    public void validate() {
        if (innerProperties() != null) {
            innerProperties().validate();
        }
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public JsonWriter toJson(JsonWriter jsonWriter) throws IOException {
        jsonWriter.writeStartObject();
        jsonWriter.writeJsonField("properties", this.innerProperties);
        return jsonWriter.writeEndObject();
    }

    /**
     * Reads an instance of ManagementGroupInner from the JsonReader.
     * 
     * @param jsonReader The JsonReader being read.
     * @return An instance of ManagementGroupInner if the JsonReader was pointing to an instance of it, or null if it
     * was pointing to JSON null.
     * @throws IllegalStateException If the deserialized JSON object was missing any required properties.
     * @throws IOException If an error occurs while reading the ManagementGroupInner.
     */
    public static ManagementGroupInner fromJson(JsonReader jsonReader) throws IOException {
        return jsonReader.readObject(reader -> {
            ManagementGroupInner deserializedManagementGroupInner = new ManagementGroupInner();
            while (reader.nextToken() != JsonToken.END_OBJECT) {
                String fieldName = reader.getFieldName();
                reader.nextToken();

                if ("id".equals(fieldName)) {
                    deserializedManagementGroupInner.id = reader.getString();
                } else if ("name".equals(fieldName)) {
                    deserializedManagementGroupInner.name = reader.getString();
                } else if ("type".equals(fieldName)) {
                    deserializedManagementGroupInner.type = reader.getString();
                } else if ("properties".equals(fieldName)) {
                    deserializedManagementGroupInner.innerProperties = ManagementGroupProperties.fromJson(reader);
                } else {
                    reader.skipChildren();
                }
            }

            return deserializedManagementGroupInner;
        });
    }
}
