package com.example.checkpoint4.model;

import java.util.ArrayList;
import java.util.List;

public class User {

    private String email;
    private String password;
    private Long idUser;
    private List<Rider> riders = new ArrayList<>();

    public User() {
    }

    public User(String email, String password, Long idUser, List<Rider> riders) {
        this.email = email;
        this.password = password;
        this.idUser = idUser;
        this.riders = riders;
    }


    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Long getIdUser() {
        return idUser;
    }

    public void setIdUser(Long idUser) {
        this.idUser = idUser;
    }

    public List<Rider> getRiders() {
        return riders;
    }

    public void setRiders(List<Rider> riders) {
        this.riders = riders;
    }
}
