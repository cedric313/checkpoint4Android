package com.example.checkpoint4.model;

public class Rider {

    private String name;
    private String firstname;
    private int age;
    private String nationality;

    public Rider(String name, String firstname, int age, String nationality) {
        this.name = name;
        this.firstname = firstname;
        this.age = age;
        this.nationality = nationality;
    }

    public Rider() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
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
}
