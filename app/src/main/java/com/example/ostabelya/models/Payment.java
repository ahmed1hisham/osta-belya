package com.example.ostabelya.models;

public class Payment {
    public String uid;
    public int mid;
    public double moneyAmount;
    public String date;

    public Payment() {
    }

    public Payment(String uid, int mid, double moneyAmount, String date) {
        this.uid = uid;
        this.mid = mid;
        this.moneyAmount = moneyAmount;
        this.date = date;
    }
}
