package com.example.cafemanager.shop;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface ShopService {
    @GET("shop/view/{shopId}")
    Call<Shop> findByShopId(@Path("shopId") long shopId);
}
