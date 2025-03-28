//Admin.java

public class Admin extends User{
    
    public static void main(String[] args){
        new Admin();
    } // end main

    public Admin(){
        this.setUserName("admin"); // admin username
        this.setPIN("0000"); // admin pin
    } // end constructor

    public String menu(){
        boolean keepGoing = true;
        while (keepGoing){
            System.out.println("\nAdmin Menu\n");
            System.out.println("0) Exit");
            System.out.println("1) Full Customer Report");
            System.out.println("2) Add User");
            System.out.println("3) Apply Interest to Savings Accounts");
            System.out.print("Select an option: ");
            String response = input.nextLine();
            if (response.matches("[0-3]")){
                keepGoing = false;
                return response;
            } else{
                System.out.println("\nPlease enter a valid option 0-3.\n");
            } // end if
        } // end while
        return "0"; // satisfy java error
    } // end menu

    public void start(){
        
    } // end start

    public String getReport(){
        return null;
    } // end getReport
} // end class