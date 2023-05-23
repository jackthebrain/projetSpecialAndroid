package com.example.trips;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;

public interface ApiInterfaceTrip {
    @POST("/createTrip")
     Call<Trip> getTripInformation(@Body Trip tripRequest);
}
