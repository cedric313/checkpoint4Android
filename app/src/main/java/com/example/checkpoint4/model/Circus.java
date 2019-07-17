package com.example.checkpoint4.model;

public class Circus {

    private Long id;
    private String name;
    private String date;
    private String location;
    private String urlPhoto;



    public Circus() {
    }

    public Circus(Long id, String name, String date, String location, String urlPhoto) {
        this.id = id;
        this.name = name;
        this.date = date;
        this.location = location;
        this.urlPhoto = urlPhoto;
    }

    public String getUrlPhoto() {
        return urlPhoto;
    }

    public void setUrlPhoto(String urlPhoto) {
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

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
