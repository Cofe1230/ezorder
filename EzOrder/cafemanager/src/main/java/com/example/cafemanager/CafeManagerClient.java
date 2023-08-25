package com.example.cafemanager;

import com.example.cafemanager.user.UserService;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class CafeManagerClient {
    private static CafeManagerClient instance;
    private UserService userService;

    public static CafeManagerClient getInstance(){
        if(instance==null){
            instance=new CafeManagerClient();
        }
        return instance;

    }
    public CafeManagerClient(){
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://10.100.102.20:8044/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        //서비스 추가
        userService = retrofit.create(UserService.class);
    }

    //getter
    public UserService getUserService() {
        return userService;
    }
}