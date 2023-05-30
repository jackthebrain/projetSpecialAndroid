package com.example.trips;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class addCar extends AppCompatActivity {

    EditText brandCar, modalCar, plaqueCar, placesCar;
    Button pushCarButton;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_car);

        //findingById

        brandCar = findViewById(R.id.brandCar);
        modalCar = findViewById(R.id.modalCar);
        placesCar = findViewById(R.id.placesCar);
        plaqueCar = findViewById(R.id.plaqueCar);
        pushCarButton = findViewById(R.id.pushCarButton);


        //buttonClickListener

        pushCarButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String brand = String.valueOf(brandCar.getText());
                String modal = String.valueOf(modalCar.getText());
                int plaque = Integer.valueOf(plaqueCar.getText().toString());
                int places = Integer.valueOf(placesCar.getText().toString());


                ApiInterface apiInterface = createRequest.getRetrofitInstance().create(ApiInterface.class);
                carResult carRequest = new carResult(brand, modal, plaque, places);

                Call<carResult> call = apiInterface.getCarInformation(carRequest);
                call.enqueue(new Callback<carResult>() {
                    @Override
                    public void onResponse(Call<carResult> call, Response<carResult> response) {
                        Toast.makeText(addCar.this, "suceed", Toast.LENGTH_SHORT).show();
                        finish();
                    }

                    @Override
                    public void onFailure(Call<carResult> call, Throwable t) {
                        Toast.makeText(addCar.this, "echec! "+ t.getMessage()
                                , Toast.LENGTH_SHORT).show();
                    }
                });
            }
        });
    }
}