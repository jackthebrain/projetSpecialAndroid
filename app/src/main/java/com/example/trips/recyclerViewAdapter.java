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
    List<tripsResult> tripsresult ;
    Context mcontext;
    public recyclerViewAdapter(Context context, List<tripsResult> tripsresult) {
        this.mcontext = context;
        this.tripsresult = tripsresult;
    }

    @NonNull
    @Override
    public recyclerViewRetrofit onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(mcontext).inflate(R.layout.trip,parent,false);
        return new recyclerViewRetrofit(view);
    }

    @Override
    public void onBindViewHolder(@NonNull recyclerViewAdapter.recyclerViewRetrofit holder, int position) {
        holder.departure.setText(tripsresult.get(position).getDeparture());
        holder.destination.setText(tripsresult.get(position).getDestination());
        holder.condition.setText(tripsresult.get(position).getCondition());
        holder.time.setText(tripsresult.get(position).getTime());
    }

    @Override
    public int getItemCount() {
        return tripsresult.size();
    }

    public static class recyclerViewRetrofit extends RecyclerView.ViewHolder {
        TextView departure,destination,condition,time;

        @SuppressLint("CutPasteId")
        public recyclerViewRetrofit(@NonNull View itemView) {
            super(itemView);
            departure = itemView.findViewById(R.id.departure);
            destination = itemView.findViewById(R.id.destination);
            condition = itemView.findViewById(R.id.condition);
            time = itemView.findViewById(R.id.time);
        }
    }
}