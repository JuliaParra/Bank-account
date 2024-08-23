package dev.julia;

public class App {
    public static void main(String[] args) {
      
        Account account = new Account(50000, 3);
        System.out.println("=== Account Test ===");
        account.deposit(20000);  
        account.withdraw(10000); 
        account.generateMonthlyStatement(); 
        account.printAccountDetails(); 

        System.out.println();

       
        SavingsAccount savingsAccount = new SavingsAccount(15000, 2);
        System.out.println("=== Savings Account Test ===");
        savingsAccount.withdraw(2000); 
        savingsAccount.deposit(5000);  
        savingsAccount.generateMonthlyStatement(); 
        savingsAccount.printAccountDetails(); 

        System.out.println();

        
        CheckingAccount checkingAccount = new CheckingAccount(10000, 1.5f);
        System.out.println("=== Checking Account Test ===");
        checkingAccount.withdraw(12000); 
        checkingAccount.deposit(5000);   
        checkingAccount.generateMonthlyStatement(); 
        checkingAccount.printAccountDetails(); 
    }
}

