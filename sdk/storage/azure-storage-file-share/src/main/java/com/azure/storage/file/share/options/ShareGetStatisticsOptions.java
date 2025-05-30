// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.

package com.azure.storage.file.share.options;

import com.azure.core.annotation.Fluent;
import com.azure.storage.file.share.models.ShareRequestConditions;

/**
 * Extended options that may be passed when getting statistics for a share.
 */
@Fluent
public class ShareGetStatisticsOptions {
    private ShareRequestConditions requestConditions;

    /**
     * Creates a new instance of {@link ShareGetStatisticsOptions}.
     */
    public ShareGetStatisticsOptions() {
    }

    /**
     * Gets the {@link ShareRequestConditions}.
     *
     * @return {@link ShareRequestConditions}.
     */
    public ShareRequestConditions getRequestConditions() {
        return requestConditions;
    }

    /**
     * Sets the {@link ShareRequestConditions}.
     *
     * @param requestConditions {@link ShareRequestConditions}.
     * @return The updated options.
     */
    public ShareGetStatisticsOptions setRequestConditions(ShareRequestConditions requestConditions) {
        this.requestConditions = requestConditions;
        return this;
    }
}
