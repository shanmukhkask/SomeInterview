package com.example.someinterview;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class APIClient {

    public static final String baseURL="https://mrcarto.tk";
    public static Retrofit retrofit=null;

    public static Retrofit getClient(){
        if (retrofit!=null){
            retrofit=new Retrofit.Builder().
                    baseUrl(baseURL).
                    addConverterFactory(GsonConverterFactory.create()).
                    build();

        }
        return retrofit;
    }
}
