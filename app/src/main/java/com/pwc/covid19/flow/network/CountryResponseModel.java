package com.pwc.covid19.flow.network;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class CountryResponseModel {
    @SerializedName("cca2")
    @Expose
    private String cca2;

    public String getCca2() {
        return cca2;
    }

    public void setCca2(String cca2) {
        this.cca2 = cca2;
    }
}
