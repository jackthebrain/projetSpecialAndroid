package com.example.trips;

import com.google.gson.annotations.SerializedName;

public class carResult {
    public carResult(String id, String owner, String brand, String model, int places, int plaque) {
        this.id = id;
        this.owner = owner;
        this.brand = brand;
        this.model = model;
        this.places = places;
        this.plaque = plaque;
    }

    @SerializedName("id")
    String id;
    @SerializedName("owner")
    String owner;
    @SerializedName("brand")
    String brand;
    @SerializedName("model")
    String model;
    @SerializedName("places")
    int places;
    @SerializedName("plaque")
    int plaque;

    public String getId() {return id;}
    public String getOwner() {return owner;}

    public String getBrand() {
        return brand;
    }

    public String getModel() {
        return model;
    }

    public int getPlaces() {
        return places;
    }

    public int getPlaque() {
        return plaque;
    }

    public carResult(String brand, String model, int plaque, int places) {
        this.brand = brand;
        this.model = model;
        this.plaque = plaque;
        this.places = places;
    }
}
