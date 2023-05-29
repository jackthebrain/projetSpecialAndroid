package com.example.trips;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;

public interface ApiInterface {
    @POST("/createTrip")
     Call<Trip> getTripInformation(@Body Trip tripRequest);
    @POST("/createCar")
     Call<car> getCarInformation(@Body car CarRequest);
    @GET("/GetTrips")
    Call<List<tripsResult>> getTrips();
    @GET("/GetCars")
    Call<List<carResult>> getCars();
    @POST("/getCarById")
    Call<car> getCarInformation(@Body CarIdRequest request);

}
