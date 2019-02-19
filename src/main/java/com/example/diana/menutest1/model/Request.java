package com.example.diana.menutest1.model;

import io.realm.RealmObject;
import io.realm.annotations.PrimaryKey;

import java.util.Date;

/**
 * Created by Diana on 18.02.2019.
 */

public class Request extends RealmObject {

    @PrimaryKey
    private int id;
    private String location;
    private String name;
    private String author;
//    private Double date;



    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }
//
//    public Double getDate() {
//        return date;
//    }
//
//    public void setDate(Double date) {
//        this.date = date;
//    }
}
