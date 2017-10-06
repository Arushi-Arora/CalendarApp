package com.takusemba.spotlightsample;

/**
 * Created by hp on 7/10/2017.
 */

public class TodoAdd {
    String title;
    String description;
    String date;

    public void setDate(String date) {
        this.date = date;
    }

    public String getDate() {
        return date;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public TodoAdd(){

    }
    public TodoAdd(String title, String description,String date) {
        this.title = title;
        this.description = description;
        this.date=date;
    }
}
