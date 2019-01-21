package com.example.ostabelya.models;

public class Request {
    public Customer user;
    public Mechanic mechanic;
    public String requestDate;
    public String requestSlot;
    public String status;

    public Request(Customer customer, Mechanic mechanic, String requestDate, String requestSlot, String status){
        this.user = customer;
        this.mechanic = mechanic;
        this.requestDate = requestDate;
        this.requestSlot = requestSlot;
        this.status = status;
    }
}
