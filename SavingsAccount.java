//SavingsAccount.java

import java.util.Scanner;


public class SavingsAccount extends CheckingAccount{
    double interestRate;

    public static void main(String[] args){
        new SavingsAccount();
    } // end main

    public SavingsAccount(){
        this.interestRate = .05d;
    } // end constructor

    public void setInterestRate(){
        Scanner input = new Scanner(System.in);
        String sResult = input.nextLine();
        double result = 0d;
        try{
            result = Double.parseDouble(sResult);
        } catch (Exception e){
            System.out.println("not a legal input. Changing to 0.05");
            result = 0.05d;
        } // end try

        this.interestRate = result;
    } // end setInterestRate

    public double getInterestRate(){
        return interestRate;
    } // end getInterestRate

    public void calcInterest(){
        this.balance += (this.balance * this.interestRate);
    } // end calcInterest

} // end class