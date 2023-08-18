package com.example.ezorder.order;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface MenuService {
    @GET("/menu/list")
    Call<List<Menu>> findByShopid(Shop shop);
}
