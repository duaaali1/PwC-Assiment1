package com.pwc.covid19.flow.map.models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.Map;

public class Dates {
    @SerializedName("countries")
    @Expose
    private Map<String, Country> countries;

    public Map<String, Country> getCountries() {
        return countries;
    }

    public void setCountries(Map<String, Country> countries) {
        this.countries = countries;
    }
}
