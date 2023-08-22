package com.example.ezorder.orderstatus;

import android.annotation.SuppressLint;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.ezorder.databinding.OrderStatusItemBinding;
import com.example.ezorder.order.OrderAdapter;
import com.example.ezorder.order.OrderInfo;

import java.util.ArrayList;

public class OrderStatusAdapter extends RecyclerView.Adapter<OrderStatusAdapter.MyViewHolder> {
    private ArrayList<OrderInfo> orderInfoList = new ArrayList<>();

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
        holder.binding.txtOrderStatus.setText(orderInfo.getOrderStatus());
        holder.binding.txtShopName.setText(orderInfo.getShop().getShopName());
        holder.binding.txtTotPrice.setText(Integer.toString(orderInfo.getTotPrice()));
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
