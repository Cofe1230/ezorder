package com.example.cafemanager.management;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import com.example.cafemanager.CafeManagerClient;
import com.example.cafemanager.R;
import com.example.cafemanager.databinding.ActivityManagementBinding;
import com.example.cafemanager.shop.Shop;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.messaging.FirebaseMessaging;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ManagementActivity extends AppCompatActivity {
    private final String TAG = "ManagementActivity";
    private Shop shop;
    private String token;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActivityManagementBinding binding = ActivityManagementBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        //로그인된 샵id
        Intent intent = getIntent();
        long shopId = intent.getLongExtra("shopId", 0);
        Log.d(TAG, "shopId: " + shopId);
        //findbyShopId
        Call<Shop> call = CafeManagerClient.getInstance().getShopService().findByShopId(shopId);
        call.enqueue(new Callback<Shop>() {
            @Override
            public void onResponse(Call<Shop> call, Response<Shop> response) {
                shop = response.body();
                Log.d(TAG, "onResponse: " + shop.getShopName());
                FirebaseMessaging.getInstance().getToken()
                        .addOnCompleteListener(new OnCompleteListener<String>() {
                            @Override
                            public void onComplete(@NonNull Task<String> task) {
                                if (!task.isSuccessful()) {
                                    Log.w(TAG, "Fetching FCM registration token failed", task.getException());
                                    return;
                                }

                                // Get new FCM registration token
                                token = task.getResult();

                                // Log
                                String msg = getString(R.string.msg_token_fmt, token);
                                Log.d(TAG, msg);
                                Log.d(TAG, "shop 토큰 : "+shop.getToken());
                                //토큰 저장
                                if(!shop.getToken().equals(token)){
                                    Log.d(TAG, "onComplete: 토큰 값이 다름");
                                    Call<Void> call = CafeManagerClient.getInstance().getShopService().updateTkn(token,shop.getShopId());
                                    call.enqueue(new Callback<Void>() {
                                        @Override
                                        public void onResponse(Call<Void> call, Response<Void> response) {
                                            Log.d(TAG, "토큰 업데이트 완료");
                                        }

                                        @Override
                                        public void onFailure(Call<Void> call, Throwable t) {

                                        }
                                    });

                                }
                            }
                        });
            }

            @Override
            public void onFailure(Call<Shop> call, Throwable t) {

            }
        });

    }
}