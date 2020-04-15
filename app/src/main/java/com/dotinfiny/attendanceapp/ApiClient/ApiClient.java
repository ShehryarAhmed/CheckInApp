package com.dotinfiny.attendanceapp.ApiClient;

import android.content.Context;

import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ApiClient {
    final static String BASEURL = "http://checkin.karachidiscountstore.com/";
    public static Retrofit getClient() {
        OkHttpClient client = new OkHttpClient.Builder()/*.addInterceptor(interceptor)*/
                .connectTimeout(60, TimeUnit.SECONDS)
                .readTimeout(30, TimeUnit.SECONDS)
                .writeTimeout(30, TimeUnit.SECONDS)
                .build();

        return new Retrofit.Builder()
                .baseUrl(BASEURL)
                .addConverterFactory(GsonConverterFactory.create())
                .client(client)
                .build();
    }
}
