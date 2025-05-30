// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.
// Code generated by Microsoft (R) AutoRest Code Generator.

package com.azure.resourcemanager.frontdoor.fluent.models;

import com.azure.core.annotation.Fluent;
import com.azure.json.JsonReader;
import com.azure.json.JsonSerializable;
import com.azure.json.JsonToken;
import com.azure.json.JsonWriter;
import com.azure.resourcemanager.frontdoor.models.AggregationInterval;
import com.azure.resourcemanager.frontdoor.models.TimeseriesDataPoint;
import com.azure.resourcemanager.frontdoor.models.TimeseriesType;
import java.io.IOException;
import java.util.List;

/**
 * Defines the properties of a timeseries.
 */
@Fluent
public final class TimeseriesProperties implements JsonSerializable<TimeseriesProperties> {
    /*
     * The endpoint associated with the Timeseries data point
     */
    private String endpoint;

    /*
     * The start DateTime of the Timeseries in UTC
     */
    private String startDateTimeUtc;

    /*
     * The end DateTime of the Timeseries in UTC
     */
    private String endDateTimeUtc;

    /*
     * The aggregation interval of the Timeseries
     */
    private AggregationInterval aggregationInterval;

    /*
     * The type of Timeseries
     */
    private TimeseriesType timeseriesType;

    /*
     * The country associated with the Timeseries. Values are country ISO codes as specified here-
     * https://www.iso.org/iso-3166-country-codes.html
     */
    private String country;

    /*
     * The set of data points for the timeseries
     */
    private List<TimeseriesDataPoint> timeseriesData;

    /**
     * Creates an instance of TimeseriesProperties class.
     */
    public TimeseriesProperties() {
    }

    /**
     * Get the endpoint property: The endpoint associated with the Timeseries data point.
     * 
     * @return the endpoint value.
     */
    public String endpoint() {
        return this.endpoint;
    }

    /**
     * Set the endpoint property: The endpoint associated with the Timeseries data point.
     * 
     * @param endpoint the endpoint value to set.
     * @return the TimeseriesProperties object itself.
     */
    public TimeseriesProperties withEndpoint(String endpoint) {
        this.endpoint = endpoint;
        return this;
    }

    /**
     * Get the startDateTimeUtc property: The start DateTime of the Timeseries in UTC.
     * 
     * @return the startDateTimeUtc value.
     */
    public String startDateTimeUtc() {
        return this.startDateTimeUtc;
    }

    /**
     * Set the startDateTimeUtc property: The start DateTime of the Timeseries in UTC.
     * 
     * @param startDateTimeUtc the startDateTimeUtc value to set.
     * @return the TimeseriesProperties object itself.
     */
    public TimeseriesProperties withStartDateTimeUtc(String startDateTimeUtc) {
        this.startDateTimeUtc = startDateTimeUtc;
        return this;
    }

    /**
     * Get the endDateTimeUtc property: The end DateTime of the Timeseries in UTC.
     * 
     * @return the endDateTimeUtc value.
     */
    public String endDateTimeUtc() {
        return this.endDateTimeUtc;
    }

    /**
     * Set the endDateTimeUtc property: The end DateTime of the Timeseries in UTC.
     * 
     * @param endDateTimeUtc the endDateTimeUtc value to set.
     * @return the TimeseriesProperties object itself.
     */
    public TimeseriesProperties withEndDateTimeUtc(String endDateTimeUtc) {
        this.endDateTimeUtc = endDateTimeUtc;
        return this;
    }

    /**
     * Get the aggregationInterval property: The aggregation interval of the Timeseries.
     * 
     * @return the aggregationInterval value.
     */
    public AggregationInterval aggregationInterval() {
        return this.aggregationInterval;
    }

    /**
     * Set the aggregationInterval property: The aggregation interval of the Timeseries.
     * 
     * @param aggregationInterval the aggregationInterval value to set.
     * @return the TimeseriesProperties object itself.
     */
    public TimeseriesProperties withAggregationInterval(AggregationInterval aggregationInterval) {
        this.aggregationInterval = aggregationInterval;
        return this;
    }

    /**
     * Get the timeseriesType property: The type of Timeseries.
     * 
     * @return the timeseriesType value.
     */
    public TimeseriesType timeseriesType() {
        return this.timeseriesType;
    }

    /**
     * Set the timeseriesType property: The type of Timeseries.
     * 
     * @param timeseriesType the timeseriesType value to set.
     * @return the TimeseriesProperties object itself.
     */
    public TimeseriesProperties withTimeseriesType(TimeseriesType timeseriesType) {
        this.timeseriesType = timeseriesType;
        return this;
    }

    /**
     * Get the country property: The country associated with the Timeseries. Values are country ISO codes as specified
     * here- https://www.iso.org/iso-3166-country-codes.html.
     * 
     * @return the country value.
     */
    public String country() {
        return this.country;
    }

    /**
     * Set the country property: The country associated with the Timeseries. Values are country ISO codes as specified
     * here- https://www.iso.org/iso-3166-country-codes.html.
     * 
     * @param country the country value to set.
     * @return the TimeseriesProperties object itself.
     */
    public TimeseriesProperties withCountry(String country) {
        this.country = country;
        return this;
    }

    /**
     * Get the timeseriesData property: The set of data points for the timeseries.
     * 
     * @return the timeseriesData value.
     */
    public List<TimeseriesDataPoint> timeseriesData() {
        return this.timeseriesData;
    }

    /**
     * Set the timeseriesData property: The set of data points for the timeseries.
     * 
     * @param timeseriesData the timeseriesData value to set.
     * @return the TimeseriesProperties object itself.
     */
    public TimeseriesProperties withTimeseriesData(List<TimeseriesDataPoint> timeseriesData) {
        this.timeseriesData = timeseriesData;
        return this;
    }

    /**
     * Validates the instance.
     * 
     * @throws IllegalArgumentException thrown if the instance is not valid.
     */
    public void validate() {
        if (timeseriesData() != null) {
            timeseriesData().forEach(e -> e.validate());
        }
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public JsonWriter toJson(JsonWriter jsonWriter) throws IOException {
        jsonWriter.writeStartObject();
        jsonWriter.writeStringField("endpoint", this.endpoint);
        jsonWriter.writeStringField("startDateTimeUTC", this.startDateTimeUtc);
        jsonWriter.writeStringField("endDateTimeUTC", this.endDateTimeUtc);
        jsonWriter.writeStringField("aggregationInterval",
            this.aggregationInterval == null ? null : this.aggregationInterval.toString());
        jsonWriter.writeStringField("timeseriesType",
            this.timeseriesType == null ? null : this.timeseriesType.toString());
        jsonWriter.writeStringField("country", this.country);
        jsonWriter.writeArrayField("timeseriesData", this.timeseriesData,
            (writer, element) -> writer.writeJson(element));
        return jsonWriter.writeEndObject();
    }

    /**
     * Reads an instance of TimeseriesProperties from the JsonReader.
     * 
     * @param jsonReader The JsonReader being read.
     * @return An instance of TimeseriesProperties if the JsonReader was pointing to an instance of it, or null if it
     * was pointing to JSON null.
     * @throws IOException If an error occurs while reading the TimeseriesProperties.
     */
    public static TimeseriesProperties fromJson(JsonReader jsonReader) throws IOException {
        return jsonReader.readObject(reader -> {
            TimeseriesProperties deserializedTimeseriesProperties = new TimeseriesProperties();
            while (reader.nextToken() != JsonToken.END_OBJECT) {
                String fieldName = reader.getFieldName();
                reader.nextToken();

                if ("endpoint".equals(fieldName)) {
                    deserializedTimeseriesProperties.endpoint = reader.getString();
                } else if ("startDateTimeUTC".equals(fieldName)) {
                    deserializedTimeseriesProperties.startDateTimeUtc = reader.getString();
                } else if ("endDateTimeUTC".equals(fieldName)) {
                    deserializedTimeseriesProperties.endDateTimeUtc = reader.getString();
                } else if ("aggregationInterval".equals(fieldName)) {
                    deserializedTimeseriesProperties.aggregationInterval
                        = AggregationInterval.fromString(reader.getString());
                } else if ("timeseriesType".equals(fieldName)) {
                    deserializedTimeseriesProperties.timeseriesType = TimeseriesType.fromString(reader.getString());
                } else if ("country".equals(fieldName)) {
                    deserializedTimeseriesProperties.country = reader.getString();
                } else if ("timeseriesData".equals(fieldName)) {
                    List<TimeseriesDataPoint> timeseriesData
                        = reader.readArray(reader1 -> TimeseriesDataPoint.fromJson(reader1));
                    deserializedTimeseriesProperties.timeseriesData = timeseriesData;
                } else {
                    reader.skipChildren();
                }
            }

            return deserializedTimeseriesProperties;
        });
    }
}
