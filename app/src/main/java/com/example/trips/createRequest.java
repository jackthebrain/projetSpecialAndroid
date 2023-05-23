package com.example.trips;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class createRequest {

        public static Retrofit retrofit;

    public static Retrofit getRetrofitInstance(){
        if (retrofit == null){
            retrofit = new Retrofit.Builder()
                    .baseUrl("https://tri9iapi.onrender.com")
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
        }
        return retrofit;
    }


}
