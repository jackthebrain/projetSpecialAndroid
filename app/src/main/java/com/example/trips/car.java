package com.example.trips;

public class car {

    public String getBrand() {
        return brand;
    }

    public String getModel() {
        return model;
    }

    public String getPlaque() {
        return plaque;
    }

    public int getPlaces() {
        return places;
    }
    private String brand;
    private String model;

    private String owner;
    private String plaque;
    private int places;

    public car(String brand, String model, String plaque, int places) {
        this.brand = brand;
        this.model = model;
        this.plaque = plaque;
        this.places = places;
    }
}
