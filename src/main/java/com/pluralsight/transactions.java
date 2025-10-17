package com.pluralsight;

import java.time.LocalDate;
import java.time.LocalTime;

public class transactions {

    // this is the objects that we will be using
    // i havent created a transaction.csv so I will just use this as a placeholder for now
    private LocalDate date;
    private LocalTime time;
    private String description;
    private String vendor;
    private double amount;

    // this is where we will be making the constructor method
    public transactions(LocalDate date, LocalTime time, String description, String vendor, double amount) {
        this.date = date;
        this.time = time;
        this.description = description;
        this.vendor = vendor;
        this.amount = amount;
    }
    // this is where I will create the getter and setter methods for my objects


    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public LocalTime getTime() {
        return time;
    }

    public void setTime(LocalTime time) {
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

    public void display() {
        System.out.println(String.join("|", this.date.toString(), this.time.toString(),
                this.description, this.vendor, String.valueOf(String.format("%.2f", this.amount))));

    }
}
