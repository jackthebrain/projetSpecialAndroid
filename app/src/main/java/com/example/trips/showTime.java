package com.example.trips;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class showTime extends AppCompatActivity {
    Button addCar,addTrip,tripList;
    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_time);
        addCar = findViewById(R.id.addCar);
        addTrip = findViewById(R.id.addTrip);
        tripList = findViewById(R.id.tripList);

        addTrip.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(showTime.this,MainActivity.class);
                startActivity(intent);
            }
        });

        tripList.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(showTime.this,tripList.class);
                startActivity(intent);
            }
        });

        addCar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(showTime.this,tripList.class);
                startActivity(intent);
            }
        });


    }
}