package com.example.ezorder.order;

import java.util.List;

public class OrderInfo {
    private Long orderId;
    private String orderStatus;
    private List<OrderCount> orderList;

    public OrderInfo(String orderStatus, List<OrderCount> orderList) {
        this.orderStatus = orderStatus;
        this.orderList = orderList;
    }

    public Long getOrderId() {
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
