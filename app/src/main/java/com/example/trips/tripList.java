package com.example.trips;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class tripList extends AppCompatActivity {

    RecyclerView recyclerView;
    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_trip_list);
        recyclerView = findViewById(R.id.recyclerView);
        getTrips();
    }

    private void getTrips() {
        ApiInterface apiInterface = createRequest.getRetrofitInstance().create(ApiInterface.class);
        Call<List<tripsResult>> apiCall = apiInterface.getTrips();
        apiCall.enqueue(new Callback<List<tripsResult>>() {
            @Override
            public void onResponse(Call<List<tripsResult>> call, Response<List<tripsResult>> response) {
                List<tripsResult> tripsResults = response.body();
                Toast.makeText(tripList.this, "got products", Toast.LENGTH_SHORT).show();
                setAdapter(tripsResults);
            }

            @Override
            public void onFailure(Call<List<tripsResult>> call, Throwable t) {
                Toast.makeText(tripList.this, "error", Toast.LENGTH_SHORT).show();

            }
        });
    }

    private void setAdapter(List<tripsResult> tripsResults) {
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerViewAdapter adapter = new recyclerViewAdapter(this,tripsResults);
        recyclerView.setAdapter(adapter);

    }
}