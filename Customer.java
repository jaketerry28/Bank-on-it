//Customer.java

public class Customer extends User{
    CheckingAccount checking;
    SavingsAccount savings;

    public Customer(){
        this.userName = "Alice";
        this.PIN = "1111";
        checking = new CheckingAccount();
        savings = new SavingsAccount();
    } // end constructor

    public Customer(String userName, String PIN){
        this.userName = userName;
        this.PIN = PIN;
    } // end constructor

    // implements HasMenu so obligated to use methods 
    public String menu(){
        System.out.println("\nCustomer Menu\n");
        System.out.println("0) Exit");
        System.out.println("1) Manage Checking Account");
        System.out.println("2) Manage Savings Account");
        System.out.println("3) Change PIN");
        System.out.print("Select an option: ");
        String response = input.nextLine();
        return response;
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
                savings.start();

            } else if (response.equals("3")){
                System.out.println("\nSorry not implemented yet :)\n");

            } else if (response.equals("0")){
                System.out.println("\nExiting...");
                keepGoing = false;

            } else {
                System.out.println("Sorry. I didn't understand");
            } // end if
        } // end while
    } // end start

    /*public void changePIN(){
        
    } // end changePin
    */

    public String getReport(){
        String checkingReport = this.checking.getBalanceString();
        String savingsReport = this.savings.getBalanceString();

        return "Checking " + checkingReport + " Savings: " + savingsReport;
    } // end getReport

    public static void main(String[] args){
        Customer c = new Customer();
        System.out.println("\n");
        if (c.login()){
            c.start();
        }
        
    } // end main
} // end class