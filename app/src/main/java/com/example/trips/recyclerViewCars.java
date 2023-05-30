package com.example.trips;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class recyclerViewCars extends RecyclerView.Adapter<recyclerViewCars.RecyclerViewRetrofit> {
    List<carResult> carResults;

    private final recyclerListner recyclerListner;
    Context mContext;

    public recyclerViewCars(Context context, List<carResult> carResults, com.example.trips.recyclerListner recyclerListner) {
        this.mContext = context;
        this.carResults = carResults;
        this.recyclerListner = recyclerListner;
    }

    @NonNull
    @Override
    public RecyclerViewRetrofit onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(mContext).inflate(R.layout.car, parent, false);
        return new RecyclerViewRetrofit(view,recyclerListner);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerViewRetrofit holder, int position) {
        carResult carResult = carResults.get(position);
        holder.brand.setText(carResult.getBrand());
        holder.model.setText(carResult.getModel());
        holder.places.setText(String.valueOf(carResult.getPlaces()));
        holder.plaque.setText(String.valueOf(carResult.getPlaque()));
    }

    @Override
    public int getItemCount() {
        return carResults.size();
    }

    public static class RecyclerViewRetrofit extends RecyclerView.ViewHolder {
        TextView brand, model, places, plaque;

        public RecyclerViewRetrofit(@NonNull View itemView , recyclerListner recyclerListner ) {
            super(itemView);
            brand = itemView.findViewById(R.id.brand);
            model = itemView.findViewById(R.id.model);
            places = itemView.findViewById(R.id.places);
            plaque = itemView.findViewById(R.id.plaque);
            itemView.setOnLongClickListener(new View.OnLongClickListener() {
                @Override
                public boolean onLongClick(View v) {
                    if(recyclerListner != null){
                        int pos = getAdapterPosition();

                        if(pos != RecyclerView.NO_POSITION){
                            recyclerListner.onItemClick(pos);
                        }
                    }
                    return false;
                }
            });
        }
    }
}