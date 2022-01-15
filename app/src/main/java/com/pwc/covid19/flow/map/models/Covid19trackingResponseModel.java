package com.pwc.covid19.flow.map.models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.Map;

public class Covid19trackingResponseModel {

    @SerializedName("Dates")
    @Expose
    private Map<String, Dates> dates;
    Metadata MetadataObject;
    Total TotalObject;
    private String updated_at;


    // Getter Methods

    public Map<String, Dates> getDates() {
        return dates;
    }

    public void setDates(Map<String, Dates> dates) {
        this.dates = dates;
    }

    public Metadata getMetadata() {
        return MetadataObject;
    }

    public Total getTotal() {
        return TotalObject;
    }

    public String getUpdated_at() {
        return updated_at;
    }

    // Setter Methods
    public void setMetadata(Metadata metadataObject) {
        this.MetadataObject = metadataObject;
    }

    public void setTotal(Total totalObject) {
        this.TotalObject = totalObject;
    }

    public void setUpdated_at(String updated_at) {
        this.updated_at = updated_at;
    }
}