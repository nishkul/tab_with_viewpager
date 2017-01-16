package com.android.test.model;

/**
 * Created by Manish on 16/1/17.
 */

public class Video {
    private String title;

    public Video(String title, String subtile) {
        this.title = title;
        this.subtile = subtile;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getSubtile() {
        return subtile;
    }

    public void setSubtile(String subtile) {
        this.subtile = subtile;
    }

    private String subtile;
}
