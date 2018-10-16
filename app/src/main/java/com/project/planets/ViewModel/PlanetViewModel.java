package com.project.planets.ViewModel;

import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.MutableLiveData;
import android.arch.lifecycle.ViewModel;

import com.project.planets.Model.Planet;
import com.project.planets.Rest.RestClient;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class PlanetViewModel extends ViewModel {

    private Planet planet;
    private LiveData<Planet> planetLiveData;
    private MutableLiveData<Planet> planetMutableLiveData = new MutableLiveData<>();


    public PlanetViewModel() {
    }

    public PlanetViewModel(Planet planet) {
        this.planet = planet;
    }

    public Planet getPlanet() {
        if (planet == null) {
            planet = RestClient.getPlanet();
        }
        return planet;
    }


    public LiveData<Planet> getPlanetLiveData() {

        if (planetLiveData == null) {
            planetLiveData = RestClient.getPlanetLiveData();
        }
        return planetLiveData;
    }
}
