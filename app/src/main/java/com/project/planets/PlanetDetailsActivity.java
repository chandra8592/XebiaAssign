package com.project.planets;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.TextView;

import com.project.planets.Model.Planet;
import com.squareup.picasso.Picasso;

import butterknife.BindView;
import butterknife.ButterKnife;

public class PlanetDetailsActivity extends AppCompatActivity {
    Planet.Result planet;

    @BindView(R.id.imageBackground)
    ImageView Planet;

    @BindView(R.id.Name)
    TextView Name;

    @BindView(R.id.Climate)
    TextView Climate;

    @BindView(R.id.Diameter)
    TextView Diameter;

    @BindView(R.id.Gravity)
    TextView Gravity;

    @BindView(R.id.OrbitalPeriod)
    TextView OrbitalPeriod;

    @BindView(R.id.Population)
    TextView Population;

    @BindView(R.id.Terrain)
    TextView Terrain;

    @BindView(R.id.Water)
    TextView Water;

    @BindView(R.id.RotationPeriod)
    TextView RotationPeriod;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_planet_details);

        ButterKnife.bind(this);

        planet = (Planet.Result) getIntent().getSerializableExtra("planet");

        Name.setText(planet.getName());
        Climate.setText(planet.getClimate());
        Diameter.setText(planet.getDiameter());
        Gravity.setText(planet.getGravity());
        OrbitalPeriod.setText(planet.getOrbitalPeriod());
        Population.setText(planet.getPopulation());
        RotationPeriod.setText(planet.getRotationPeriod());
        Terrain.setText(planet.getTerrain());
        Water.setText(planet.getSurfaceWater());
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == android.R.id.home) {
            finish();
        }
        return super.onOptionsItemSelected(item);
    }

}
