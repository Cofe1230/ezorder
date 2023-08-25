package com.example.ezorder.shop;

import com.example.ezorder.order.Shop;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface ShopService {
    @GET("/shop/list")
    Call<List<Shop>> findAll();
}
