package com.project.planets.Adapter;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.project.planets.Model.Planet;
import com.project.planets.PlanetDetailsActivity;
import com.project.planets.R;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import de.hdodenhof.circleimageview.CircleImageView;


public class AdapterPlanet extends RecyclerView.Adapter<AdapterPlanet.ViewHolder> {

    private Context context;
    List<Planet.Result> planets = new ArrayList<>();

    public AdapterPlanet(Context context, List<Planet.Result> planets) {
        this.context = context;
        this.planets = planets;
    }

    public void setValue(List<Planet.Result> planets){
        this.planets = planets;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_planet, parent, false);
        return new ViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, final int position) {
        final Planet.Result planet = planets.get(position);
        holder.txtPlanetName.setText(planet.getName());


        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(context, PlanetDetailsActivity.class);
                intent.putExtra("planet", planet);
                context.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return planets.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        @BindView(R.id.view_planet)
        CircleImageView imageView;

        @BindView(R.id.PlanetName)
        TextView txtPlanetName;

        public ViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this,itemView);
        }
    }
}