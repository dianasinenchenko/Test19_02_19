package com.example.diana.menutest1.places;

/**
 * Created by Diana on 19.04.2018.
 */

public class Place {
    private String Title;
    private int Thumbnail ;

    public Place(String title, int thumbnail) {
        Title = title;
        Thumbnail = thumbnail;
    }

    public String getTitle() {
        return Title;
    }

    public void setTitle(String title) {
        Title = title;
    }

    public int getThumbnail() {
        return Thumbnail;
    }

    public void setThumbnail(int thumbnail) {
        Thumbnail = thumbnail;
    }
}
