package com.example.cinema.API;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitApi {

private static RetrofitApi instance=null;
private static final String BASE_URL_USER="http://10.0.2.2:8080";

private API api;

public static RetrofitApi getInstance(){
    if(instance==null){
        instance=new RetrofitApi();
    }
    return  instance;

}
    private RetrofitApi(){
        buildRetrofitUser(BASE_URL_USER);
    }

    private void buildRetrofitUser(String url) {

        Retrofit retrofit = new Retrofit.Builder().baseUrl(url).addConverterFactory(GsonConverterFactory.create()).build();

        this.api=retrofit.create(API.class);
    }

    public API getApi() {
        return api;
    }
}
