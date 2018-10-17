package com.project.planets;

import android.app.ProgressDialog;
import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.Observer;
import android.arch.lifecycle.ViewModelProviders;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.project.planets.Adapter.AdapterPlanet;
import com.project.planets.Model.Planet;
import com.project.planets.ViewModel.PlanetViewModel;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity {
    ProgressDialog progressDialog;

    @BindView(R.id.list)
    RecyclerView recyclerView;

    PlanetViewModel planetViewModel;
    RecyclerView.LayoutManager layoutManager;
    AdapterPlanet adapter;
    List<Planet.Result> planet = new ArrayList<>();
    LiveData<Planet> planetLiveData;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        progressDialog = new ProgressDialog(this);
        progressDialog.setMessage("loading...");
        progressDialog.setIndeterminate(true);
        progressDialog.show();

        ButterKnife.bind(this);

        planetViewModel = ViewModelProviders.of(this).get(PlanetViewModel.class);

        planetViewModel.getPlanetLiveData().observe(this, new Observer<Planet>() {
            @Override
            public void onChanged(@Nullable Planet result) {
                progressDialog.dismiss();
                planet.clear();
                planet.addAll(result.getResults());
                adapter.setValue(planet);
            }
        });

        adapter = new AdapterPlanet(this, planet);
        layoutManager = new LinearLayoutManager(getApplicationContext());
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new GridLayoutManager(this,2));
        recyclerView.setAdapter(adapter);


    }
}
