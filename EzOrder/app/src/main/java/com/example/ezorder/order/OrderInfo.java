package com.example.ezorder.order;

import java.util.List;

public class OrderInfo {
    private long orderId;
    private String orderStatus;
    private List<OrderCount> orderList;
    private Shop shop;

    public void setOrderId(long orderId) {
        this.orderId = orderId;
    }

    public Shop getShop() {
        return shop;
    }

    public void setShop(Shop shop) {
        this.shop = shop;
    }

    public OrderInfo(String orderStatus, List<OrderCount> orderList,Shop shop) {
        this.orderStatus = orderStatus;
        this.orderList = orderList;
        this.shop = shop;
    }

    public long getOrderId() {
        return orderId;
    }

    public void setOrderId(Long orderId) {
        this.orderId = orderId;
    }

    public String getOrderStatus() {
        return orderStatus;
    }

    public void setOrderStatus(String orderStatus) {
        this.orderStatus = orderStatus;
    }

    public List<OrderCount> getOrderList() {
        return orderList;
    }

    public void setOrderList(List<OrderCount> orderList) {
        this.orderList = orderList;
    }
}
