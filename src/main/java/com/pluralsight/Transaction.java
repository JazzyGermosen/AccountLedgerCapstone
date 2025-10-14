package com.pluralsight;

public class Transaction {

    // this is the objects that we will be using
    // i havent created a transaction.csv so I will just use this as a placeholder for now
    private int date;
    private int time;
    private String description;
    private String vendor;
    private Double amount;

    // this is where we will be making the constructor method
    public Transaction(int date, int time, String description, String vendor, double amount){
        this.date = date;
        this.time = time;
        this.description = description;
        this.vendor = vendor;
        this.amount = amount;
    }
    // this is where I will create the getter and setter methods for my objects


    public int getDate() {
        return date;
    }

    public void setDate(int date) {
        this.date = date;
    }

    public int getTime() {
        return time;
    }

    public void setTime(int time) {
        this.time = time;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getVendor() {
        return vendor;
    }

    public void setVendor(String vendor) {
        this.vendor = vendor;
    }

    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }
}
