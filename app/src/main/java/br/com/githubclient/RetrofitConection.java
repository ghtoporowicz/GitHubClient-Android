package br.com.githubclient;

import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by Gustavo Toporowicz on 17/11/2017.
 */

public class RetrofitConection {
    private static final Retrofit ourInstance = null;

    public static Retrofit getInstance() {

        String API_BASE_URL = "https://api.github.com/";

        OkHttpClient.Builder httpClient = new OkHttpClient.Builder();

        Retrofit.Builder builder =
                new Retrofit.Builder()
                        .baseUrl(API_BASE_URL)
                        .addConverterFactory(
                                GsonConverterFactory.create()
                        );

        Retrofit ourInstance =
                builder
                        .client(
                                httpClient.build()
                        )
                        .build();


        return ourInstance;
    }

}
