package com.example.ostabelya.models;

public class Worker {

    public String wid;
    public String name;
    public int accountNumber;
    public String imgURL;
    public int salary;

    public Worker(String uid, String name, int accountNumber, String imgURL, int salary){
        this.wid = uid;
        this.name = name;
        this.accountNumber = accountNumber;
        this.imgURL = imgURL;
        this.salary = salary;
    }
    public Worker(){

    }

}
