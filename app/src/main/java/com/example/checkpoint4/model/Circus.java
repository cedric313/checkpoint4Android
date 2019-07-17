package com.example.checkpoint4.model;

public class Circus {

    private String name;
    private String date;
    private String location;
    private String urlPhoto;



    public Circus() {
    }

    public String getUrlPhoto() {
        return urlPhoto;
    }

    public void setUrlPhoto(String urlPhoto) {
        this.urlPhoto = urlPhoto;
    }

    public Circus(String name, String date, String location, String urlPhoto) {
        this.name = name;
        this.date = date;
        this.location = location;
        this.urlPhoto = urlPhoto;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }
}
