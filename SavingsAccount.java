//SavingsAccount.java

import java.util.Scanner;

public class SavingsAccount extends CheckingAccount{
    //private static final Scanner input = new Scanner(System.in);

    private double interestRate;

    public static void main(String[] args){
        new SavingsAccount();
    } // end main

    public SavingsAccount(){
        this.interestRate = .05d;
        this.setBalance(0);
    } // end constructor

    public SavingsAccount(double balance){
        this.interestRate = .05d;
        this.setBalance(balance);
    } // end constructor

    public void setInterestRate(){
        String sResult = input.nextLine();
        double result = 0d;
        try{
            result = Double.parseDouble(sResult);
        } catch (Exception e){
            System.out.println("\nNot a legal input. Changing to 5%.\n");
            result = 0.05d;
        } // end try
        this.interestRate = result;
    } // end setInterestRate

    public double getInterestRate(){
        return interestRate;
    } // end getInterestRate

    public void calcInterest(){
        double currentBalance = this.getBalance();
        double interestBalance = (currentBalance * this.getInterestRate());
        this.setBalance(currentBalance + interestBalance);
    } // end calcInterest

} // end class