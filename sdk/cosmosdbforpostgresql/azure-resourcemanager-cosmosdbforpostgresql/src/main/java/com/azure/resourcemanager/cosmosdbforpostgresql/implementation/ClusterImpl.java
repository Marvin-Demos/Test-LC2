// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.
// Code generated by Microsoft (R) AutoRest Code Generator.

package com.azure.resourcemanager.cosmosdbforpostgresql.implementation;

import com.azure.core.management.Region;
import com.azure.core.management.SystemData;
import com.azure.core.util.Context;
import com.azure.resourcemanager.cosmosdbforpostgresql.fluent.models.ClusterInner;
import com.azure.resourcemanager.cosmosdbforpostgresql.models.AadEnabledEnum;
import com.azure.resourcemanager.cosmosdbforpostgresql.models.AuthConfig;
import com.azure.resourcemanager.cosmosdbforpostgresql.models.Cluster;
import com.azure.resourcemanager.cosmosdbforpostgresql.models.ClusterForUpdate;
import com.azure.resourcemanager.cosmosdbforpostgresql.models.DataEncryption;
import com.azure.resourcemanager.cosmosdbforpostgresql.models.IdentityProperties;
import com.azure.resourcemanager.cosmosdbforpostgresql.models.MaintenanceWindow;
import com.azure.resourcemanager.cosmosdbforpostgresql.models.PasswordEnabledEnum;
import com.azure.resourcemanager.cosmosdbforpostgresql.models.PromoteRequest;
import com.azure.resourcemanager.cosmosdbforpostgresql.models.ServerNameItem;
import com.azure.resourcemanager.cosmosdbforpostgresql.models.SimplePrivateEndpointConnection;
import java.time.OffsetDateTime;
import java.util.Collections;
import java.util.List;
import java.util.Map;

public final class ClusterImpl implements Cluster, Cluster.Definition, Cluster.Update {
    private ClusterInner innerObject;

    private final com.azure.resourcemanager.cosmosdbforpostgresql.CosmosDBForPostgreSqlManager serviceManager;

    public String id() {
        return this.innerModel().id();
    }

    public String name() {
        return this.innerModel().name();
    }

    public String type() {
        return this.innerModel().type();
    }

    public String location() {
        return this.innerModel().location();
    }

    public Map<String, String> tags() {
        Map<String, String> inner = this.innerModel().tags();
        if (inner != null) {
            return Collections.unmodifiableMap(inner);
        } else {
            return Collections.emptyMap();
        }
    }

    public IdentityProperties identity() {
        return this.innerModel().identity();
    }

    public SystemData systemData() {
        return this.innerModel().systemData();
    }

    public AadEnabledEnum aadAuthEnabled() {
        return this.innerModel().aadAuthEnabled();
    }

    public String administratorLogin() {
        return this.innerModel().administratorLogin();
    }

    public String administratorLoginPassword() {
        return this.innerModel().administratorLoginPassword();
    }

    public DataEncryption dataEncryption() {
        return this.innerModel().dataEncryption();
    }

    public String provisioningState() {
        return this.innerModel().provisioningState();
    }

    public String state() {
        return this.innerModel().state();
    }

    public String postgresqlVersion() {
        return this.innerModel().postgresqlVersion();
    }

    public String citusVersion() {
        return this.innerModel().citusVersion();
    }

    public MaintenanceWindow maintenanceWindow() {
        return this.innerModel().maintenanceWindow();
    }

    public String preferredPrimaryZone() {
        return this.innerModel().preferredPrimaryZone();
    }

    public Boolean enableShardsOnCoordinator() {
        return this.innerModel().enableShardsOnCoordinator();
    }

    public Boolean enableHa() {
        return this.innerModel().enableHa();
    }

    public String coordinatorServerEdition() {
        return this.innerModel().coordinatorServerEdition();
    }

    public Integer coordinatorStorageQuotaInMb() {
        return this.innerModel().coordinatorStorageQuotaInMb();
    }

    public Integer coordinatorVCores() {
        return this.innerModel().coordinatorVCores();
    }

    public Boolean coordinatorEnablePublicIpAccess() {
        return this.innerModel().coordinatorEnablePublicIpAccess();
    }

    public String nodeServerEdition() {
        return this.innerModel().nodeServerEdition();
    }

    public Integer nodeCount() {
        return this.innerModel().nodeCount();
    }

    public Integer nodeStorageQuotaInMb() {
        return this.innerModel().nodeStorageQuotaInMb();
    }

    public Integer nodeVCores() {
        return this.innerModel().nodeVCores();
    }

    public Boolean nodeEnablePublicIpAccess() {
        return this.innerModel().nodeEnablePublicIpAccess();
    }

    public List<ServerNameItem> serverNames() {
        List<ServerNameItem> inner = this.innerModel().serverNames();
        if (inner != null) {
            return Collections.unmodifiableList(inner);
        } else {
            return Collections.emptyList();
        }
    }

    public String sourceResourceId() {
        return this.innerModel().sourceResourceId();
    }

    public String sourceLocation() {
        return this.innerModel().sourceLocation();
    }

    public PasswordEnabledEnum passwordEnabled() {
        return this.innerModel().passwordEnabled();
    }

    public OffsetDateTime pointInTimeUtc() {
        return this.innerModel().pointInTimeUtc();
    }

    public List<String> readReplicas() {
        List<String> inner = this.innerModel().readReplicas();
        if (inner != null) {
            return Collections.unmodifiableList(inner);
        } else {
            return Collections.emptyList();
        }
    }

    public OffsetDateTime earliestRestoreTime() {
        return this.innerModel().earliestRestoreTime();
    }

    public List<SimplePrivateEndpointConnection> privateEndpointConnections() {
        List<SimplePrivateEndpointConnection> inner = this.innerModel().privateEndpointConnections();
        if (inner != null) {
            return Collections.unmodifiableList(inner);
        } else {
            return Collections.emptyList();
        }
    }

    public String databaseName() {
        return this.innerModel().databaseName();
    }

    public Boolean enableGeoBackup() {
        return this.innerModel().enableGeoBackup();
    }

    public AuthConfig authConfig() {
        return this.innerModel().authConfig();
    }

    public Region region() {
        return Region.fromName(this.regionName());
    }

    public String regionName() {
        return this.location();
    }

    public String resourceGroupName() {
        return resourceGroupName;
    }

    public ClusterInner innerModel() {
        return this.innerObject;
    }

    private com.azure.resourcemanager.cosmosdbforpostgresql.CosmosDBForPostgreSqlManager manager() {
        return this.serviceManager;
    }

    private String resourceGroupName;

    private String clusterName;

    private ClusterForUpdate updateParameters;

    public ClusterImpl withExistingResourceGroup(String resourceGroupName) {
        this.resourceGroupName = resourceGroupName;
        return this;
    }

    public Cluster create() {
        this.innerObject = serviceManager.serviceClient()
            .getClusters()
            .create(resourceGroupName, clusterName, this.innerModel(), Context.NONE);
        return this;
    }

    public Cluster create(Context context) {
        this.innerObject = serviceManager.serviceClient()
            .getClusters()
            .create(resourceGroupName, clusterName, this.innerModel(), context);
        return this;
    }

    ClusterImpl(String name,
        com.azure.resourcemanager.cosmosdbforpostgresql.CosmosDBForPostgreSqlManager serviceManager) {
        this.innerObject = new ClusterInner();
        this.serviceManager = serviceManager;
        this.clusterName = name;
    }

    public ClusterImpl update() {
        this.updateParameters = new ClusterForUpdate();
        return this;
    }

    public Cluster apply() {
        this.innerObject = serviceManager.serviceClient()
            .getClusters()
            .update(resourceGroupName, clusterName, updateParameters, Context.NONE);
        return this;
    }

    public Cluster apply(Context context) {
        this.innerObject = serviceManager.serviceClient()
            .getClusters()
            .update(resourceGroupName, clusterName, updateParameters, context);
        return this;
    }

    ClusterImpl(ClusterInner innerObject,
        com.azure.resourcemanager.cosmosdbforpostgresql.CosmosDBForPostgreSqlManager serviceManager) {
        this.innerObject = innerObject;
        this.serviceManager = serviceManager;
        this.resourceGroupName = ResourceManagerUtils.getValueFromIdByName(innerObject.id(), "resourceGroups");
        this.clusterName = ResourceManagerUtils.getValueFromIdByName(innerObject.id(), "serverGroupsv2");
    }

    public Cluster refresh() {
        this.innerObject = serviceManager.serviceClient()
            .getClusters()
            .getByResourceGroupWithResponse(resourceGroupName, clusterName, Context.NONE)
            .getValue();
        return this;
    }

    public Cluster refresh(Context context) {
        this.innerObject = serviceManager.serviceClient()
            .getClusters()
            .getByResourceGroupWithResponse(resourceGroupName, clusterName, context)
            .getValue();
        return this;
    }

    public void restart() {
        serviceManager.clusters().restart(resourceGroupName, clusterName);
    }

    public void restart(Context context) {
        serviceManager.clusters().restart(resourceGroupName, clusterName, context);
    }

    public void start() {
        serviceManager.clusters().start(resourceGroupName, clusterName);
    }

    public void start(Context context) {
        serviceManager.clusters().start(resourceGroupName, clusterName, context);
    }

    public void stop() {
        serviceManager.clusters().stop(resourceGroupName, clusterName);
    }

    public void stop(Context context) {
        serviceManager.clusters().stop(resourceGroupName, clusterName, context);
    }

    public void promoteReadReplica() {
        serviceManager.clusters().promoteReadReplica(resourceGroupName, clusterName);
    }

    public void promoteReadReplica(PromoteRequest promoteRequest, Context context) {
        serviceManager.clusters().promoteReadReplica(resourceGroupName, clusterName, promoteRequest, context);
    }

    public ClusterImpl withRegion(Region location) {
        this.innerModel().withLocation(location.toString());
        return this;
    }

    public ClusterImpl withRegion(String location) {
        this.innerModel().withLocation(location);
        return this;
    }

    public ClusterImpl withTags(Map<String, String> tags) {
        if (isInCreateMode()) {
            this.innerModel().withTags(tags);
            return this;
        } else {
            this.updateParameters.withTags(tags);
            return this;
        }
    }

    public ClusterImpl withIdentity(IdentityProperties identity) {
        if (isInCreateMode()) {
            this.innerModel().withIdentity(identity);
            return this;
        } else {
            this.updateParameters.withIdentity(identity);
            return this;
        }
    }

    public ClusterImpl withAdministratorLoginPassword(String administratorLoginPassword) {
        if (isInCreateMode()) {
            this.innerModel().withAdministratorLoginPassword(administratorLoginPassword);
            return this;
        } else {
            this.updateParameters.withAdministratorLoginPassword(administratorLoginPassword);
            return this;
        }
    }

    public ClusterImpl withDataEncryption(DataEncryption dataEncryption) {
        this.innerModel().withDataEncryption(dataEncryption);
        return this;
    }

    public ClusterImpl withPostgresqlVersion(String postgresqlVersion) {
        if (isInCreateMode()) {
            this.innerModel().withPostgresqlVersion(postgresqlVersion);
            return this;
        } else {
            this.updateParameters.withPostgresqlVersion(postgresqlVersion);
            return this;
        }
    }

    public ClusterImpl withCitusVersion(String citusVersion) {
        if (isInCreateMode()) {
            this.innerModel().withCitusVersion(citusVersion);
            return this;
        } else {
            this.updateParameters.withCitusVersion(citusVersion);
            return this;
        }
    }

    public ClusterImpl withMaintenanceWindow(MaintenanceWindow maintenanceWindow) {
        if (isInCreateMode()) {
            this.innerModel().withMaintenanceWindow(maintenanceWindow);
            return this;
        } else {
            this.updateParameters.withMaintenanceWindow(maintenanceWindow);
            return this;
        }
    }

    public ClusterImpl withPreferredPrimaryZone(String preferredPrimaryZone) {
        if (isInCreateMode()) {
            this.innerModel().withPreferredPrimaryZone(preferredPrimaryZone);
            return this;
        } else {
            this.updateParameters.withPreferredPrimaryZone(preferredPrimaryZone);
            return this;
        }
    }

    public ClusterImpl withEnableShardsOnCoordinator(Boolean enableShardsOnCoordinator) {
        if (isInCreateMode()) {
            this.innerModel().withEnableShardsOnCoordinator(enableShardsOnCoordinator);
            return this;
        } else {
            this.updateParameters.withEnableShardsOnCoordinator(enableShardsOnCoordinator);
            return this;
        }
    }

    public ClusterImpl withEnableHa(Boolean enableHa) {
        if (isInCreateMode()) {
            this.innerModel().withEnableHa(enableHa);
            return this;
        } else {
            this.updateParameters.withEnableHa(enableHa);
            return this;
        }
    }

    public ClusterImpl withCoordinatorServerEdition(String coordinatorServerEdition) {
        if (isInCreateMode()) {
            this.innerModel().withCoordinatorServerEdition(coordinatorServerEdition);
            return this;
        } else {
            this.updateParameters.withCoordinatorServerEdition(coordinatorServerEdition);
            return this;
        }
    }

    public ClusterImpl withCoordinatorStorageQuotaInMb(Integer coordinatorStorageQuotaInMb) {
        if (isInCreateMode()) {
            this.innerModel().withCoordinatorStorageQuotaInMb(coordinatorStorageQuotaInMb);
            return this;
        } else {
            this.updateParameters.withCoordinatorStorageQuotaInMb(coordinatorStorageQuotaInMb);
            return this;
        }
    }

    public ClusterImpl withCoordinatorVCores(Integer coordinatorVCores) {
        if (isInCreateMode()) {
            this.innerModel().withCoordinatorVCores(coordinatorVCores);
            return this;
        } else {
            this.updateParameters.withCoordinatorVCores(coordinatorVCores);
            return this;
        }
    }

    public ClusterImpl withCoordinatorEnablePublicIpAccess(Boolean coordinatorEnablePublicIpAccess) {
        if (isInCreateMode()) {
            this.innerModel().withCoordinatorEnablePublicIpAccess(coordinatorEnablePublicIpAccess);
            return this;
        } else {
            this.updateParameters.withCoordinatorEnablePublicIpAccess(coordinatorEnablePublicIpAccess);
            return this;
        }
    }

    public ClusterImpl withNodeServerEdition(String nodeServerEdition) {
        if (isInCreateMode()) {
            this.innerModel().withNodeServerEdition(nodeServerEdition);
            return this;
        } else {
            this.updateParameters.withNodeServerEdition(nodeServerEdition);
            return this;
        }
    }

    public ClusterImpl withNodeCount(Integer nodeCount) {
        if (isInCreateMode()) {
            this.innerModel().withNodeCount(nodeCount);
            return this;
        } else {
            this.updateParameters.withNodeCount(nodeCount);
            return this;
        }
    }

    public ClusterImpl withNodeStorageQuotaInMb(Integer nodeStorageQuotaInMb) {
        if (isInCreateMode()) {
            this.innerModel().withNodeStorageQuotaInMb(nodeStorageQuotaInMb);
            return this;
        } else {
            this.updateParameters.withNodeStorageQuotaInMb(nodeStorageQuotaInMb);
            return this;
        }
    }

    public ClusterImpl withNodeVCores(Integer nodeVCores) {
        if (isInCreateMode()) {
            this.innerModel().withNodeVCores(nodeVCores);
            return this;
        } else {
            this.updateParameters.withNodeVCores(nodeVCores);
            return this;
        }
    }

    public ClusterImpl withNodeEnablePublicIpAccess(Boolean nodeEnablePublicIpAccess) {
        this.innerModel().withNodeEnablePublicIpAccess(nodeEnablePublicIpAccess);
        return this;
    }

    public ClusterImpl withSourceResourceId(String sourceResourceId) {
        this.innerModel().withSourceResourceId(sourceResourceId);
        return this;
    }

    public ClusterImpl withSourceLocation(String sourceLocation) {
        this.innerModel().withSourceLocation(sourceLocation);
        return this;
    }

    public ClusterImpl withPointInTimeUtc(OffsetDateTime pointInTimeUtc) {
        this.innerModel().withPointInTimeUtc(pointInTimeUtc);
        return this;
    }

    public ClusterImpl withDatabaseName(String databaseName) {
        this.innerModel().withDatabaseName(databaseName);
        return this;
    }

    public ClusterImpl withEnableGeoBackup(Boolean enableGeoBackup) {
        this.innerModel().withEnableGeoBackup(enableGeoBackup);
        return this;
    }

    public ClusterImpl withAuthConfig(AuthConfig authConfig) {
        this.innerModel().withAuthConfig(authConfig);
        return this;
    }

    private boolean isInCreateMode() {
        return this.innerModel().id() == null;
    }
}
