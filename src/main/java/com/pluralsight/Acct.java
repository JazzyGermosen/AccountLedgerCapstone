package com.pluralsight;

import java.io.BufferedReader;
import java.io.FileReader;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Scanner;

public class Acct {

    // creating a scanner for user input outside of the main method
    public static Scanner acctLedger = new Scanner(System.in);
    public static ArrayList<Transaction> starmie = new ArrayList<>();

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
                    // Display Add Deposit
                    addDeposit();
                    break;
                case 2:
                    // Display Make payment method
                    makePayment();
                    break;
                case 3:
                    // Display Ledger method
                    ledgar();
                    break;
                case 4:
                    System.out.println("Thank you for using PikaBank! We hope to see you again ");
                    //setting is running to false to make this statement
                    isRunning = false;
                    break;
                default:
                    System.out.println("Sorry that Is not an option please try again");
                    break;
            }

        }

    }


    //creating a method to help load the buffer reader
    public static void loadInfo(String nameOfFile) {
        //starting off with the buffer reader statement
        try {BufferedReader bufReader = new BufferedReader(new FileReader());
            // using a variable to store the new info after splitting it properly
            String[] pikamoney = pikamoney.split("\\|");
            //creating an object based on the split files
            //im not sure how to fix the first 2 but we will figure that out later
            // this was supposed to be pikamoney but not sure
            Transaction snivy = new Transaction(LocalDate.MIN[0], LocalTime.MIN[1], pikamoney[2], pikamoney[3], pikamoney[4]);
            // adding this to the product thingie
            starmie.add(snivy);

        } catch (Exception e) {
            System.out.println("Sorry I dont think i understand. Please try again later.");
            System.exit(0);
        }
    }

    //first we are going to start with the display add deposit
    public static double addDeposit (){
        // this is where we will prompt user for input on information and where will save it to the transaction.csv file
        // start with print statement
        // need to add an if statement or try catcch to make sure that it accounts for only numbers
        System.out.println("Please enter your deposit information: ");
        // didnt add a user input for desription aand vendor, will make a method later to make this more efficient
        String description = acctLedger.nextLine();
        String vendor = acctLedger.nextLine();
        double amount = acctLedger.nextDouble();
        // double[] = idk how to set the thing to the info but something tells me i also need a while loop to be able to
        // idk what the issues is here but will check later
        Transaction wynautt = new Transaction(amount, vendor, description);
        // once we create the object we need to add it to the transaction array list
        starmie.add(wynautt);

    }

    public static void makePayment (){
        //starting out with a print statement
        System.out.println("Please enter in your payment.");
        // using the double again to ask for user input
        // mostly going to recreate the last method
        // unsure but addinga  - sign to print as a negative number
        double amount = -acctLedger.nextDouble();
        Transaction diglett = new Transaction(amount);
        starmie.add(diglett);

    }

    public static void ledgar(){
        // creating another menu loop
        boolean isrunning = true;
        while(isrunning) {
            System.out.println("""
                    What would you like to do in the ledger?
                    
                    - (1) Display all entries
                    - (2) Display deposits
                    - (3) Display Payments 
                    - (4) Display reports 
                    - (5) Go back to main menu
                    
                    """);

            // creating a user input named choose option to ask for user input again
            int chooseOption = acctLedger.nextInt();
            switch (chooseOption){
                case 1;
                    displayEntries();
                    break;
                case 2;
                    displayDeposites();
                    break;
                case 3;
                    displayPayments();
                    break;
                case 4;
                    displayReports();
                    break;
                case 5;
                    // at the moment im going to just set isrunning to false
                    // am unsure if i need to set return to the main method
                    isrunning = false;
                    break;
            }
        }

    }

    public static void displayEntries(){

    }

    public static void displayDeposites(){

    }

    public static void displayPayments() {

    }
    public static void displayReports() {

    }

}
