package com.example.trips;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;

public interface ApiInterfaceCar {
    @POST("/createCar")
    Call<car> getCarInformation(@Body car CarRequest);
}
