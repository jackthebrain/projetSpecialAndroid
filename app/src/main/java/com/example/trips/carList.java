package com.example.trips;

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

public class carList extends AppCompatActivity implements recyclerListner{
    RecyclerView recyclerView;

    List<carResult> carsFiltred;
    Button ownerButton;
    EditText ownerTxt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_car_list);
        recyclerView = findViewById(R.id.recyclerViewCar);
        ownerButton = findViewById(R.id.ownerFilter);
        ownerTxt= findViewById(R.id.owner);
        ownerButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String owner = String.valueOf(ownerTxt.getText());
                getCars(owner);
            }
        });
    }
    private void getCars(String owner) {
        ApiInterface apiInterface = createRequest.getRetrofitInstance().create(ApiInterface.class);
        Call<List<carResult>> apiCall = apiInterface.getCars();
        apiCall.enqueue(new Callback<List<carResult>>() {
            @Override
            public void onResponse(Call<List<carResult>> call, Response<List<carResult>> response) {
                List<carResult> carResults = response.body();
                Toast.makeText(carList.this, "got products", Toast.LENGTH_SHORT).show();
                setAdapter(Filter(carResults,owner));
            }

            @Override
            public void onFailure(Call<List<carResult>> call, Throwable t) {
                Toast.makeText(carList.this, "error", Toast.LENGTH_SHORT).show();

            }
        });
    }

    private void setAdapter(List<carResult> carResult) {
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerViewCars adapterCar = new recyclerViewCars(this,carResult, this);
        recyclerView.setAdapter(adapterCar);

    }

    private List<carResult> Filter(List<carResult> carResults, String owner) {
        int cpt = 0;
        carsFiltred = new ArrayList<>();

        for (carResult post : carResults) {
            if (post.getOwner().equals(owner)) {
                cpt++;
                carsFiltred.add(post);
            }
        }
        if (cpt == 0) {
            carsFiltred = carResults;
        }

        return carsFiltred;
    }

    @Override
    public void onItemClick(int position) {

    }
}