package com.pluralsight;

import java.io.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Acct {

    // creating a scanner for user input outside of the main method
    public static Scanner acctLedger = new Scanner(System.in);
    public static ArrayList<transactions> starmie = new ArrayList<>();

    public static void main(String[] args) {
        loadInfo();
        // create a welcome print to start off the code
        System.out.println("Welcome to the PikaBank!!! How may I help you? ");
        // now that we created a method to read the transaction.csv file next we need to start with the main menu
        // we also need to create a menu loop so the first thing we will do is set isrunning = true
        boolean isRunning = true;
        while (isRunning) {

            System.out.println("""
                    What would you like to do?
                    - (1) Add deposit 
                    - (2) Make Payment (Debt) 
                    - (3) Ledger
                    - (4) Exit """);

            // this is where we will prompt for user input to make a choice
            // now we will be using a switch statement that will contain the other methods that we need
            int chooseOption = acctLedger.nextInt();
            acctLedger.nextLine();
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
                    ledger();
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
    public static void loadInfo() {
        //starting off with the buffer reader statement
        try {
            BufferedReader bufReader = new BufferedReader(new FileReader("transactions.csv"));

            bufReader.readLine();

            String machop = bufReader.readLine();
            while ((machop = bufReader.readLine()) != null) {
                // using a variable to store the new info after splitting it properly
                String[] pikamoney = machop.split("\\|");
                //creating an object based on the split files
                //im not sure how to fix the first 2 but we will figure that out later
                // this was supposed to be pikamoney but not sure
                transactions snivy = new transactions(LocalDate.parse(pikamoney[0]), LocalTime.parse(pikamoney[1]), pikamoney[2], pikamoney[3], Double.parseDouble(pikamoney[4]));
                // adding this to the product thingie
                starmie.add(snivy);
            }

        } catch (Exception e) {
            System.out.println("Sorry I dont think i understand. Please try again later.");
            System.exit(0);
        }
    }

    //first we are going to start with the display add deposit
    public static void addDeposit() {
        // this is where we will prompt user for input on information and where will save it to the transaction.csv file
        // start with print statement
        // need to add an if statement or try catcch to make sure that it accounts for only numbers
        System.out.println("Please enter your deposit information: ");
        // didnt add a user input for desription aand vendor, will make a method later to make this more efficient
        LocalDate date = LocalDate.now();
        LocalTime time = LocalTime.now();
        System.out.println("please enter the description");
        String description = acctLedger.nextLine();
        System.out.println("please enter the vendor");
        String vendor = acctLedger.nextLine();
        System.out.println("please enter the amount");
        double amount = acctLedger.nextDouble();
        acctLedger.nextLine();
        // double[] = idk how to set the thing to the info but something tells me i also need a while loop to be able to
        // idk what the issues is here but will check later
        transactions wynautt = new transactions(date, time, description, vendor, amount);
        // once we create the object we need to add it to the transaction array list
        starmie.add(wynautt);
        try(FileWriter fileWriter = new FileWriter("transactions.csv", true);
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);) {
            String line =  date + "|" + time + "|" + description + "|" + vendor + "|" + amount;
            bufferedWriter.newLine();
            bufferedWriter.write(line);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }

    public static void makePayment() {
        //starting out with a print statement
        System.out.println("Please enter in your payment.");
        //fixing now
        LocalDate date = LocalDate.now();
        LocalTime time = LocalTime.now();
        System.out.println("please enter your description");
        String description = acctLedger.nextLine();
        System.out.println("please enter the vendor");
        String vendor = acctLedger.nextLine();
        // using the double again to ask for user input
        // mostly going to recreate the last method
        // unsure but addinga  - sign to print as a negative number
        System.out.println("please enter the amount");
        double amount = -Math.abs(acctLedger.nextDouble());
        acctLedger.nextLine();
        transactions diglett = new transactions(date, time, description, vendor, amount);
        starmie.add(diglett);
        try(FileWriter fileWriter = new FileWriter("transactions.csv", true);
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);) {
            String line =  date + "|" + time + "|" + description + "|" + vendor + "|" + amount;
            bufferedWriter.newLine();
            bufferedWriter.write(line);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }


    }

    public static void ledger() {
        // creating another menu loop
        boolean isrunning = true;
        while (isrunning) {
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
            acctLedger.nextLine();
            switch (chooseOption) {
                case 1:
                    displayEntries(starmie);
                    break;
                case 2:
                    displayDeposits();
                    break;
                case 3:
                    displayPayments();
                    break;
                case 4:
                    reports();
                    // need to do another menu loop for display mtd, previous month, ytd and previous
                    break;
                case 5:
                    // at the moment im going to just set isrunning to false
                    // am unsure if i need to set return to the main method
                    isrunning = false;
                    break;
            }
        }

    }

    public static void displayEntries(ArrayList<transactions> list) {
        //creating a display
        for (transactions t : list) {
            t.display();
        }
    }

    public static void displayDeposits() {
        ArrayList<transactions> ponyta = starmie.stream()
                //filters starmie and filters it based on the conditional statement if its greater then 0
                .filter(t -> t.getAmount() > 0).collect(Collectors.toCollection(ArrayList::new)); // Only positive amounts
        displayEntries(ponyta);

    }

    public static void displayPayments() {
        ArrayList<transactions> eletrike = starmie.stream()
                //filters starmie and filters it based on the conditional statement if its less then 0
                .filter(t -> t.getAmount() < 0).collect(Collectors.toCollection(ArrayList::new));
        displayEntries(eletrike);
    }


    public static void reports() {
        // creating another menu loop for reports
        // setting isrunning to true
        boolean isRunning = true;
        while (isRunning) {
            // asking for what user wants to do
            System.out.println("""
                    Reports
                    
                    1.) Month to Date
                    2.) Previous Month
                    3.) Year to Date
                    4.) Previous Year
                    5.) Search by vendor
                    0.) Back
                    """);
            // asking for user input to store in the switch statement
            int userInput = acctLedger.nextInt();
            acctLedger.nextLine();
            switch (userInput) {
                case 1:
                    monthToDate();
                    break;
                case 2:
                    previousMonth();
                    break;
                case 3:
                    yearToDate();
                    break;
                case 4:
                    previousYear();
                    break;
                case 5:
                    searchByVendor();
                    break;
                case 0:
                    isRunning = false;
                    break;

            }
        }
    }
    // since some of the data type is not recent the other methods will not print anything
    //adding in some data to show that it works
    public static void monthToDate() {
        List<transactions> voltorb = starmie.stream()
                //filters starmie and filters it based on the conditional statement if its greater then 0
                .filter(t -> t.getDate().getMonth() == LocalDate.now().getMonth() && t.getDate().getYear() == LocalDate.now().getYear()).collect(Collectors.toList());
        for (transactions t : voltorb) {
            t.display();
        }

    }

    public static void previousMonth() {
        List<transactions> charizard = starmie.stream()
                //this is checking for the previous month
                .filter(t -> t.getDate().getMonth() == LocalDate.now().minusMonths(1).getMonth()&& t.getDate().getYear() == LocalDate.now().getYear()).collect(Collectors.toList());
        for (transactions t : charizard) {
            t.display();
        }

    }

    public static void yearToDate() {
        List<transactions> gardevior = starmie.stream()
                //this is checking for the year to date and then display
                .filter(t -> t.getDate().getYear() == LocalDate.now().getYear()).collect(Collectors.toList());
        for (transactions t : gardevior) {
            t.display();
        }

    }

    public static void previousYear() {
        List<transactions> garchomp = starmie.stream()
                //this is filtering for the previous year
                .filter(t -> t.getDate().getYear() == LocalDate.now().minusYears(1).getYear()).collect(Collectors.toList());
        for (transactions t : garchomp) {
            t.display();
        }

    }

    public static void searchByVendor() {
        // ask for user input
        String pokevendor = acctLedger.nextLine();
        List<transactions> sandile = starmie.stream()
                //this is filtering by vendor and displaying it
                .filter(t -> t.getVendor().equals(pokevendor)).collect(Collectors.toList());
        for (transactions t : sandile) {
            t.display();
        }

    }

}
