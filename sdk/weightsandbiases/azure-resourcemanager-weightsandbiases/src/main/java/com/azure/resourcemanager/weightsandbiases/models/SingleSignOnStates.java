// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.
// Code generated by Microsoft (R) TypeSpec Code Generator.

package com.azure.resourcemanager.weightsandbiases.models;

import com.azure.core.util.ExpandableStringEnum;
import java.util.Collection;

/**
 * Various states of the SSO resource.
 */
public final class SingleSignOnStates extends ExpandableStringEnum<SingleSignOnStates> {
    /**
     * Initial state of the SSO resource.
     */
    public static final SingleSignOnStates INITIAL = fromString("Initial");

    /**
     * State of the SSO resource when it is enabled.
     */
    public static final SingleSignOnStates ENABLE = fromString("Enable");

    /**
     * State of the SSO resource when it is disabled.
     */
    public static final SingleSignOnStates DISABLE = fromString("Disable");

    /**
     * Creates a new instance of SingleSignOnStates value.
     * 
     * @deprecated Use the {@link #fromString(String)} factory method.
     */
    @Deprecated
    public SingleSignOnStates() {
    }

    /**
     * Creates or finds a SingleSignOnStates from its string representation.
     * 
     * @param name a name to look for.
     * @return the corresponding SingleSignOnStates.
     */
    public static SingleSignOnStates fromString(String name) {
        return fromString(name, SingleSignOnStates.class);
    }

    /**
     * Gets known SingleSignOnStates values.
     * 
     * @return known SingleSignOnStates values.
     */
    public static Collection<SingleSignOnStates> values() {
        return values(SingleSignOnStates.class);
    }
}
