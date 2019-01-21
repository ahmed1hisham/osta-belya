package com.example.ostabelya.models;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Customer {
    public String uid;
    public String username;
    public int age;
    public double wallet;
    public String phoneNumber;
    public ArrayList<Request> requests;
    public Map<String, Order> paymentRequests;

    public Customer() {
    }

    public Customer(String uid, String username, int age, double wallet, String phoneNumber){
         this.uid = uid;
         this.username = username;
         this.age = age;
         this.wallet = wallet;
         this.phoneNumber = phoneNumber;
         this.requests = new ArrayList<Request>();
         this.paymentRequests = new HashMap<String, Order>();
    }

}

