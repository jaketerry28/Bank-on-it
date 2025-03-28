# Bank-on-it
ATM 
![ULM Screenshot](ULM.png)

 ## HasMenu

 An interface for menuing.  
 Will created the Scanner object input here since it will be used repeatedly.  
 Contains a menu method that returns a string.  
 Contains another method, start, that will function based off of the string value that menu returns.  

 ## CheckingAccount
	

```
public class CheckingAccount implemenets HasMenu, Serializable
---------------------------------------------------------------
CheckingAccount();
CheckingAccount(double balance);
String menu();
void start();
double getBalance();
String getBalanceString();
double getDouble();
void setBalance();
void checkBalance();
void makeDeposit();
void makeWithdrawa();
```
void start will call menu and return the user input. Based on the returned input, different methods will be called.   
1 - checkBalance: print out current balance in account.  
2 - makeDeposit: only make a deposit if greater than 0.  
3 - makeWithdrawal: only make a withdrawal if greater than 0 and less than current balance.  
0 - exit. 

We have multiple ways to get the balance.  
getBalance: return a double.  
getBalanceString: return a String using String.format to print out with "$" and 2 decimal places. Easier for report generation.  

getDouble: verify legal user input. If not a legal input, defaults to 0.00.  

setBalance: a setter to properly access private attributes.  

## SavingsAccount

```

```