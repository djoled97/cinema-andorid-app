package com.example.cinema.models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class LoginUser {

    @SerializedName("username")
    @Expose
    private String username;
    @SerializedName("passwordHash")
    @Expose
    private String passwordHash;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPasswordHash() {
        return passwordHash;
    }

    public void setPasswordHash(String passwordHash) {
        this.passwordHash = passwordHash;
    }

    public LoginUser(String username, String passwordHash) {
        this.username = username;
        this.passwordHash = passwordHash;
    }
}
