package com.example.trips;

import static android.content.ContentValues.TAG;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.google.gson.Gson;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class tripDetails extends AppCompatActivity {

    TextView departure,destination,carbrand,time,places,condition;
    Button push;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_trip_details);
        departure= findViewById(R.id.departure);
        destination= findViewById(R.id.destination);
        carbrand= findViewById(R.id.carbrand);
        time= findViewById(R.id.time);
        places= findViewById(R.id.placesnbr);
        condition= findViewById(R.id.condition);
        push = findViewById(R.id.push);
        initialiseDetails();




        push.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                }
        });


    }

    private void initialiseDetails(){
        Bundle extras = getIntent().getExtras();
        String idCar = extras.getString("idCar");
        String idTrip = extras.getString("id");
        String departureDetail = extras.getString("departure");
        String destinationDetail = extras.getString("destination");
        String timeDetail = extras.getString("time");
        String conditionDetail = extras.getString("condition");
        departure.setText(departureDetail);
        destination.setText(destinationDetail);
        time.setText(timeDetail);
        condition.setText(conditionDetail);

        ApiInterface apiInterface = createRequest.getRetrofitInstance().create(ApiInterface.class);
        CarIdRequest request = new CarIdRequest(idCar);

        Call<car> call = apiInterface.getCarInformation(request);

        call.enqueue(new Callback<car>() {
            @Override
            public void onResponse(Call<car> call, Response<car> response) {
                car result = response.body();
                Log.d(TAG, "Response body: " + new Gson().toJson(result));
                carbrand.setText(String.valueOf(result.getBrand()));
                places.setText(String.valueOf(result.getPlaces()));
            }

            @Override
            public void onFailure(Call<car> call, Throwable t) {

            }
        });
    }

}