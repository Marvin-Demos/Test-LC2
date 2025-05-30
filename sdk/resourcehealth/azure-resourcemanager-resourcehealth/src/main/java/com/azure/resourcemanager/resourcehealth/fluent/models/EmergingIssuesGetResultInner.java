// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.
// Code generated by Microsoft (R) AutoRest Code Generator.

package com.azure.resourcemanager.resourcehealth.fluent.models;

import com.azure.core.annotation.Fluent;
import com.azure.core.management.ProxyResource;
import com.azure.core.management.SystemData;
import com.azure.json.JsonReader;
import com.azure.json.JsonToken;
import com.azure.json.JsonWriter;
import com.azure.resourcemanager.resourcehealth.models.StatusActiveEvent;
import com.azure.resourcemanager.resourcehealth.models.StatusBanner;
import java.io.IOException;
import java.time.OffsetDateTime;
import java.util.List;

/**
 * The Get EmergingIssues operation response.
 */
@Fluent
public final class EmergingIssuesGetResultInner extends ProxyResource {
    /*
     * The emerging issue entity properties.
     */
    private EmergingIssue innerProperties;

    /*
     * Azure Resource Manager metadata containing createdBy and modifiedBy information.
     */
    private SystemData systemData;

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
     * Creates an instance of EmergingIssuesGetResultInner class.
     */
    public EmergingIssuesGetResultInner() {
    }

    /**
     * Get the innerProperties property: The emerging issue entity properties.
     * 
     * @return the innerProperties value.
     */
    private EmergingIssue innerProperties() {
        return this.innerProperties;
    }

    /**
     * Get the systemData property: Azure Resource Manager metadata containing createdBy and modifiedBy information.
     * 
     * @return the systemData value.
     */
    public SystemData systemData() {
        return this.systemData;
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
     * Get the refreshTimestamp property: Timestamp for when last time refreshed for ongoing emerging issue.
     * 
     * @return the refreshTimestamp value.
     */
    public OffsetDateTime refreshTimestamp() {
        return this.innerProperties() == null ? null : this.innerProperties().refreshTimestamp();
    }

    /**
     * Set the refreshTimestamp property: Timestamp for when last time refreshed for ongoing emerging issue.
     * 
     * @param refreshTimestamp the refreshTimestamp value to set.
     * @return the EmergingIssuesGetResultInner object itself.
     */
    public EmergingIssuesGetResultInner withRefreshTimestamp(OffsetDateTime refreshTimestamp) {
        if (this.innerProperties() == null) {
            this.innerProperties = new EmergingIssue();
        }
        this.innerProperties().withRefreshTimestamp(refreshTimestamp);
        return this;
    }

    /**
     * Get the statusBanners property: The list of emerging issues of banner type.
     * 
     * @return the statusBanners value.
     */
    public List<StatusBanner> statusBanners() {
        return this.innerProperties() == null ? null : this.innerProperties().statusBanners();
    }

    /**
     * Set the statusBanners property: The list of emerging issues of banner type.
     * 
     * @param statusBanners the statusBanners value to set.
     * @return the EmergingIssuesGetResultInner object itself.
     */
    public EmergingIssuesGetResultInner withStatusBanners(List<StatusBanner> statusBanners) {
        if (this.innerProperties() == null) {
            this.innerProperties = new EmergingIssue();
        }
        this.innerProperties().withStatusBanners(statusBanners);
        return this;
    }

    /**
     * Get the statusActiveEvents property: The list of emerging issues of active event type.
     * 
     * @return the statusActiveEvents value.
     */
    public List<StatusActiveEvent> statusActiveEvents() {
        return this.innerProperties() == null ? null : this.innerProperties().statusActiveEvents();
    }

    /**
     * Set the statusActiveEvents property: The list of emerging issues of active event type.
     * 
     * @param statusActiveEvents the statusActiveEvents value to set.
     * @return the EmergingIssuesGetResultInner object itself.
     */
    public EmergingIssuesGetResultInner withStatusActiveEvents(List<StatusActiveEvent> statusActiveEvents) {
        if (this.innerProperties() == null) {
            this.innerProperties = new EmergingIssue();
        }
        this.innerProperties().withStatusActiveEvents(statusActiveEvents);
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
     * Reads an instance of EmergingIssuesGetResultInner from the JsonReader.
     * 
     * @param jsonReader The JsonReader being read.
     * @return An instance of EmergingIssuesGetResultInner if the JsonReader was pointing to an instance of it, or null
     * if it was pointing to JSON null.
     * @throws IllegalStateException If the deserialized JSON object was missing any required properties.
     * @throws IOException If an error occurs while reading the EmergingIssuesGetResultInner.
     */
    public static EmergingIssuesGetResultInner fromJson(JsonReader jsonReader) throws IOException {
        return jsonReader.readObject(reader -> {
            EmergingIssuesGetResultInner deserializedEmergingIssuesGetResultInner = new EmergingIssuesGetResultInner();
            while (reader.nextToken() != JsonToken.END_OBJECT) {
                String fieldName = reader.getFieldName();
                reader.nextToken();

                if ("id".equals(fieldName)) {
                    deserializedEmergingIssuesGetResultInner.id = reader.getString();
                } else if ("name".equals(fieldName)) {
                    deserializedEmergingIssuesGetResultInner.name = reader.getString();
                } else if ("type".equals(fieldName)) {
                    deserializedEmergingIssuesGetResultInner.type = reader.getString();
                } else if ("properties".equals(fieldName)) {
                    deserializedEmergingIssuesGetResultInner.innerProperties = EmergingIssue.fromJson(reader);
                } else if ("systemData".equals(fieldName)) {
                    deserializedEmergingIssuesGetResultInner.systemData = SystemData.fromJson(reader);
                } else {
                    reader.skipChildren();
                }
            }

            return deserializedEmergingIssuesGetResultInner;
        });
    }
}
