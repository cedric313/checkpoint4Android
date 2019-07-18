package com.example.checkpoint4.model;

import java.util.ArrayList;
import java.util.List;

public class Circus {

    private Long idCircus;
    private String name;
    private String date;
    private String location;
    private String urlPhoto;
    private List<Rider> riders = new ArrayList<>();

    public Circus() {
    }

    public Circus(Long idCircus, String name, String date, String location, String urlPhoto, List<Rider> riders) {
        this.idCircus = idCircus;
        this.name = name;
        this.date = date;
        this.location = location;
        this.urlPhoto = urlPhoto;
        this.riders = riders;
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

    public Long getIdCircus() {
        return idCircus;
    }

    public void setIdCircus(Long idCircus) {
        this.idCircus = idCircus;
    }

    public List<Rider> getRiders() {
        return riders;
    }

    public void setRiders(List<Rider> riders) {
        this.riders = riders;
    }
}
