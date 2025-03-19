//CheckingAccount.java

import java.util.Scanner;

public class CheckingAccount implements HasMenu{
    Scanner input = new Scanner(System.in);
    double balance;

    public static void main(String[] args){
        new CheckingAccount();
    } // end main

    public CheckingAccount(){
        this.balance = 0;
    } // end constructor

    public CheckingAccount(double balance){
        this.balance = balance;
    } // end constructor

   public String menu(){
        //prints a menu, returns a single character string 0, 1, or 2
        System.out.println("Select an option");
        System.out.println("0) Exit");
        System.out.println("1) Check Balance");
        System.out.println("2) Make a Deposit");
        System.out.println("3) Make a Withdrawal");
        String response = input.nextLine();
        return response;
    } // end menu

   public void start(){
        boolean keepGoing = true;

        while(keepGoing){
            String response = menu();

            if (response.equals("1")){
                System.out.println("Checking Account Balance: " +getBalanceString() + ".");

            } else if (response.equals("2")){
                makeDeposit();

            } else if (response.equals("3")){
                makeWithdrawal();

            } else if (response.equals("0")){
                System.out.println("Exiting...");
                keepGoing = false;

            } else {
                System.out.println("Sorry. I didn't understand");
            } // end if
        } // end while
    } // end constructor

   public double getBalance(){
        return balance;
    } // end getBalance

   public String getBalanceString(){
        String balanceString = String.valueOf(balance);
        return balanceString;
    } // end getBalanceString

    private double getDouble(){
        Scanner input = new Scanner(System.in);
        String sResult = input.nextLine();
        double result = 0d;
        try{
            result = Double.parseDouble(sResult);
        } catch (Exception e){
            System.out.println("not a legal input. Changing to 0");
            result = 0d;
        } // end try
        return result;
    } //end getDouble

   public void setBalance(double balance){
        this.balance = balance;
    } // end setBalance

   public void checkBalance(){
        System.out.println("Your current balance is: " + getBalanceString() + ".");
    } // end checkBalance

    public void makeDeposit(){
        System.out.println("Making a deposit...\nHow much to deposit? ");
        double deposit = getDouble();
        this.balance += deposit;
        System.out.println("New balance: $" + getBalanceString() + ".");

    } // end makeDeposit

    public void makeWithdrawal(){
        System.out.println("Making a withdrawal...\nHow much to withdraw?");
        double withdrawal = getDouble();
        this.balance -= withdrawal;
        System.out.println("Current Balance: " + getBalanceString() + ".");
    } // end makeWithdrawal
} // end class