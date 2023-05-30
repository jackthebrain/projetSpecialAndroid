package com.example.trips;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;

public interface ApiInterface {
    @POST("/createTrip")
     Call<tripsResult> getTripInformation(@Body tripsResult tripRequest);
    @POST("/createCar")
     Call<carResult> getCarInformation(@Body carResult CarRequest);
    @GET("/GetTrips")
    Call<List<tripsResult>> getTrips();
    @GET("/GetCars")
    Call<List<carResult>> getCars();
    @POST("/getCarById")
    Call<carResult> getCarInformation(@Body CarIdRequest request);
    @POST("/deleteCar")
    Call<carResult> DropCar(@Body CarIdRequest request);


}
