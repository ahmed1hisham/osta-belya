package com.example.ostabelya.models;

public class Request {
    public String uid;
    public String mid;
    public String requestDate;
    public String requestSlot;
    public String status;

    public Request(String uid, String mid, String requestDate, String requestSlot, String status){
        this.uid = uid;
        this.mid = mid;
        this.requestDate = requestDate;
        this.requestSlot = requestSlot;
        this.status = status;
    }
    public Request(){

    }
}
