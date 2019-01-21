package com.example.ostabelya.models;

import java.util.ArrayList;

public class Customer {
    public String uid;
    public String username;
    public int age;
    public double wallet;
    public int phoneNumber;
    public ArrayList<Request> requests;


    public Customer(String uid, String username, int age, double wallet, int phoneNumber){
         this.uid = uid;
         this.username = username;
         this.age = age;
         this.wallet = wallet;
         this.phoneNumber = phoneNumber;
         this.requests = new ArrayList<Request>();
    }

}

