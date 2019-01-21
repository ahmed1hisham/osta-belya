package com.example.ostabelya.models;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Mechanic {
    public int mid;
    public String apiKey;
    public int walletId;
    public String name;
    public int age;
    public String location;
    public double wallet;
    public ArrayList<Request> requests;
    public ArrayList<Transaction> transactions;
    public Map<String, Order> orders;
    public Map<String, Worker> workers;
    public Mechanic(int uid, String apiKey, String name, int age, String location, double wallet){
        this.mid= uid;
        this.name = name;
        this.age = age;
        this.location = location;
        this.wallet = wallet;
        requests = new ArrayList<Request>();
        transactions = new ArrayList<Transaction>();
        orders = new HashMap<String, Order>();
        workers = new HashMap<String, Worker>();
    }
}
