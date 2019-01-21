package com.example.ostabelya.models;

public class Payment {
    private Customer customer;
    private Mechanic mechanic;
    private double moneyAmount;

    public Payment(Customer customer, Mechanic mechanic, double moneyAmount) {
        this.customer = customer;
        this.mechanic = mechanic;
        this.moneyAmount = moneyAmount;
    }
}
