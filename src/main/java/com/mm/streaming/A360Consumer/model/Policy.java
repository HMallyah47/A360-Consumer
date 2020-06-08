package com.mm.streaming.A360Consumer.model;

public class Policy {
    private int number;
    private String status;

    public Policy() {

    }

    public Policy(int number, String status) {
        this.number = number;
        this.status = status;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return  String.format("{\"number\":%d,\"status\":\"%s\"}", number, status);
    }
}
