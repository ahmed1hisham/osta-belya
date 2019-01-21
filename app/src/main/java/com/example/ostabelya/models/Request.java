package com.example.ostabelya.models;

public class Request {
    private Customer user;
    private Mechanic mechanic;
    private String requestDate;
    private String requestSlot;
    private String status;

    public Request(Customer customer, Mechanic mechanic, String requestDate, String requestSlot, String status){
        this.user = customer;
        this.mechanic = mechanic;
        this.requestDate = requestDate;
        this.requestSlot = requestSlot;
        this.status = status;
    }
}
