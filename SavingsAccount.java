//SavingsAccount.java


public class SavingsAccount extends CheckingAccount{
    double interestRate;

    public static void main(String[] args){
        new SavingsAccount();
    } // end main

    public SavingsAccount(){
        this.interestRate = .05d;
    } // end constructor

    public void setInterestRate(){
        this.interestRate = CheckingAccount.getDouble();
    } // end setInterestRate

    public double getInterestRate(){
        return interestRate;
    } // end getInterestRate

    public void calcInterest(){
        this.balance += (this.balance * this.interestRate);
    } // end calcInterest
} // end class