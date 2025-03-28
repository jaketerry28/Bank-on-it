//User.java

//import java.util.*;
import java.io.*;

public abstract class User implements HasMenu, Serializable{

    //private static final Scanner input = new Scanner(System.in);

    private String userName;
    private String PIN;

    public boolean login(){
        System.out.print("Username: ");
        String inputUserName = input.nextLine();
        System.out.print("PIN: ");
        String inputPIN = input.nextLine();
        if (loginARGS(inputUserName, inputPIN)){
            System.out.println("\nLogin Successful");
            return true;
        } else {
            System.out.println("\nLogin Failed");
            return false;
        }
    } // end login 

    public boolean loginARGS(String inputUserName, String inputPIN){
        if (this.userName.equals(inputUserName) && this.PIN.equals(inputPIN)){
            return true;
        } else {
            return false;
        } // end if
    } // end login

    public void setUserName(String userName){
        this.userName = userName;
    } // end userName

    public String getUserName(){
        return this.userName;
    } // end getUserName

    public void setPIN(String PIN){
        this.PIN = PIN;
    } // end setPin

    public String getPIN(){
        return this.PIN;
    } // end getPIN

    abstract String getReport();
} // end class