package com.example.ostabelya.models;

import java.util.ArrayList;

public class Mechanic {
    private String name;
    private int age;
    private String location;
    private double wallet;
    private ArrayList<Request> requests;

    public Mechanic(String name, int age, String location, double wallet){
        this.name = name;
        this.age = age;
        this.location = location;
        this.wallet = wallet;
        requests = new ArrayList<Request>();
    }
}
