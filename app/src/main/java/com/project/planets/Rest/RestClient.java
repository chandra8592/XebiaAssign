package com.project.planets.Rest;

import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.MutableLiveData;

import com.project.planets.Model.Planet;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RestClient {

    public static final String BASE_URL = "https://swapi.co/";

    static Retrofit retrofit;

    private static Retrofit getRetrofit() {

        HttpLoggingInterceptor interceptor = new HttpLoggingInterceptor();
        interceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
        OkHttpClient client = new OkHttpClient.Builder().addInterceptor(interceptor).build();

        retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .client(client)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        return retrofit;
    }

    public static RestService getRestClient() {
        if (retrofit == null) {
            retrofit = getRetrofit();
        }

        return retrofit.create(RestService.class);
    }

    static Planet planet;

    public static Planet getPlanet() {
        getRestClient().getPlanet().enqueue(new Callback<Planet>() {
            @Override
            public void onResponse(Call<Planet> call, Response<Planet> response) {
                if (response.isSuccessful()) {
                    planet = response.body();
                }
            }

            @Override
            public void onFailure(Call<Planet> call, Throwable t) {

            }
        });

        return planet;
    }


    public static LiveData<Planet> getPlanetLiveData() {
        final MutableLiveData<Planet> mutableLiveData = new MutableLiveData<>();
        getRestClient().getPlanet().enqueue(new Callback<Planet>() {
            @Override
            public void onResponse(Call<Planet> call, Response<Planet> response) {
                if (response.isSuccessful()) {
                    mutableLiveData.setValue(response.body());
                }
            }

            @Override
            public void onFailure(Call<Planet> call, Throwable t) {

            }
        });

        return mutableLiveData;
    }
}
