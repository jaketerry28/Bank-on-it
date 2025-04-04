//Bank.java

import java.util.*;
import java.io.*;

class CustomerList extends ArrayList<Customer> {};

public class Bank implements HasMenu{

    //private static final Scanner input = new Scanner(System.in);

    private Admin admin;
    private CustomerList customers = new CustomerList();

    public static void main(String[] args){
        new Bank();
    }

    public Bank(){

        this.admin = new Admin();

        // uncomment the next two lines to refresh data
        this.loadSampleCustomers();
        this.saveCustomers();

        this.loadCustomers();
        this.start();
        this.saveCustomers();
    } // end constructor

    public void loadSampleCustomers(){
        customers.add(new Customer("Alice", "1111"));
        customers.get(0).checking.setBalance(1000.00);
        customers.get(0).savings.setBalance(1000.00);
        customers.add(new Customer("Bob", "2222"));
        customers.add(new Customer("Cindy", "3333"));
    } // end loadSampleCustomers

    public void saveCustomers(){
        try {
        FileOutputStream fo = new FileOutputStream("customerArray.dat");
        ObjectOutputStream obOut = new ObjectOutputStream(fo);
        obOut.writeObject(customers);
        obOut.close();
        fo.close();
        } catch (Exception e){
         System.out.println(e.getMessage());
        } // end try
    } // end saveCustomers

     public void loadCustomers(){
       try {
        FileInputStream fIn = new FileInputStream("customerArray.dat");
        ObjectInputStream obIn = new ObjectInputStream(fIn);
        customers = (CustomerList)obIn.readObject();
        //System.out.println(customers.get(0).getReport());
        obIn.close();
        fIn.close();
        }catch (Exception e){
         System.out.println(e.getMessage());
        } // end try
    } // end loadCustomers

    public void fullCustomerReport(){
        System.out.println("\nFull Customer Report:\n");
        for (Customer c: customers){
            System.out.print("User: " + c.getUserName() + ", " + c.getReport() + "\n");
        } // end for
    } // end fullCustomerReport   

    public void addUser(){

        System.out.println("\nAdd User:\n");
        System.out.print("Enter new account holder name: ");
        String name = input.nextLine();
        System.out.print("Create a 4 digit PIN: ");
        String PIN = input.nextLine();
        if (PIN.matches("\\d{4}")){
            customers.add(new Customer(name, PIN));
        } else {
            System.out.println("Please enter only 4 digits.");
        } // end  if
    } // end addUser

    public void addInterest(){
        System.out.println("Apply Interest");
        for (Customer c: customers){
            c.savings.calcInterest();
            System.out.println("\nUser: " + c.getUserName() +", New Balance: " + c.savings.getBalanceString()
            + ", Applied Interest Rate: " + c.savings.getInterestRate());
        } // end for
    } // end addInterest  

    public void loginAsCustomer(){
        System.out.println("\nCustomer Login:\n");
        System.out.print("Username: ");
        String userNameIn = input.nextLine();
        System.out.print("PIN: ");
        String pinIN = input.nextLine();

        Customer currentCustomer = null;

        for(Customer c: customers){
            if (c.loginARGS(userNameIn, pinIN)){
                System.out.println("Login Successful");
                currentCustomer = c;
            } // end if
        } // end for

        if (currentCustomer == null){
            System.out.println("\nIncorrect Username or PIN.\n");
        
        } else {
            currentCustomer.start();
        } // end for
    } // end loginAsCustomer

   public void start(){
        boolean keepGoing = true;

        while(keepGoing){
            String response = menu();

            if (response.equals("1")){
                System.out.println("\nAdmin Login:\n");
                if (admin.login()){
                    adminStart();
                }

            } else if (response.equals("2")){
                this.loginAsCustomer();

            } else if (response.equals("0")){
                System.out.println("\nExiting...\n");
                keepGoing = false;
            } // end if
        } // end while
    } // end constructor

   public String menu(){
        //prints a menu, returns a single character string 0, 1, or 2
        while(true){
            System.out.println("0) Exit");
            System.out.println("1) Login as admin");
            System.out.println("2) Login as customer");
            System.out.print("\nSelect an option: ");
            String response = input.nextLine();
            if (response.matches("[0-2]")){
                return response;
            } else{
                System.out.println("Enter a valid option 0-2");
            } // end if
        } // end while
    } // end menu

    public void adminStart(){
        boolean keepGoing = true;
        while (keepGoing){
            String response = admin.menu();

            if (response.equals("1")){
                this.fullCustomerReport();

            } else if (response.equals("2")){
                this.addUser();
                
            } else if (response.equals("3")){
                System.out.println("\nApply Interest:\n");
                this.addInterest();

            } else if (response.equals("0")){
                System.out.println("\nExiting...\n");
                keepGoing = false;
            } // end if
        } // end while
    } // end adminStart
}

