// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.
// Code generated by Microsoft (R) AutoRest Code Generator.

package com.azure.resourcemanager.storage.models;

import com.azure.core.annotation.Immutable;
import com.azure.json.JsonReader;
import com.azure.json.JsonSerializable;
import com.azure.json.JsonToken;
import com.azure.json.JsonWriter;
import java.io.IOException;

/**
 * Usage of provisioned storage, IOPS, bandwidth and number of file shares across all live shares and soft-deleted
 * shares in the account.
 */
@Immutable
public final class AccountUsage implements JsonSerializable<AccountUsage> {
    /*
     * Usage of provisioned storage, IOPS, bandwidth and number of file shares across all live shares or soft-deleted
     * shares in the account.
     */
    private AccountUsageElements liveShares;

    /*
     * Usage of provisioned storage, IOPS, bandwidth and number of file shares across all live shares or soft-deleted
     * shares in the account.
     */
    private AccountUsageElements softDeletedShares;

    /**
     * Creates an instance of AccountUsage class.
     */
    public AccountUsage() {
    }

    /**
     * Get the liveShares property: Usage of provisioned storage, IOPS, bandwidth and number of file shares across all
     * live shares or soft-deleted shares in the account.
     * 
     * @return the liveShares value.
     */
    public AccountUsageElements liveShares() {
        return this.liveShares;
    }

    /**
     * Get the softDeletedShares property: Usage of provisioned storage, IOPS, bandwidth and number of file shares
     * across all live shares or soft-deleted shares in the account.
     * 
     * @return the softDeletedShares value.
     */
    public AccountUsageElements softDeletedShares() {
        return this.softDeletedShares;
    }

    /**
     * Validates the instance.
     * 
     * @throws IllegalArgumentException thrown if the instance is not valid.
     */
    public void validate() {
        if (liveShares() != null) {
            liveShares().validate();
        }
        if (softDeletedShares() != null) {
            softDeletedShares().validate();
        }
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public JsonWriter toJson(JsonWriter jsonWriter) throws IOException {
        jsonWriter.writeStartObject();
        return jsonWriter.writeEndObject();
    }

    /**
     * Reads an instance of AccountUsage from the JsonReader.
     * 
     * @param jsonReader The JsonReader being read.
     * @return An instance of AccountUsage if the JsonReader was pointing to an instance of it, or null if it was
     * pointing to JSON null.
     * @throws IOException If an error occurs while reading the AccountUsage.
     */
    public static AccountUsage fromJson(JsonReader jsonReader) throws IOException {
        return jsonReader.readObject(reader -> {
            AccountUsage deserializedAccountUsage = new AccountUsage();
            while (reader.nextToken() != JsonToken.END_OBJECT) {
                String fieldName = reader.getFieldName();
                reader.nextToken();

                if ("liveShares".equals(fieldName)) {
                    deserializedAccountUsage.liveShares = AccountUsageElements.fromJson(reader);
                } else if ("softDeletedShares".equals(fieldName)) {
                    deserializedAccountUsage.softDeletedShares = AccountUsageElements.fromJson(reader);
                } else {
                    reader.skipChildren();
                }
            }

            return deserializedAccountUsage;
        });
    }
}
