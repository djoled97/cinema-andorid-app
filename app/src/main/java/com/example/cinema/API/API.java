package com.example.cinema.API;

import com.example.cinema.models.LoginUser;
import com.example.cinema.models.User;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.Headers;
import retrofit2.http.POST;

public  interface API {


@POST("/api/users")
    Call<User> createUser(@Body User user);



@POST("/login")
Call<LoginUser> login(@Body LoginUser loginUser);
}
