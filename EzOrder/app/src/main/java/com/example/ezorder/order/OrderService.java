package com.example.ezorder.order;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.PUT;

public interface OrderService {
    @PUT("/order/insert")
    Call<Void> save(@Body OrderInfo orderInfo);

}
