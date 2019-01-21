package com.example.ostabelya.models;

import java.util.ArrayList;

public class Mechanic {
    public String uid;
    public String name;
    public int age;
    public String location;
    public double wallet;
    public ArrayList<Request> requests;
    public ArrayList<Payment> payments;

    public Mechanic(String uid, String name, int age, String location, double wallet){
        this.uid= uid;
        this.name = name;
        this.age = age;
        this.location = location;
        this.wallet = wallet;
        requests = new ArrayList<Request>();
        payments = new ArrayList<Payment>();
    }
}
