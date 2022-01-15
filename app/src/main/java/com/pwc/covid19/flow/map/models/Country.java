package com.pwc.covid19.flow.map.models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class Country {
    @SerializedName("date")
    @Expose
    private String date;
    @SerializedName("id")
    @Expose
    private String id;
    @SerializedName("links")
    @Expose
    private List<Link> links = null;
    @SerializedName("name")
    @Expose
    private String name;
    @SerializedName("name_es")
    @Expose
    private String nameEs;
    @SerializedName("name_it")
    @Expose
    private String nameIt;
    @SerializedName("regions")
    @Expose
    private List<Object> regions = null;
    @SerializedName("source")
    @Expose
    private String source;
    @SerializedName("today_confirmed")
    @Expose
    private Integer todayConfirmed;
    @SerializedName("today_deaths")
    @Expose
    private Integer todayDeaths;
    @SerializedName("today_new_confirmed")
    @Expose
    private Integer todayNewConfirmed;
    @SerializedName("today_new_deaths")
    @Expose
    private Integer todayNewDeaths;
    @SerializedName("today_new_open_cases")
    @Expose
    private Integer todayNewOpenCases;
    @SerializedName("today_new_recovered")
    @Expose
    private Integer todayNewRecovered;
    @SerializedName("today_open_cases")
    @Expose
    private Integer todayOpenCases;
    @SerializedName("today_recovered")
    @Expose
    private Integer todayRecovered;
    @SerializedName("today_vs_yesterday_confirmed")
    @Expose
    private Double todayVsYesterdayConfirmed;
    @SerializedName("today_vs_yesterday_deaths")
    @Expose
    private Double todayVsYesterdayDeaths;
    @SerializedName("today_vs_yesterday_open_cases")
    @Expose
    private Double todayVsYesterdayOpenCases;
    @SerializedName("today_vs_yesterday_recovered")
    @Expose
    private Double todayVsYesterdayRecovered;
    @SerializedName("yesterday_confirmed")
    @Expose
    private Integer yesterdayConfirmed;
    @SerializedName("yesterday_deaths")
    @Expose
    private Integer yesterdayDeaths;
    @SerializedName("yesterday_open_cases")
    @Expose
    private Integer yesterdayOpenCases;
    @SerializedName("yesterday_recovered")
    @Expose
    private Integer yesterdayRecovered;

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public List<Link> getLinks() {
        return links;
    }

    public void setLinks(List<Link> links) {
        this.links = links;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNameEs() {
        return nameEs;
    }

    public void setNameEs(String nameEs) {
        this.nameEs = nameEs;
    }

    public String getNameIt() {
        return nameIt;
    }

    public void setNameIt(String nameIt) {
        this.nameIt = nameIt;
    }

    public List<Object> getRegions() {
        return regions;
    }

    public void setRegions(List<Object> regions) {
        this.regions = regions;
    }

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }

    public Integer getTodayConfirmed() {
        return todayConfirmed;
    }

    public void setTodayConfirmed(Integer todayConfirmed) {
        this.todayConfirmed = todayConfirmed;
    }

    public Integer getTodayDeaths() {
        return todayDeaths;
    }

    public void setTodayDeaths(Integer todayDeaths) {
        this.todayDeaths = todayDeaths;
    }

    public Integer getTodayNewConfirmed() {
        return todayNewConfirmed;
    }

    public void setTodayNewConfirmed(Integer todayNewConfirmed) {
        this.todayNewConfirmed = todayNewConfirmed;
    }

    public Integer getTodayNewDeaths() {
        return todayNewDeaths;
    }

    public void setTodayNewDeaths(Integer todayNewDeaths) {
        this.todayNewDeaths = todayNewDeaths;
    }

    public Integer getTodayNewOpenCases() {
        return todayNewOpenCases;
    }

    public void setTodayNewOpenCases(Integer todayNewOpenCases) {
        this.todayNewOpenCases = todayNewOpenCases;
    }

    public Integer getTodayNewRecovered() {
        return todayNewRecovered;
    }

    public void setTodayNewRecovered(Integer todayNewRecovered) {
        this.todayNewRecovered = todayNewRecovered;
    }

    public Integer getTodayOpenCases() {
        return todayOpenCases;
    }

    public void setTodayOpenCases(Integer todayOpenCases) {
        this.todayOpenCases = todayOpenCases;
    }

    public Integer getTodayRecovered() {
        return todayRecovered;
    }

    public void setTodayRecovered(Integer todayRecovered) {
        this.todayRecovered = todayRecovered;
    }

    public Double getTodayVsYesterdayConfirmed() {
        return todayVsYesterdayConfirmed;
    }

    public void setTodayVsYesterdayConfirmed(Double todayVsYesterdayConfirmed) {
        this.todayVsYesterdayConfirmed = todayVsYesterdayConfirmed;
    }

    public Double getTodayVsYesterdayDeaths() {
        return todayVsYesterdayDeaths;
    }

    public void setTodayVsYesterdayDeaths(Double todayVsYesterdayDeaths) {
        this.todayVsYesterdayDeaths = todayVsYesterdayDeaths;
    }

    public Double getTodayVsYesterdayOpenCases() {
        return todayVsYesterdayOpenCases;
    }

    public void setTodayVsYesterdayOpenCases(Double todayVsYesterdayOpenCases) {
        this.todayVsYesterdayOpenCases = todayVsYesterdayOpenCases;
    }

    public Double getTodayVsYesterdayRecovered() {
        return todayVsYesterdayRecovered;
    }

    public void setTodayVsYesterdayRecovered(Double todayVsYesterdayRecovered) {
        this.todayVsYesterdayRecovered = todayVsYesterdayRecovered;
    }

    public Integer getYesterdayConfirmed() {
        return yesterdayConfirmed;
    }

    public void setYesterdayConfirmed(Integer yesterdayConfirmed) {
        this.yesterdayConfirmed = yesterdayConfirmed;
    }

    public Integer getYesterdayDeaths() {
        return yesterdayDeaths;
    }

    public void setYesterdayDeaths(Integer yesterdayDeaths) {
        this.yesterdayDeaths = yesterdayDeaths;
    }

    public Integer getYesterdayOpenCases() {
        return yesterdayOpenCases;
    }

    public void setYesterdayOpenCases(Integer yesterdayOpenCases) {
        this.yesterdayOpenCases = yesterdayOpenCases;
    }

    public Integer getYesterdayRecovered() {
        return yesterdayRecovered;
    }

    public void setYesterdayRecovered(Integer yesterdayRecovered) {
        this.yesterdayRecovered = yesterdayRecovered;
    }

}

