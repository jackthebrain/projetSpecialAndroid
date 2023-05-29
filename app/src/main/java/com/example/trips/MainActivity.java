package com.example.trips;

import android.app.TimePickerDialog;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TimePicker;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.TimeZone;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    EditText departureEditText,arrivalEditText,conditionEditText;
    Button pushTripButton,timePicker;
    String time;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //findingById

        departureEditText = findViewById(R.id.departureEditText);
        arrivalEditText = findViewById(R.id.arrivalEditText);
        timePicker = findViewById(R.id.timePicker);
        conditionEditText = findViewById(R.id.conditionEditText);
        pushTripButton = findViewById(R.id.pushTripButton);


        //buttonClickListener

        timePicker.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Calendar calendar = Calendar.getInstance();
                int hours = calendar.get(Calendar.HOUR_OF_DAY);
                int mins = calendar.get(Calendar.MINUTE);
                TimePickerDialog timePickerDialog = new TimePickerDialog(MainActivity.this, android.R.style.Theme_Material_Dialog_MinWidth, new TimePickerDialog.OnTimeSetListener() {
                    @Override
                    public void onTimeSet(TimePicker timePicker, int hourOfDay, int minute) {
                        Calendar c = Calendar.getInstance();
                        c.set(Calendar.HOUR_OF_DAY,hourOfDay);
                        c.set(Calendar.MINUTE,minute);
                        c.setTimeZone(TimeZone.getDefault());
                        SimpleDateFormat format = new SimpleDateFormat("k:mm");
                        time = format.format(c.getTime());
                    }
                }, hours, mins, false);
                timePickerDialog.show();
            }
        });

        pushTripButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String departure = String.valueOf(departureEditText.getText());
                String destination = String.valueOf(arrivalEditText.getText());
                String Condition = String.valueOf(conditionEditText.getText());

            ApiInterface apiInterface = createRequest.getRetrofitInstance().create(ApiInterface.class);
                Trip tripRequest = new Trip(departure, destination, time, Condition);
                Call<Trip> call = apiInterface.getTripInformation(tripRequest);
            call.enqueue(new Callback<Trip>() {
                @Override
                public void onResponse(Call<Trip> call, Response<Trip> response) {
                    Toast.makeText(MainActivity.this, "suceed", Toast.LENGTH_SHORT).show();
                    finish();

                }

                @Override
                public void onFailure(Call<Trip> call, Throwable t) {
                    Toast.makeText(MainActivity.this, "echec"+ t.getMessage(), Toast.LENGTH_SHORT).show();
                }
            });
            }
        });
    }
}