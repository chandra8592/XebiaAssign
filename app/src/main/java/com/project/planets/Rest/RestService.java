package com.project.planets.Rest;

import com.project.planets.Model.Planet;

import retrofit2.Call;
import retrofit2.http.GET;

public interface RestService {


    @GET("api/planets")
    Call<Planet> getPlanet();
}
