package com.example.ostabelya.models;

public class Transaction {
    public String userName;
    public int mid;
    public int moneyAmount;
    public String date;

    public Transaction() {
    }

    public Transaction(String customerName, int mid, int moneyAmount, String date) {
        this.userName = customerName;
        this.mid = mid;
        this.moneyAmount = moneyAmount;
        this.date = date;
    }
}
