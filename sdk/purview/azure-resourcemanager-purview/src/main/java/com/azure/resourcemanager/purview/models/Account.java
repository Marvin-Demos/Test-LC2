// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.
// Code generated by Microsoft (R) AutoRest Code Generator.

package com.azure.resourcemanager.purview.models;

import com.azure.core.http.rest.Response;
import com.azure.core.management.Region;
import com.azure.core.management.SystemData;
import com.azure.core.util.Context;
import com.azure.resourcemanager.purview.fluent.models.AccountInner;
import com.azure.resourcemanager.purview.fluent.models.AccountProperties;
import java.time.OffsetDateTime;
import java.util.List;
import java.util.Map;

/**
 * An immutable client-side representation of Account.
 */
public interface Account {
    /**
     * Gets the id property: Fully qualified resource Id for the resource.
     * 
     * @return the id value.
     */
    String id();

    /**
     * Gets the name property: The name of the resource.
     * 
     * @return the name value.
     */
    String name();

    /**
     * Gets the type property: The type of the resource.
     * 
     * @return the type value.
     */
    String type();

    /**
     * Gets the location property: The geo-location where the resource lives.
     * 
     * @return the location value.
     */
    String location();

    /**
     * Gets the tags property: Resource tags.
     * 
     * @return the tags value.
     */
    Map<String, String> tags();

    /**
     * Gets the sku property: Gets or sets the Sku.
     * 
     * @return the sku value.
     */
    AccountSku sku();

    /**
     * Gets the identity property: Identity Info on the tracked resource.
     * 
     * @return the identity value.
     */
    Identity identity();

    /**
     * Gets the systemData property: Metadata pertaining to creation and last modification of the resource.
     * 
     * @return the systemData value.
     */
    SystemData systemData();

    /**
     * Gets the cloudConnectors property: Cloud connectors.
     * External cloud identifier used as part of scanning configuration.
     * 
     * @return the cloudConnectors value.
     */
    CloudConnectors cloudConnectors();

    /**
     * Gets the createdAt property: Gets the time at which the entity was created.
     * 
     * @return the createdAt value.
     */
    OffsetDateTime createdAt();

    /**
     * Gets the createdBy property: Gets the creator of the entity.
     * 
     * @return the createdBy value.
     */
    String createdBy();

    /**
     * Gets the createdByObjectId property: Gets the creators of the entity's object id.
     * 
     * @return the createdByObjectId value.
     */
    String createdByObjectId();

    /**
     * Gets the endpoints property: The URIs that are the public endpoints of the account.
     * 
     * @return the endpoints value.
     */
    AccountPropertiesEndpoints endpoints();

    /**
     * Gets the friendlyName property: Gets or sets the friendly name.
     * 
     * @return the friendlyName value.
     */
    String friendlyName();

    /**
     * Gets the managedResourceGroupName property: Gets or sets the managed resource group name.
     * 
     * @return the managedResourceGroupName value.
     */
    String managedResourceGroupName();

    /**
     * Gets the managedResources property: Gets the resource identifiers of the managed resources.
     * 
     * @return the managedResources value.
     */
    AccountPropertiesManagedResources managedResources();

    /**
     * Gets the privateEndpointConnections property: Gets the private endpoint connections information.
     * 
     * @return the privateEndpointConnections value.
     */
    List<PrivateEndpointConnection> privateEndpointConnections();

    /**
     * Gets the provisioningState property: Gets or sets the state of the provisioning.
     * 
     * @return the provisioningState value.
     */
    ProvisioningState provisioningState();

    /**
     * Gets the publicNetworkAccess property: Gets or sets the public network access.
     * 
     * @return the publicNetworkAccess value.
     */
    PublicNetworkAccess publicNetworkAccess();

    /**
     * Gets the region of the resource.
     * 
     * @return the region of the resource.
     */
    Region region();

    /**
     * Gets the name of the resource region.
     * 
     * @return the name of the resource region.
     */
    String regionName();

    /**
     * Gets the name of the resource group.
     * 
     * @return the name of the resource group.
     */
    String resourceGroupName();

    /**
     * Gets the inner com.azure.resourcemanager.purview.fluent.models.AccountInner object.
     * 
     * @return the inner object.
     */
    AccountInner innerModel();

    /**
     * The entirety of the Account definition.
     */
    interface Definition extends DefinitionStages.Blank, DefinitionStages.WithLocation,
        DefinitionStages.WithResourceGroup, DefinitionStages.WithCreate {
    }

    /**
     * The Account definition stages.
     */
    interface DefinitionStages {
        /**
         * The first stage of the Account definition.
         */
        interface Blank extends WithLocation {
        }

        /**
         * The stage of the Account definition allowing to specify location.
         */
        interface WithLocation {
            /**
             * Specifies the region for the resource.
             * 
             * @param location The geo-location where the resource lives.
             * @return the next definition stage.
             */
            WithResourceGroup withRegion(Region location);

            /**
             * Specifies the region for the resource.
             * 
             * @param location The geo-location where the resource lives.
             * @return the next definition stage.
             */
            WithResourceGroup withRegion(String location);
        }

        /**
         * The stage of the Account definition allowing to specify parent resource.
         */
        interface WithResourceGroup {
            /**
             * Specifies resourceGroupName.
             * 
             * @param resourceGroupName The resource group name.
             * @return the next definition stage.
             */
            WithCreate withExistingResourceGroup(String resourceGroupName);
        }

        /**
         * The stage of the Account definition which contains all the minimum required properties for the resource to be
         * created, but also allows for any other optional properties to be specified.
         */
        interface WithCreate
            extends DefinitionStages.WithTags, DefinitionStages.WithIdentity, DefinitionStages.WithCloudConnectors,
            DefinitionStages.WithManagedResourceGroupName, DefinitionStages.WithPublicNetworkAccess {
            /**
             * Executes the create request.
             * 
             * @return the created resource.
             */
            Account create();

            /**
             * Executes the create request.
             * 
             * @param context The context to associate with this operation.
             * @return the created resource.
             */
            Account create(Context context);
        }

        /**
         * The stage of the Account definition allowing to specify tags.
         */
        interface WithTags {
            /**
             * Specifies the tags property: Resource tags..
             * 
             * @param tags Resource tags.
             * @return the next definition stage.
             */
            WithCreate withTags(Map<String, String> tags);
        }

        /**
         * The stage of the Account definition allowing to specify identity.
         */
        interface WithIdentity {
            /**
             * Specifies the identity property: Identity Info on the tracked resource.
             * 
             * @param identity Identity Info on the tracked resource.
             * @return the next definition stage.
             */
            WithCreate withIdentity(Identity identity);
        }

        /**
         * The stage of the Account definition allowing to specify cloudConnectors.
         */
        interface WithCloudConnectors {
            /**
             * Specifies the cloudConnectors property: Cloud connectors.
             * External cloud identifier used as part of scanning configuration..
             * 
             * @param cloudConnectors Cloud connectors.
             * External cloud identifier used as part of scanning configuration.
             * @return the next definition stage.
             */
            WithCreate withCloudConnectors(CloudConnectors cloudConnectors);
        }

        /**
         * The stage of the Account definition allowing to specify managedResourceGroupName.
         */
        interface WithManagedResourceGroupName {
            /**
             * Specifies the managedResourceGroupName property: Gets or sets the managed resource group name.
             * 
             * @param managedResourceGroupName Gets or sets the managed resource group name.
             * @return the next definition stage.
             */
            WithCreate withManagedResourceGroupName(String managedResourceGroupName);
        }

        /**
         * The stage of the Account definition allowing to specify publicNetworkAccess.
         */
        interface WithPublicNetworkAccess {
            /**
             * Specifies the publicNetworkAccess property: Gets or sets the public network access..
             * 
             * @param publicNetworkAccess Gets or sets the public network access.
             * @return the next definition stage.
             */
            WithCreate withPublicNetworkAccess(PublicNetworkAccess publicNetworkAccess);
        }
    }

    /**
     * Begins update for the Account resource.
     * 
     * @return the stage of resource update.
     */
    Account.Update update();

    /**
     * The template for Account update.
     */
    interface Update extends UpdateStages.WithTags, UpdateStages.WithIdentity, UpdateStages.WithProperties {
        /**
         * Executes the update request.
         * 
         * @return the updated resource.
         */
        Account apply();

        /**
         * Executes the update request.
         * 
         * @param context The context to associate with this operation.
         * @return the updated resource.
         */
        Account apply(Context context);
    }

    /**
     * The Account update stages.
     */
    interface UpdateStages {
        /**
         * The stage of the Account update allowing to specify tags.
         */
        interface WithTags {
            /**
             * Specifies the tags property: Tags on the azure resource..
             * 
             * @param tags Tags on the azure resource.
             * @return the next definition stage.
             */
            Update withTags(Map<String, String> tags);
        }

        /**
         * The stage of the Account update allowing to specify identity.
         */
        interface WithIdentity {
            /**
             * Specifies the identity property: Identity related info to add/remove userAssignedIdentities..
             * 
             * @param identity Identity related info to add/remove userAssignedIdentities.
             * @return the next definition stage.
             */
            Update withIdentity(Identity identity);
        }

        /**
         * The stage of the Account update allowing to specify properties.
         */
        interface WithProperties {
            /**
             * Specifies the properties property: The account properties..
             * 
             * @param properties The account properties.
             * @return the next definition stage.
             */
            Update withProperties(AccountProperties properties);
        }
    }

    /**
     * Refreshes the resource to sync with Azure.
     * 
     * @return the refreshed resource.
     */
    Account refresh();

    /**
     * Refreshes the resource to sync with Azure.
     * 
     * @param context The context to associate with this operation.
     * @return the refreshed resource.
     */
    Account refresh(Context context);

    /**
     * Lists the keys asynchronous.
     * 
     * List the authorization keys associated with this account.
     * 
     * @param context The context to associate with this operation.
     * @throws IllegalArgumentException thrown if parameters fail the validation.
     * @throws com.azure.core.management.exception.ManagementException thrown if the request is rejected by server.
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent.
     * @return the Account access keys along with {@link Response}.
     */
    Response<AccessKeys> listKeysWithResponse(Context context);

    /**
     * Lists the keys asynchronous.
     * 
     * List the authorization keys associated with this account.
     * 
     * @throws com.azure.core.management.exception.ManagementException thrown if the request is rejected by server.
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent.
     * @return the Account access keys.
     */
    AccessKeys listKeys();

    /**
     * Add the administrator for root collection.
     * 
     * Add the administrator for root collection associated with this account.
     * 
     * @param collectionAdminUpdate The collection admin update payload.
     * @param context The context to associate with this operation.
     * @throws IllegalArgumentException thrown if parameters fail the validation.
     * @throws com.azure.core.management.exception.ManagementException thrown if the request is rejected by server.
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent.
     * @return the {@link Response}.
     */
    Response<Void> addRootCollectionAdminWithResponse(CollectionAdminUpdate collectionAdminUpdate, Context context);

    /**
     * Add the administrator for root collection.
     * 
     * Add the administrator for root collection associated with this account.
     * 
     * @param collectionAdminUpdate The collection admin update payload.
     * @throws IllegalArgumentException thrown if parameters fail the validation.
     * @throws com.azure.core.management.exception.ManagementException thrown if the request is rejected by server.
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent.
     */
    void addRootCollectionAdmin(CollectionAdminUpdate collectionAdminUpdate);
}
