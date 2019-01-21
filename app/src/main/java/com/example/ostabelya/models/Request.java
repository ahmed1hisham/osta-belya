package com.example.ostabelya.models;

public class Request {
    public int uid;
    public int mid;
    public String requestDate;
    public String requestSlot;
    public String status;

    public Request(int uid, int mid, String requestDate, String requestSlot, String status){
        this.uid = uid;
        this.mid = mid;
        this.requestDate = requestDate;
        this.requestSlot = requestSlot;
        this.status = status;
    }
    public Request(){

    }
}
