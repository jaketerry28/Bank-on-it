//Customer.java

//import java.util.*;
import java.io.*;

public class Customer extends User implements Serializable {
    //private static final Scanner input = new Scanner(System.in);

    protected CheckingAccount checking;
    protected SavingsAccount savings;

    public static void main(String[] args){
        new Customer();
        /*
        Customer c = new Customer();
        System.out.println("\n");
        if (c.login()){
            c.start();
        }
        */
    } // end main

    public Customer(){
        this.setUserName("");
        this.setPIN("");
        this.checking = new CheckingAccount();
        this.savings = new SavingsAccount();
    } // end constructor

    public Customer(String userName, String PIN){
        this.setUserName(userName);
        this.setPIN(PIN);
        this.checking = new CheckingAccount();
        this.savings = new SavingsAccount();
    } // end constructor

    // implements HasMenu so obligated to use methods 
    public String menu(){
        boolean keepGoing = true;
        while (keepGoing){
            System.out.println("\nCustomer Menu\n");
            System.out.println("0) Exit");
            System.out.println("1) Manage Checking Account");
            System.out.println("2) Manage Savings Account");
            System.out.println("3) Change PIN");
            System.out.print("Select an option: ");
            String response = input.nextLine();
            if (response.matches("[0-3]")){
            return response;
            } else{
                System.out.println("\nPlease enter a valid option 0-3.");
            } // end if
        } // end while
        return "0"; // for java error
    } // end menu

    public void start(){
        boolean keepGoing = true;

        while(keepGoing){
            String response = menu();

            if (response.equals("1")){
                System.out.println("\nChecking Account\n");
                System.out.println("Account Menu\n");
                this.checking.start();

            } else if (response.equals("2")){
                System.out.println("\nSavings Account\n");
                System.out.println("Account Menu\n");
                this.savings.start();

            } else if (response.equals("3")){
                System.out.println("\nEnter a new 4-digit pin.\n");
                this.changePIN();

            } else if (response.equals("0")){
                System.out.println("\nExiting...");
                keepGoing = false;

            } else {
                System.out.println("Sorry. I didn't understand");
            } // end if
        } // end while
    } // end start

    public void changePIN(){
        String newPIN = input.nextLine();
        if (newPIN.matches("\\d{4}")){
            this.setPIN(newPIN);
            System.out.println("Your new pin is: " + this.getPIN());
        } else {
            System.out.println("Please enter only 4 digits.");
        } // end if
    } // end changePIN
    

    public String getReport(){
        String checkingReport = this.checking.getBalanceString();
        String savingsReport = this.savings.getBalanceString();

        return "Checkings " + checkingReport + " Savings: " + savingsReport;
    } // end getReport
} // end class