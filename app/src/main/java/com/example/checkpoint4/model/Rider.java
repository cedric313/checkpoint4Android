package com.example.checkpoint4.model;

public class Rider {

    private String name;
    private String firstName;
    private int age;
    private String nationality;
    private String urlPicRider;



    public Rider() {
    }

    public Rider(String name, String firstName, int age, String nationality, String urlPicRider) {
        this.name = name;
        this.firstName = firstName;
        this.age = age;
        this.nationality = nationality;
        this.urlPicRider = urlPicRider;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getNationality() {
        return nationality;
    }

    public void setNationality(String nationality) {
        this.nationality = nationality;
    }

    public String getUrlPicRider() {
        return urlPicRider;
    }

    public void setUrlPicRider(String urlPicRider) {
        this.urlPicRider = urlPicRider;
    }
}
