package com.example.mysocialplatformapp.model;

import java.io.Serializable;
import java.time.LocalDateTime;

public class Announcement implements Serializable {
    private String title;
    private String description;
    private String location;
    private LocalDateTime localDateTime;
    private Integer photo;

    public Announcement(String title, String description, String location, LocalDateTime localDateTime, Integer photo) {
        this.title = title;
        this.description = description;
        this.location = location;
        this.localDateTime = localDateTime;
        this.photo = photo;
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public String getLocation() {
        return location;
    }

    public LocalDateTime getLocalDateTime() {
        return localDateTime;
    }

    public Integer getPhoto() {
        return photo;
    }
}
