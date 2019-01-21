package com.example.ostabelya.models;

import java.util.ArrayList;

public class Customer {
    private String username;
    private int age;
    private double wallet;
    private int phoneNumber;
    private ArrayList<Request> requests;


    public Customer(String username, int age, double wallet, int phoneNumber){
         this.username = username;
         this.age = age;
         this.wallet = wallet;
         this.phoneNumber = phoneNumber;
         this.requests = new ArrayList<Request>();
    }
}

