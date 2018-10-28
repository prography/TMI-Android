package com.example.administrator.tmi.retrofit;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitClient {
    private static Retrofit retrofit;

    public static Retrofit create(){
        retrofit = new Retrofit.Builder()
                .baseUrl("http://ec2-13-209-6-120.ap-northeast-2.compute.amazonaws.com/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        return retrofit;
    }
}
