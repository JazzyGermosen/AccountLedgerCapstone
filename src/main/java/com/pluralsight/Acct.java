package com.pluralsight;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.Scanner;

public class Acct {

    // creating a scanner for user input outside of the main method
    public static Scanner acctLedger = new Scanner(System.in);
    public static void main(String[] args) {
        // create a welcome print to start off the code
        System.out.println("Welcome to the PikaBank!!! How may I help you? ");

    }
    //creating a method to help load the buffer reader
    public static void loadInfo(String nameOfFile){
        //starting off with the buffer reader statement
        BufferedReader bufReader = new BufferedReader(new FileReader(nameOfFile));
        // using a variable to store the new info after splitting it properly
        String[] monion = monion.split("\\|");
        //creating an object based on the split files
        Transaction snivy = new Transaction(monion[0]);

    }
}
