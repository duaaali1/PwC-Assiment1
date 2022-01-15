package com.pwc.covid19.flow.map.models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Link {
    @SerializedName("href")
    @Expose
    private String href;
    @SerializedName("rel")
    @Expose
    private String rel;
    @SerializedName("type")
    @Expose
    private String type;

    public String getHref() {
        return href;
    }

    public void setHref(String href) {
        this.href = href;
    }

    public String getRel() {
        return rel;
    }

    public void setRel(String rel) {
        this.rel = rel;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
