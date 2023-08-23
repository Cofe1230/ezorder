package com.example.ezorder.orderstatus;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.ezorder.databinding.OrderStatusItemBinding;
import com.example.ezorder.order.OrderActivity;
import com.example.ezorder.order.OrderAdapter;
import com.example.ezorder.order.OrderInfo;

import java.util.ArrayList;

public class OrderStatusAdapter extends RecyclerView.Adapter<OrderStatusAdapter.MyViewHolder> {
    private ArrayList<OrderInfo> orderInfoList = new ArrayList<>();
    private Context context;

    //생성자
    public OrderStatusAdapter(Context context) {
        this.context = context;
    }

    /////////item///////
    public void addItem(OrderInfo orderInfo){
        orderInfoList.add(orderInfo);
        notifyDataSetChanged();
    }
    @NonNull
    @Override
    public OrderStatusAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        OrderStatusItemBinding binding = OrderStatusItemBinding.inflate(LayoutInflater.from(parent.getContext()),parent,false);
        return new MyViewHolder(binding);
    }
    @Override
    public void onBindViewHolder(@NonNull OrderStatusAdapter.MyViewHolder holder, @SuppressLint("RecyclerView") int position) {
        OrderInfo orderInfo = orderInfoList.get(position);
        //주문 내역 정보
        holder.binding.txtOrderStatus.setText(orderInfo.getOrderStatus());
        holder.binding.txtShopName.setText(orderInfo.getShop().getShopName());
        holder.binding.txtTotPrice.setText(Integer.toString(orderInfo.getTotPrice())+"원");

        String menuName = orderInfo.getOrderList().get(0).getMenu().getMenuName();
        int menuSize = orderInfo.getOrderList().size();
        int menuCount = orderInfo.getOrderList().get(0).getCount();
        long shopId = orderInfo.getShop().getShopId();

        if(menuSize>1){
            holder.binding.txtOrderMenu1.setText(menuName+" 외 "+menuCount+"개");
        }else{
            holder.binding.txtOrderMenu1.setText(menuName+" "+menuCount+"개");
        }
        //주문내역 클릭시 해당 가게 메뉴로 가기
        holder.binding.getRoot().setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(context, OrderActivity.class);
                intent.putExtra("shopId",shopId);
                context.startActivity(intent);
            }
        });

    }

    @Override
    public int getItemCount() {
        return orderInfoList==null?0:orderInfoList.size();
    }
    class MyViewHolder extends RecyclerView.ViewHolder{
        OrderStatusItemBinding binding;

        public MyViewHolder(OrderStatusItemBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
        }
    }
}
