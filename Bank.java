//Bank.java

import java.util.*;

class CustomerList extends ArrayList<Customer> {};

public class Bank implements HasMenu{
    Scanner input = new Scanner(System.in);
    Admin admin;
    CustomerList customers = new CustomerList();


    public static void main(String[] args){
        new Bank();
        
    }
    public Bank(){
        this.admin = new Admin();
        this.start();

        // uncomment the next two lines to refresh data

        /*this.loadSampleCustomers();
        //this.saveCustomers();
        this.loadCustomers();
        this.start();
        this.saveCustomers();
        */
  } // end constructor

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
                System.out.println("\nCustomer Login:\n");
                for (Customer c: customers){
                    if (c.login()){
                        c.start();
                    } // end nested if 
                } // end for 
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
                System.out.println("\nFull Customer Report:\n");
                admin.getReport();

            } else if (response.equals("2")){
                System.out.println("\nAdd User:\n");

            } else if (response.equals("3")){
                System.out.println("\nApply Interest:\n");

            } else if (response.equals("0")){
                System.out.println("\nExiting...\n");
                keepGoing = false;
            } // end if
        } // end while
    } // end adminStart
}

