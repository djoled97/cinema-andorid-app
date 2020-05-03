package com.example.cinema.API;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitApiMovie {

private static RetrofitApiMovie instance=null;

private static final String BASE_URL="https://api.themoviedb.org";

private API api;

public static RetrofitApiMovie getInstance(){
    if(instance==null){
        instance=new RetrofitApiMovie();
    }
    return  instance;

}
    private RetrofitApiMovie(){
        buildRetrofitMovie(BASE_URL);
    }


    private void buildRetrofitMovie(String url) {
//        HttpLoggingInterceptor loggingInterceptor = new HttpLoggingInterceptor();
//        loggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
//        OkHttpClient.Builder okHttpBuilder = new OkHttpClient.Builder();
//
//        client =    okHttpBuilder.build();


        Retrofit retrofit = new Retrofit.Builder().baseUrl(url).addConverterFactory(GsonConverterFactory.create()).build();

        this.api=retrofit.create(API.class);
    }

    public API getApi() {
        return api;
    }


}
