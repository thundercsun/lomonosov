package com.thundercsun.lomonosovv;

import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

public class Core {

    private static final String BASE_URL = "http://46.146.211.31:8081/";

    private static Core сore;

    private Retrofit retrofit;

    private Core() {
        retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .build();
    }

    public static Core instance() {
        if(сore == null) {
            сore = new Core();
        }
        return сore;
    }
}
