package com.pluralsight;

import java.io.BufferedReader;
import java.io.FileReader;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Scanner;

public class Acct {

    // creating a scanner for user input outside of the main method
    public static Scanner acctLedger = new Scanner(System.in);

    public static void main(String[] args) {
        // create a welcome print to start off the code
        System.out.println("Welcome to the PikaBank!!! How may I help you? ");
        //loadInfo(Transaction.csv);
        // now that we created a method to read the transaction.csv file next we need to start with the main menu
        // we also need to create a menu loop so the first thing we will do is set isrunning = true
        boolean isRunning = true;
        while (optionChoice) {

            System.out.println("""
                    What would you like to do?
                    - (1) Add deposit 
                    - (2) Make Payment (Debt) 
                    - (3) Ledger
                    - (4) Exit """);

            // this is where we will prompt for user input to make a choice
            // now we will be using a switch statement that will contain the other methods that we need
            int chooseOption = acctLedger.nextInt();
            switch (chooseOption) {
                case 1:
                    // Display Add Deposit method
                    break;
                case 2:
                    // Display Make payment method
                    break;
                case 3:
                    // Display Ledger method
                case 4:
                    System.out.println("Thank you for using PikaBank! We hope to see you again ");
                default:
                    System.out.println("Sorry that Is not an option please try again");
                    break;
            }

        }

    }

    //first we are going to start with the display add deposit
    public static double addDeposit (){
        // this is where we will prompt user for input on information and where will save it to the transaction.csv file
        // start with print statement
        System.out.println("Please enter your deposit information: ");
        double depoinfo = acctLedger.nextDouble();
        // double[] = idk how to set the thing to the info but something tells me i also need a while loop to be able to
        Transaction starmie = new Transaction();



    }

    //creating a method to help load the buffer reader
    public static void loadInfo(String nameOfFile) {
        //starting off with the buffer reader statement
        try {BufferedReader bufReader = new BufferedReader(new FileReader());
            // using a variable to store the new info after splitting it properly
            String[] pikamoney = pikamoney.split("\\|");
            //creating an object based on the split files
            //im not sure how to fix the first 2 but we will figure that out later
            Transaction snivy = new Transaction(LocalDate.pikamoney[0], LocalTime.pikamoney[1], pikamoney[2], pikamoney[3], pikamoney[4]);
            // adding this to the product thingie
            // pokemonies.add(snivy);

        } catch (Exception e) {
            System.out.println("Sorry I dont think i understand. Please try again later.");
            System.exit(0);
        }
    }
}
