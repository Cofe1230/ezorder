package com.example.ezorder;

import com.example.ezorder.order.OrderService;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;


public class EzOrderClient {
    private static EzOrderClient instance;
    private OrderService orderService;

    public static EzOrderClient getInstance(){
        if(instance==null){
            instance = new EzOrderClient();
        }
        return instance;
    }
    public EzOrderClient(){
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://10.100.102.20:8044/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        //서비스 추가
        //orderSerive : 가게에서 주문 관련된 서비스(order/OrderService)
        orderService = retrofit.create(OrderService.class);
    }
    //getter
    public OrderService getOrderService() {
        return orderService;
    }
}
