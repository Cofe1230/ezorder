package com.example.ezorder.fcm;

import android.content.SharedPreferences;
import android.util.Log;

import androidx.annotation.NonNull;

import com.example.ezorder.EzOrderClient;
import com.example.ezorder.member.Member;
import com.google.firebase.messaging.FirebaseMessagingService;
import com.google.firebase.messaging.RemoteMessage;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MyFirebaseMessagingService extends FirebaseMessagingService {

    @Override
    public void onNewToken(@NonNull String token) {
        super.onNewToken(token);
        Log.d("awevfaeaefa", "onNewToken: ");
        sendRegistrationToServer(token);
    }

    @Override
    public void onMessageReceived(@NonNull RemoteMessage remoteMessage) {
        super.onMessageReceived(remoteMessage);
    }

    @Override
    public void onMessageSent(@NonNull String s) {
        super.onMessageSent(s);
    }
    //토큰 db저장
    private void sendRegistrationToServer(String token){
        SharedPreferences preferences = getSharedPreferences("MemberInfo", MODE_PRIVATE);
        String memberName = preferences.getString("memberName","");
        Log.d("awevfaeaefa", "sendRegistrationToServer: "+memberName);
        Call<Void> call = EzOrderClient.getInstance().getMemberService().saveToken(new Member(memberName,token));
        call.enqueue(new Callback<Void>() {
            @Override
            public void onResponse(Call<Void> call, Response<Void> response) {

            }

            @Override
            public void onFailure(Call<Void> call, Throwable t) {

            }
        });
    }
}
