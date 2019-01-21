package com.example.ostabelya.models;

public class Transaction {
    public String userName;
    public String mid;
    public int moneyAmount;
    public String date;

    public Transaction() {
    }

    public Transaction(String customerName, String mid, int moneyAmount, String date) {
        this.userName = customerName;
        this.mid = mid;
        this.moneyAmount = moneyAmount;
        this.date = date;
    }
}
