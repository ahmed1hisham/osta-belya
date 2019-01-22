package com.example.ostabelya.models;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Mechanic {
    public String mid;
    public int mAcceptid;
    public String apiKey;
    public int walletId;
    public String name;
    public String description;
    public int rating;
    public int waitingTime;
    public int categoryy;
    public int age;
    public String location;
    public double wallet;
    public Map<String,Request> requests;
    public ArrayList<Transaction> transactions;
    public Map<String, Order> orders;
    public Map<String, Worker> workers;
    public Mechanic(String uid, int mAcceptid,String apiKey, String name, int age, String location, double wallet,
                    int rating, int waitingTime, int categoryy){
        this.mid= uid;
        this.name = name;
        this.age = age;
        this.location = location;
        this.wallet = wallet;
        this.mAcceptid = mAcceptid;
        requests = new HashMap<String, Request>();
        transactions = new ArrayList<Transaction>();
        orders = new HashMap<String, Order>();
        workers = new HashMap<String, Worker>();
        this.rating = rating;
        this.waitingTime = waitingTime;
        this.categoryy = categoryy;

    }
    public Mechanic(){

    }
}
