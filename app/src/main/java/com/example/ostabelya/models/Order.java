package com.example.ostabelya.models;

//order from mechanic to the user
public class Order {
    public String orderID;
    public String mid;
    public String uid;
    public String token;
    public int moneyAmount;
    public String date;

    public Order(String orderId, String mid, String uid, String token, int moneyAmount, String date) {
        this.mid = mid;
        this.uid = uid;
        this.token = token;
        this.moneyAmount = moneyAmount;
        this.date = date;
        this.orderID = orderId;
    }
}
