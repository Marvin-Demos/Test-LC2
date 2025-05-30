// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.
// Code generated by Microsoft (R) AutoRest Code Generator.

package com.azure.resourcemanager.logic.models;

import com.azure.core.annotation.Fluent;
import com.azure.core.management.exception.ManagementError;
import com.azure.core.util.CoreUtils;
import com.azure.json.JsonReader;
import com.azure.json.JsonSerializable;
import com.azure.json.JsonToken;
import com.azure.json.JsonWriter;
import java.io.IOException;
import java.time.OffsetDateTime;
import java.time.format.DateTimeFormatter;

/**
 * The retry history.
 */
@Fluent
public final class RetryHistory implements JsonSerializable<RetryHistory> {
    /*
     * Gets the start time.
     */
    private OffsetDateTime startTime;

    /*
     * Gets the end time.
     */
    private OffsetDateTime endTime;

    /*
     * Gets the status code.
     */
    private String code;

    /*
     * Gets the client request Id.
     */
    private String clientRequestId;

    /*
     * Gets the service request Id.
     */
    private String serviceRequestId;

    /*
     * Gets the error response.
     */
    private ManagementError error;

    /**
     * Creates an instance of RetryHistory class.
     */
    public RetryHistory() {
    }

    /**
     * Get the startTime property: Gets the start time.
     * 
     * @return the startTime value.
     */
    public OffsetDateTime startTime() {
        return this.startTime;
    }

    /**
     * Set the startTime property: Gets the start time.
     * 
     * @param startTime the startTime value to set.
     * @return the RetryHistory object itself.
     */
    public RetryHistory withStartTime(OffsetDateTime startTime) {
        this.startTime = startTime;
        return this;
    }

    /**
     * Get the endTime property: Gets the end time.
     * 
     * @return the endTime value.
     */
    public OffsetDateTime endTime() {
        return this.endTime;
    }

    /**
     * Set the endTime property: Gets the end time.
     * 
     * @param endTime the endTime value to set.
     * @return the RetryHistory object itself.
     */
    public RetryHistory withEndTime(OffsetDateTime endTime) {
        this.endTime = endTime;
        return this;
    }

    /**
     * Get the code property: Gets the status code.
     * 
     * @return the code value.
     */
    public String code() {
        return this.code;
    }

    /**
     * Set the code property: Gets the status code.
     * 
     * @param code the code value to set.
     * @return the RetryHistory object itself.
     */
    public RetryHistory withCode(String code) {
        this.code = code;
        return this;
    }

    /**
     * Get the clientRequestId property: Gets the client request Id.
     * 
     * @return the clientRequestId value.
     */
    public String clientRequestId() {
        return this.clientRequestId;
    }

    /**
     * Set the clientRequestId property: Gets the client request Id.
     * 
     * @param clientRequestId the clientRequestId value to set.
     * @return the RetryHistory object itself.
     */
    public RetryHistory withClientRequestId(String clientRequestId) {
        this.clientRequestId = clientRequestId;
        return this;
    }

    /**
     * Get the serviceRequestId property: Gets the service request Id.
     * 
     * @return the serviceRequestId value.
     */
    public String serviceRequestId() {
        return this.serviceRequestId;
    }

    /**
     * Set the serviceRequestId property: Gets the service request Id.
     * 
     * @param serviceRequestId the serviceRequestId value to set.
     * @return the RetryHistory object itself.
     */
    public RetryHistory withServiceRequestId(String serviceRequestId) {
        this.serviceRequestId = serviceRequestId;
        return this;
    }

    /**
     * Get the error property: Gets the error response.
     * 
     * @return the error value.
     */
    public ManagementError error() {
        return this.error;
    }

    /**
     * Set the error property: Gets the error response.
     * 
     * @param error the error value to set.
     * @return the RetryHistory object itself.
     */
    public RetryHistory withError(ManagementError error) {
        this.error = error;
        return this;
    }

    /**
     * Validates the instance.
     * 
     * @throws IllegalArgumentException thrown if the instance is not valid.
     */
    public void validate() {
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public JsonWriter toJson(JsonWriter jsonWriter) throws IOException {
        jsonWriter.writeStartObject();
        jsonWriter.writeStringField("startTime",
            this.startTime == null ? null : DateTimeFormatter.ISO_OFFSET_DATE_TIME.format(this.startTime));
        jsonWriter.writeStringField("endTime",
            this.endTime == null ? null : DateTimeFormatter.ISO_OFFSET_DATE_TIME.format(this.endTime));
        jsonWriter.writeStringField("code", this.code);
        jsonWriter.writeStringField("clientRequestId", this.clientRequestId);
        jsonWriter.writeStringField("serviceRequestId", this.serviceRequestId);
        jsonWriter.writeJsonField("error", this.error);
        return jsonWriter.writeEndObject();
    }

    /**
     * Reads an instance of RetryHistory from the JsonReader.
     * 
     * @param jsonReader The JsonReader being read.
     * @return An instance of RetryHistory if the JsonReader was pointing to an instance of it, or null if it was
     * pointing to JSON null.
     * @throws IOException If an error occurs while reading the RetryHistory.
     */
    public static RetryHistory fromJson(JsonReader jsonReader) throws IOException {
        return jsonReader.readObject(reader -> {
            RetryHistory deserializedRetryHistory = new RetryHistory();
            while (reader.nextToken() != JsonToken.END_OBJECT) {
                String fieldName = reader.getFieldName();
                reader.nextToken();

                if ("startTime".equals(fieldName)) {
                    deserializedRetryHistory.startTime = reader
                        .getNullable(nonNullReader -> CoreUtils.parseBestOffsetDateTime(nonNullReader.getString()));
                } else if ("endTime".equals(fieldName)) {
                    deserializedRetryHistory.endTime = reader
                        .getNullable(nonNullReader -> CoreUtils.parseBestOffsetDateTime(nonNullReader.getString()));
                } else if ("code".equals(fieldName)) {
                    deserializedRetryHistory.code = reader.getString();
                } else if ("clientRequestId".equals(fieldName)) {
                    deserializedRetryHistory.clientRequestId = reader.getString();
                } else if ("serviceRequestId".equals(fieldName)) {
                    deserializedRetryHistory.serviceRequestId = reader.getString();
                } else if ("error".equals(fieldName)) {
                    deserializedRetryHistory.error = ManagementError.fromJson(reader);
                } else {
                    reader.skipChildren();
                }
            }

            return deserializedRetryHistory;
        });
    }
}
