This README file is generated based on the source code provided.

# PikaBank Account Ledger Capstone

## Table of Contents

  * [Project Description](#-project-description)
  * [Application Screens](#-application-screen)
      * [Main Menu](#-main-menu)
      * [Ledger Menu](#-ledger-menu)
      * [Reports Menu](#-reports-menu)
  * [Interesting Piece of Code](#-interesting-piece-of-code)
  * [Project Tree](#-project-tree)

-----

## Project Description

The **PikaBank Account Ledger Capstone** is a console-based financial ledger application designed to help users track their income (deposits) and expenses (payments).

The application loads transaction data from a persistent file named `transactions.csv` upon startup. Users can interact with a simple menu system to perform core banking and reporting functions.

### Key Features:

  * **Add Deposit** and **Make Payment** (Debt) functions to record new transactions.
  * New transactions are automatically timestamped with the current date and time and appended to the `transactions.csv` file.
  * A **Ledger** feature allows viewing all entries, or filtering to only view **Deposits** or **Payments**.
  * A comprehensive **Reports** menu provides various time-based and vendor-specific filters, including Month to Date, Previous Month, Year to Date, Previous Year, and Search by Vendor.
  * Transactions are stored as `transactions` objects, which include fields for `date`, `time`, `description`, `vendor`, and `amount`.

-----

## Application Screens

As a console application, the user interface is text-based. Below are descriptions and placeholders for what each screen would look like.

### Main Menu

The main entry point allows users to add new transactions or access the ledger.

```
Welcome to the PikaBank!!! How may I help you? 
What would you like to do?
- (1) Add deposit 
- (2) Make Payment (Debt) 
- (3) Ledger
- (4) Exit 
```

### Ledger Menu

Accessed via option (3) from the main menu, this screen provides options for viewing the transaction history.

```
What would you like to do in the ledger?
                    
- (1) Display all entries
- (2) Display deposits
- (3) Display Payments 
- (4) Display reports 
- (5) Go back to main menu
```

### Reports Menu

Accessed via option (4) from the Ledger menu, this screen allows for specific, filtered views of the ledger data.

```
Reports
                    
1.) Month to Date
2.) Previous Month
3.) Year to Date
4.) Previous Year
5.) Search by vendor
0.) Back
```

-----

## Interesting Piece of Code

The application uses **Java Streams** to efficiently filter the list of transactions for displaying deposits, payments, and various reports. This is a concise and modern approach to data manipulation in Java.

The `displayDeposits()` method, for example, filters the main transaction list (`starmie`) to only include entries where the amount is greater than zero, demonstrating this concept.

```java
// Acct.java
public static void displayDeposits() {
    ArrayList<transactions> cake = starmie.stream()
            //filters starmie and filters it based on the conditional statement if its greater then 0
            .filter(t -> t.getAmount() > 0).collect(Collectors.toCollection(ArrayList::new)); // Only positive amounts
    displayEntries(cake);
}
```

-----

## Project Tree

The project structure follows a standard Maven layout for a Java application.

```
AccountLedgerCapstone
├── .idea/
├── src/
│   └── main/
│       └── java/
│           └── com/
│               └── pluralsight/
│                   ├── Acct.java          (Main application class and logic)
│                   └── transactions.java  (POJO for a single transaction)
├── pom.xml
├── transactions.csv         (Persistent data store for ledger entries)
└── .gitignore
```
