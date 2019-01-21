package com.example.ostabelya.models;

//order from mechanic to the user
public class Order {
    public int mid;
    public int uid;
    public String token;
    public int moneyAmount;
    public String date;

    public Order(int mid, int uid, String token, int moneyAmount, String date) {
        this.mid = mid;
        this.uid = uid;
        this.token = token;
        this.moneyAmount = moneyAmount;
        this.date = date;
    }
}
