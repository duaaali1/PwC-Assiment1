package com.pwc.covid19.flow.map.models;

import java.util.ArrayList;

public class Metadata {
    private String by;
    private ArrayList< Object > url = new ArrayList < Object > ();

    public String getBy() {
        return by;
    }

    public void setBy(String by) {
        this.by = by;
    }

    public ArrayList<Object> getUrl() {
        return url;
    }

    public void setUrl(ArrayList<Object> url) {
        this.url = url;
    }
}
