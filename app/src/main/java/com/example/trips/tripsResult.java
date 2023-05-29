package com.example.trips;

import com.google.gson.annotations.SerializedName;

public class tripsResult {
    @SerializedName("id")
    String id;
    @SerializedName("idCar")
    String idCar;
    @SerializedName("departure")
    String departure;
    @SerializedName("destination")
    String destination;
    @SerializedName("time")
    String time;
    @SerializedName("condition")
    String condition;

    public String getId() {
        return id;
    }

    public String getIdCar() {
        return idCar;
    }

    public String getDeparture() {
        return departure;
    }

    public String getDestination() {
        return destination;
    }

    public String getTime() {
        return time;
    }

    public String getCondition() {
        return condition;
    }
}