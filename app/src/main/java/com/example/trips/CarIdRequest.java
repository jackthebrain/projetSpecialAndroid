package com.example.trips;

import com.google.gson.annotations.SerializedName;

public class CarIdRequest {
    @SerializedName("id")
    private String id;

    public CarIdRequest(String id) {
        this.id = id;
    }
}
