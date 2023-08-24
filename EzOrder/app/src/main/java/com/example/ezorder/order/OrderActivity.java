package com.example.ezorder.order;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Toast;


import com.example.ezorder.EzOrderClient;
import com.example.ezorder.R;
import com.example.ezorder.databinding.ActivityOrderBinding;
import com.example.ezorder.member.Member;
import com.example.ezorder.member.MemberService;
import com.example.ezorder.orderstatus.OrderStatusActivity;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.messaging.FirebaseMessaging;
import com.google.firebase.messaging.FirebaseMessagingService;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;


import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class OrderActivity extends AppCompatActivity {
    private ActivityOrderBinding binding;
    private ArrayList<Menu> menuList = new ArrayList<>();
    private ArrayList<OrderCount> orderList = new ArrayList<>();
    private int totalPrice;//전체가격
    private String memberName;
    private Member member;
    private long shopid;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        //binding : Oerder Activity binding
        //menuList : 해당 가게의 메뉴들
        binding = ActivityOrderBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        //retrofit Service
        OrderService orderService = EzOrderClient.getInstance().getOrderService();
        MenuService menuService = EzOrderClient.getInstance().getMenuService();

        //TestMenu(DB구성시 삭제) menu: id, name, price, imgname
//        Shop shop = new Shop(1,"1",1,1,"1");

        Intent orderIntent = getIntent();
        shopid = orderIntent.getLongExtra("shopId",2);
//        menuList.add(new Menu(1,"아메리카노",1500,"1"));
//        menuList.add(new Menu(2,"카페라떼",3000,"1"));
//        menuList.add(new Menu(3,"카푸치노",3000,"1"));
//        menuList.add(new Menu(4,"카라멜 마끼아또",4000,"1"));

        //test
        FirebaseMessaging.getInstance().getToken()
                .addOnCompleteListener(new OnCompleteListener<String>() {
                    @Override
                    public void onComplete(@NonNull Task<String> task) {
                        if (!task.isSuccessful()) {
                            Log.w("awevfaeaefa", "Fetching FCM registration token failed", task.getException());
                            return;
                        }

                        // Get new FCM registration token
                        String token = task.getResult();

                        // Log and toast
                        String msg = getString(R.string.msg_token_fmt, token);
                        Log.d("awevfaeaefa", msg);
                        Toast.makeText(OrderActivity.this, msg, Toast.LENGTH_SHORT).show();
                    }
                });

        MenuAdapter menuAdapter = new MenuAdapter(menuList);
        OrderAdapter orderAdapter = new OrderAdapter(orderList);
        SharedPreferences preferences = getSharedPreferences("MemberInfo", MODE_PRIVATE);
        
        //랜덤 아이디 생성 + SharedPreferences에 저장 없으면 아이디생성 있으면 아이디 토스트로 띄우기만
        memberName = preferences.getString("memberName","");
        member = new Member(memberName);



        //recyclerview menu setting
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(OrderActivity.this,RecyclerView.VERTICAL,false);
        binding.recyclerViewMenu.setLayoutManager(linearLayoutManager);
        binding.recyclerViewMenu.setAdapter(menuAdapter);

        //recyclerview order setting
        LinearLayoutManager linearLayoutManager2 = new LinearLayoutManager(OrderActivity.this,RecyclerView.VERTICAL,false);
        binding.recyclerViewCart.setLayoutManager(linearLayoutManager2);
        binding.recyclerViewCart.setAdapter(orderAdapter);

        //메뉴 리스트
        Call<List<Menu>> call = menuService.findByShop(shopid);
        call.enqueue(new Callback<List<Menu>>() {
            @Override
            public void onResponse(Call<List<Menu>> call, Response<List<Menu>> response) {
                for(Menu m : response.body()){
                    menuList.add(m);

                }
                menuAdapter.notifyDataSetChanged();
            }

            @Override
            public void onFailure(Call<List<Menu>> call, Throwable t) {

            }
        });




        //menu클릭
        menuAdapter.setOnItemClickListener(new MenuAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(int pos) {
                // flag 같은 주문이 없으면 0 있으면 1
                int flag = 0;

                for(int i=0; i<orderList.size(); i++){
                    Menu m = orderList.get(i).getMenu();
                    if(m.equals(menuList.get(pos))){
                        orderList.get(i).setCount(orderList.get(i).getCount()+1);
                        orderAdapter.updateItem(orderList.get(i),i);
                        totalPrice+=menuList.get(pos).getPrice();
                        binding.txtTotalPrice.setText(totalPrice+" 원");
                        flag = 1;
                        break;
                    }
                }
                if(flag==0){
                    OrderCount orderCount = new OrderCount(menuList.get(pos),1,null);
                    orderAdapter.addItem(orderCount);
                    totalPrice+=menuList.get(pos).getPrice();
                    binding.txtTotalPrice.setText(totalPrice+" 원");
                }

            }
        });


        //주문하기 버튼 클릭
        binding.btnOrder.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                orderList = orderAdapter.getOrderList();
                OrderInfo orderInfo = new OrderInfo("주문접수",orderList,new Shop(shopid),member,totalPrice);
                Call<Void> call = orderService.save(orderInfo);
                call.enqueue(new Callback<Void>() {
                    @Override
                    public void onResponse(Call<Void> call, Response<Void> response) {
                        Toast.makeText(getApplicationContext(),"주문성공", Toast.LENGTH_SHORT).show();
                        Intent intent = new Intent(getApplicationContext(), OrderStatusActivity.class);
                        startActivity(intent);
                    }

                    @Override
                    public void onFailure(Call<Void> call, Throwable t) {
                        Log.d("테스트", "onResponse: 실패");
                    }
                });
            }
        });//주문하기 버튼 종료

        //item 삭제 버튼 클릭
        orderAdapter.setOnRemoveBtnClickListener(new OrderAdapter.OnRemoveBtnClickListener() {
            @Override
            public void onRemoveBtnClick(int position, int price) {
                totalPrice-=price;
                binding.txtTotalPrice.setText(totalPrice+"원");

            }
        });

        //테스트버튼
        binding.testbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), OrderStatusActivity.class);
                startActivity(intent);
            }
        });

    }
}