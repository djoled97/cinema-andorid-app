package com.example.cinema.models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class User {
    @SerializedName("name")
    @Expose
    private String name;

    public User() {
    }

    @SerializedName("email")
    @Expose
    private String email;
    @SerializedName("lastName")
    @Expose
    private String lastName;

    public User(String name, String email, String lastName, String username, String passwordHash) {
        this.name = name;
        this.email = email;
        this.lastName = lastName;
        this.username = username;
        this.passwordHash = passwordHash;
    }

    @SerializedName("username")
    @Expose
    private String username;
    @SerializedName("passwordHash")
    @Expose
    private String passwordHash;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

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

}
