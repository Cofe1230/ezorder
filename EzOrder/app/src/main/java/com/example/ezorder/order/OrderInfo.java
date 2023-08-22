package com.example.ezorder.order;

import java.util.List;

public class OrderInfo {
    private long orderId;
    private String orderStatus;
    private List<OrderCount> orderList;
    private Shop shop;
    private String memberName;
    private int totPrice;

    public void setOrderId(long orderId) {
        this.orderId = orderId;
    }

    public Shop getShop() {
        return shop;
    }

    public void setShop(Shop shop) {
        this.shop = shop;
    }

    public OrderInfo(String orderStatus, List<OrderCount> orderList,Shop shop,String memberName,int totPrice) {
        this.orderStatus = orderStatus;
        this.orderList = orderList;
        this.shop = shop;
        this.memberName = memberName;
        this.totPrice = totPrice;
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

    public String getmemberName() {
        return memberName;
    }

    public void setmemberName(String memberName) {
        this.memberName = memberName;
    }

    public int getTotPrice() {
        return totPrice;
    }

    public void setTotPrice(int totPrice) {
        this.totPrice = totPrice;
    }
}
