package com.example.trips;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class tripList extends AppCompatActivity implements recyclerListner {
        RecyclerView recyclerView;
        List<tripsResult> tripsFiltred;
        Button filter;
        int position;
        EditText destinationFilter,departureFilter;
    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_trip_list);
        recyclerView = findViewById(R.id.recyclerView);
        destinationFilter = findViewById(R.id.destinationFilter);
        departureFilter = findViewById(R.id.departureFilter);
        filter = findViewById(R.id.filter);
        filter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String departure = String.valueOf(departureFilter.getText());
                String destination = String.valueOf(destinationFilter.getText());
                getTrips(departure,destination);
            }
        });
        recyclerView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onItemClick(position);

            }
        });
    }
    private void getTrips(String departure,String destination) {
        ApiInterface apiInterface = createRequest.getRetrofitInstance().create(ApiInterface.class);
        Call<List<tripsResult>> apiCall = apiInterface.getTrips();
        apiCall.enqueue(new Callback<List<tripsResult>>() {
            @Override
            public void onResponse(Call<List<tripsResult>> call, Response<List<tripsResult>> response) {
                List<tripsResult> tripsResults = response.body();
                Toast.makeText(tripList.this, "got products", Toast.LENGTH_SHORT).show();
                setAdapter(Filter(tripsResults,departure,destination));
            }

            @Override
            public void onFailure(Call<List<tripsResult>> call, Throwable t) {
                Toast.makeText(tripList.this, "error", Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void setAdapter(List<tripsResult> tripsResults) {
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerViewAdapter adapter = new recyclerViewAdapter(this,tripsResults, this);
        recyclerView.setAdapter(adapter);

    }

    private List<tripsResult> Filter (List<tripsResult> tripsResults , String departure, String destination){
        int cpt=0;
        for(tripsResult  post:tripsResults ){
            if(post.getDeparture().equals(departure) || post.getDestination().equals(destination)){
                cpt++;
                tripsFiltred = new ArrayList<>();
                tripsFiltred.add(post);
            }
        }
        if (cpt==0){
            tripsFiltred=tripsResults;
        }
        return tripsFiltred;
    }

    @Override
    public void onItemClick(int position ) {
        Intent intent = new Intent(tripList.this,tripDetails.class);
        intent.putExtra("idCar", tripsFiltred.get(position).getIdCar().toString());
        intent.putExtra("idTrip", tripsFiltred.get(position).getId().toString());
        intent.putExtra("departure", tripsFiltred.get(position).getDeparture().toString());
        intent.putExtra("destination", tripsFiltred.get(position).getDestination().toString());
        intent.putExtra("time", tripsFiltred.get(position).getTime().toString());
        intent.putExtra("condition", tripsFiltred.get(position).getCondition().toString());
        startActivity(intent);
    }
}