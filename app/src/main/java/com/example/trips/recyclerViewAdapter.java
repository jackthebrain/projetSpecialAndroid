package com.example.trips;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class recyclerViewAdapter extends RecyclerView.Adapter<recyclerViewAdapter.recyclerViewRetrofit> {
    List<tripsResult> tripsresults ;
    private final recyclerListner recyclerListner;

    Context mcontext;
    public recyclerViewAdapter(Context context, List<tripsResult> tripsresult, com.example.trips.recyclerListner recyclerListner) {
        this.mcontext = context;
        this.tripsresults = tripsresult;
        this.recyclerListner = recyclerListner;
    }

    @NonNull
    @Override
    public recyclerViewRetrofit onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(mcontext).inflate(R.layout.trip,parent,false);
        return new recyclerViewRetrofit(view,recyclerListner);
    }

    @Override
    public void onBindViewHolder(@NonNull recyclerViewAdapter.recyclerViewRetrofit holder, int position) {
        holder.departure.setText(tripsresults.get(position).getDeparture());
        holder.destination.setText(tripsresults.get(position).getDestination());
        holder.condition.setText(tripsresults.get(position).getCondition());
        holder.time.setText(tripsresults.get(position).getTime());
    }

    @Override
    public int getItemCount() {
        return tripsresults.size();
    }

    public static class recyclerViewRetrofit extends RecyclerView.ViewHolder {
        TextView departure,destination,condition,time;

        @SuppressLint("CutPasteId")
        public recyclerViewRetrofit(@NonNull View itemView , recyclerListner recyclerListner) {
            super(itemView);
            departure = itemView.findViewById(R.id.model);
            destination = itemView.findViewById(R.id.brand);
            condition = itemView.findViewById(R.id.places);
            time = itemView.findViewById(R.id.plaque);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if(recyclerListner != null){
                        int pos = getAdapterPosition();

                        if(pos != RecyclerView.NO_POSITION){
                            recyclerListner.onItemClick(pos);
                        }
                    }
                }
            });
        }
    }
}