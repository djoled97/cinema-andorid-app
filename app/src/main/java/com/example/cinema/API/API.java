package com.example.cinema.API;

import com.example.cinema.models.LoginUser;
import com.example.cinema.models.MovieCredits;
import com.example.cinema.models.MovieDetails;
import com.example.cinema.models.MovieResults;
import com.example.cinema.models.User;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.Headers;
import retrofit2.http.POST;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface API {


    @POST("/api/users")
    Call<User> createUser(@Body User user);


    @GET("/welcome")
    Call<User> login(@Header("Authorization") String authHeader);


    @GET("3/movie/now_playing")
    Call<MovieResults> listOfMovies(
            @Query("api_key" )String apiKey,
            @Query("language") String language,
            @Query("page") int page
    );

    @GET("3/movie/{id}")
    Call<MovieDetails> detailsMovie(
            @Path("id") int id,
            @Query("api_key") String api_key
    );
    @GET("3/movie/{id}/credits")
    Call<MovieCredits> creditsMovie(
            @Path("id") int id,
            @Query("api_key") String api_key

    );

    @GET("/api/loggedUser")
    Call<User> loggedUser(@Body User user);


}

