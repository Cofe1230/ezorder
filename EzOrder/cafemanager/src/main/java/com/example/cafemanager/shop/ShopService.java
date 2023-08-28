package com.example.cafemanager.shop;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface ShopService {
    @GET("shop/view/{shopId}")
    Call<Shop> findByShopId(@Path("shopId") long shopId);
    @GET("shop/updateTkn")
    Call<Void> updateTkn(@Query("token") String token,@Query("shopId")long shopId);
}
