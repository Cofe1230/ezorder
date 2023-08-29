package com.example.cafemanager.management;

import android.annotation.SuppressLint;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.cafemanager.databinding.OrderItemBinding;
import com.example.cafemanager.order.Menu;
import com.example.cafemanager.order.OrderCount;
import com.example.cafemanager.order.OrderInfo;

import java.util.ArrayList;
import java.util.List;

public class OrderAdapter extends RecyclerView.Adapter<OrderAdapter.OrderViewHolder> {
    private ArrayList<OrderInfo> orderInfoList;

    public OrderAdapter(ArrayList<OrderInfo> orderInfoList) {
        this.orderInfoList = orderInfoList;
    }
    //////item 처리//////
    public void addItem(OrderInfo orderInfo){
        orderInfoList.add(orderInfo);
        notifyDataSetChanged();
    }
    public void clear(){
        orderInfoList.clear();
    }
    @NonNull
    @Override
    public OrderAdapter.OrderViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        OrderItemBinding binding = OrderItemBinding.inflate(LayoutInflater.from(parent.getContext()),parent,false);
        return new OrderViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull OrderAdapter.OrderViewHolder holder, @SuppressLint("RecyclerView") int position) {
        OrderInfo orderInfo = orderInfoList.get(position);
        holder.binding.txtOrderId.setText(orderInfo.getOrderId()+"");
        String ordermenu="";
        for(OrderCount orderCount:orderInfo.getOrderList()){
            ordermenu+=orderCount.getMenu().getMenuName()+" "+orderCount.getCount()+"개\n";
        }
        holder.binding.txtMenu.setText(ordermenu);
    }

    @Override
    public int getItemCount() {
        return orderInfoList==null?0:orderInfoList.size();
    }
    class OrderViewHolder extends RecyclerView.ViewHolder{
        OrderItemBinding binding;
        public OrderViewHolder(OrderItemBinding binding) {
            super(binding.getRoot());
            this.binding=binding;
        }
    }
}
