package com.example.ostabelya.models;

public class Payment {
    public Customer customer;
    public Mechanic mechanic;
    public double moneyAmount;
    public String date;

    public Payment() {
    }

    public Payment(Customer customer, Mechanic mechanic, double moneyAmount, String date) {
        this.customer = customer;
        this.mechanic = mechanic;
        this.moneyAmount = moneyAmount;
        this.date = date;
    }
}
