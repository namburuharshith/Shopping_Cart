package com.example.harshith.shoppingcart;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface Api {

    String BASE_URL = "https://bitnami-39xfosdmxa.appspot.com/";

    @GET("get-items")

    Call<List<Phone>> getPhones(
            @Query("model") String model,
            @Query("manufacturer") String manufacturer,
            @Query("min-price") String minprice,
            @Query("max-price") String maxprice
    );

    @GET("get-items")
    Call<List<Phone>> getPhones();

    @GET("buy")
    Call<Sales> getBuy(
            @Query("model") String model,
            @Query("username") String username,
            @Query("qty") String quantity
    );

    @GET("getSalesRecords")
    Call<List<Sales>> getRecords();

}
