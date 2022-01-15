package com.pwc.covid19.flow.news.models;

public class NewsItemUiModel {
    private String title , date , imageUrl, desc ;

    public NewsItemUiModel(String title, String date, String imageUrl, String desc) {
        this.title = title;
        this.date = date;
        this.imageUrl = imageUrl;
        this.desc = desc;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }
}
