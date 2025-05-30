// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.
// Code generated by Microsoft (R) TypeSpec Code Generator.

package com.azure.resourcemanager.containerservicefleet.fluent.models;

import com.azure.core.annotation.Fluent;
import com.azure.core.util.logging.ClientLogger;
import com.azure.json.JsonReader;
import com.azure.json.JsonSerializable;
import com.azure.json.JsonToken;
import com.azure.json.JsonWriter;
import com.azure.resourcemanager.containerservicefleet.models.ManagedClusterUpdate;
import com.azure.resourcemanager.containerservicefleet.models.UpdateRunProvisioningState;
import com.azure.resourcemanager.containerservicefleet.models.UpdateRunStatus;
import com.azure.resourcemanager.containerservicefleet.models.UpdateRunStrategy;
import java.io.IOException;

/**
 * The properties of the UpdateRun.
 */
@Fluent
public final class UpdateRunProperties implements JsonSerializable<UpdateRunProperties> {
    /*
     * The provisioning state of the UpdateRun resource.
     */
    private UpdateRunProvisioningState provisioningState;

    /*
     * The resource id of the FleetUpdateStrategy resource to reference.
     * 
     * When creating a new run, there are three ways to define a strategy for the run:
     * 1. Define a new strategy in place: Set the "strategy" field.
     * 2. Use an existing strategy: Set the "updateStrategyId" field. (since 2023-08-15-preview)
     * 3. Use the default strategy to update all the members one by one: Leave both "updateStrategyId" and "strategy"
     * unset. (since 2023-08-15-preview)
     * 
     * Setting both "updateStrategyId" and "strategy" is invalid.
     * 
     * UpdateRuns created by "updateStrategyId" snapshot the referenced UpdateStrategy at the time of creation and store
     * it in the "strategy" field.
     * Subsequent changes to the referenced FleetUpdateStrategy resource do not propagate.
     * UpdateRunStrategy changes can be made directly on the "strategy" field before launching the UpdateRun.
     */
    private String updateStrategyId;

    /*
     * The strategy defines the order in which the clusters will be updated.
     * If not set, all members will be updated sequentially. The UpdateRun status will show a single UpdateStage and a
     * single UpdateGroup targeting all members.
     * The strategy of the UpdateRun can be modified until the run is started.
     */
    private UpdateRunStrategy strategy;

    /*
     * The update to be applied to all clusters in the UpdateRun. The managedClusterUpdate can be modified until the run
     * is started.
     */
    private ManagedClusterUpdate managedClusterUpdate;

    /*
     * The status of the UpdateRun.
     */
    private UpdateRunStatus status;

    /*
     * AutoUpgradeProfileId is the id of an auto upgrade profile resource.
     */
    private String autoUpgradeProfileId;

    /**
     * Creates an instance of UpdateRunProperties class.
     */
    public UpdateRunProperties() {
    }

    /**
     * Get the provisioningState property: The provisioning state of the UpdateRun resource.
     * 
     * @return the provisioningState value.
     */
    public UpdateRunProvisioningState provisioningState() {
        return this.provisioningState;
    }

    /**
     * Get the updateStrategyId property: The resource id of the FleetUpdateStrategy resource to reference.
     * 
     * When creating a new run, there are three ways to define a strategy for the run:
     * 1. Define a new strategy in place: Set the "strategy" field.
     * 2. Use an existing strategy: Set the "updateStrategyId" field. (since 2023-08-15-preview)
     * 3. Use the default strategy to update all the members one by one: Leave both "updateStrategyId" and "strategy"
     * unset. (since 2023-08-15-preview)
     * 
     * Setting both "updateStrategyId" and "strategy" is invalid.
     * 
     * UpdateRuns created by "updateStrategyId" snapshot the referenced UpdateStrategy at the time of creation and store
     * it in the "strategy" field.
     * Subsequent changes to the referenced FleetUpdateStrategy resource do not propagate.
     * UpdateRunStrategy changes can be made directly on the "strategy" field before launching the UpdateRun.
     * 
     * @return the updateStrategyId value.
     */
    public String updateStrategyId() {
        return this.updateStrategyId;
    }

    /**
     * Set the updateStrategyId property: The resource id of the FleetUpdateStrategy resource to reference.
     * 
     * When creating a new run, there are three ways to define a strategy for the run:
     * 1. Define a new strategy in place: Set the "strategy" field.
     * 2. Use an existing strategy: Set the "updateStrategyId" field. (since 2023-08-15-preview)
     * 3. Use the default strategy to update all the members one by one: Leave both "updateStrategyId" and "strategy"
     * unset. (since 2023-08-15-preview)
     * 
     * Setting both "updateStrategyId" and "strategy" is invalid.
     * 
     * UpdateRuns created by "updateStrategyId" snapshot the referenced UpdateStrategy at the time of creation and store
     * it in the "strategy" field.
     * Subsequent changes to the referenced FleetUpdateStrategy resource do not propagate.
     * UpdateRunStrategy changes can be made directly on the "strategy" field before launching the UpdateRun.
     * 
     * @param updateStrategyId the updateStrategyId value to set.
     * @return the UpdateRunProperties object itself.
     */
    public UpdateRunProperties withUpdateStrategyId(String updateStrategyId) {
        this.updateStrategyId = updateStrategyId;
        return this;
    }

    /**
     * Get the strategy property: The strategy defines the order in which the clusters will be updated.
     * If not set, all members will be updated sequentially. The UpdateRun status will show a single UpdateStage and a
     * single UpdateGroup targeting all members.
     * The strategy of the UpdateRun can be modified until the run is started.
     * 
     * @return the strategy value.
     */
    public UpdateRunStrategy strategy() {
        return this.strategy;
    }

    /**
     * Set the strategy property: The strategy defines the order in which the clusters will be updated.
     * If not set, all members will be updated sequentially. The UpdateRun status will show a single UpdateStage and a
     * single UpdateGroup targeting all members.
     * The strategy of the UpdateRun can be modified until the run is started.
     * 
     * @param strategy the strategy value to set.
     * @return the UpdateRunProperties object itself.
     */
    public UpdateRunProperties withStrategy(UpdateRunStrategy strategy) {
        this.strategy = strategy;
        return this;
    }

    /**
     * Get the managedClusterUpdate property: The update to be applied to all clusters in the UpdateRun. The
     * managedClusterUpdate can be modified until the run is started.
     * 
     * @return the managedClusterUpdate value.
     */
    public ManagedClusterUpdate managedClusterUpdate() {
        return this.managedClusterUpdate;
    }

    /**
     * Set the managedClusterUpdate property: The update to be applied to all clusters in the UpdateRun. The
     * managedClusterUpdate can be modified until the run is started.
     * 
     * @param managedClusterUpdate the managedClusterUpdate value to set.
     * @return the UpdateRunProperties object itself.
     */
    public UpdateRunProperties withManagedClusterUpdate(ManagedClusterUpdate managedClusterUpdate) {
        this.managedClusterUpdate = managedClusterUpdate;
        return this;
    }

    /**
     * Get the status property: The status of the UpdateRun.
     * 
     * @return the status value.
     */
    public UpdateRunStatus status() {
        return this.status;
    }

    /**
     * Get the autoUpgradeProfileId property: AutoUpgradeProfileId is the id of an auto upgrade profile resource.
     * 
     * @return the autoUpgradeProfileId value.
     */
    public String autoUpgradeProfileId() {
        return this.autoUpgradeProfileId;
    }

    /**
     * Validates the instance.
     * 
     * @throws IllegalArgumentException thrown if the instance is not valid.
     */
    public void validate() {
        if (strategy() != null) {
            strategy().validate();
        }
        if (managedClusterUpdate() == null) {
            throw LOGGER.atError()
                .log(new IllegalArgumentException(
                    "Missing required property managedClusterUpdate in model UpdateRunProperties"));
        } else {
            managedClusterUpdate().validate();
        }
        if (status() != null) {
            status().validate();
        }
    }

    private static final ClientLogger LOGGER = new ClientLogger(UpdateRunProperties.class);

    /**
     * {@inheritDoc}
     */
    @Override
    public JsonWriter toJson(JsonWriter jsonWriter) throws IOException {
        jsonWriter.writeStartObject();
        jsonWriter.writeJsonField("managedClusterUpdate", this.managedClusterUpdate);
        jsonWriter.writeStringField("updateStrategyId", this.updateStrategyId);
        jsonWriter.writeJsonField("strategy", this.strategy);
        return jsonWriter.writeEndObject();
    }

    /**
     * Reads an instance of UpdateRunProperties from the JsonReader.
     * 
     * @param jsonReader The JsonReader being read.
     * @return An instance of UpdateRunProperties if the JsonReader was pointing to an instance of it, or null if it was
     * pointing to JSON null.
     * @throws IllegalStateException If the deserialized JSON object was missing any required properties.
     * @throws IOException If an error occurs while reading the UpdateRunProperties.
     */
    public static UpdateRunProperties fromJson(JsonReader jsonReader) throws IOException {
        return jsonReader.readObject(reader -> {
            UpdateRunProperties deserializedUpdateRunProperties = new UpdateRunProperties();
            while (reader.nextToken() != JsonToken.END_OBJECT) {
                String fieldName = reader.getFieldName();
                reader.nextToken();

                if ("managedClusterUpdate".equals(fieldName)) {
                    deserializedUpdateRunProperties.managedClusterUpdate = ManagedClusterUpdate.fromJson(reader);
                } else if ("provisioningState".equals(fieldName)) {
                    deserializedUpdateRunProperties.provisioningState
                        = UpdateRunProvisioningState.fromString(reader.getString());
                } else if ("updateStrategyId".equals(fieldName)) {
                    deserializedUpdateRunProperties.updateStrategyId = reader.getString();
                } else if ("strategy".equals(fieldName)) {
                    deserializedUpdateRunProperties.strategy = UpdateRunStrategy.fromJson(reader);
                } else if ("status".equals(fieldName)) {
                    deserializedUpdateRunProperties.status = UpdateRunStatus.fromJson(reader);
                } else if ("autoUpgradeProfileId".equals(fieldName)) {
                    deserializedUpdateRunProperties.autoUpgradeProfileId = reader.getString();
                } else {
                    reader.skipChildren();
                }
            }

            return deserializedUpdateRunProperties;
        });
    }
}
