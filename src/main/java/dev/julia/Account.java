package dev.julia;

public class Account {

   protected float balance;
   protected int depositCount;
   protected int withdrawalCount;
   protected float annualInterestRate;
   protected float monthlyFee;

 
   public Account(float initialBalance, float annualInterestRate) {
       this.balance = initialBalance;
       this.annualInterestRate = annualInterestRate;
       this.depositCount = 0;
       this.withdrawalCount = 0;
       this.monthlyFee = 0;
   }

   public float getBalance() {
       return balance;
   }

   public void setBalance(float balance) {
       this.balance = balance;
   }

   public int getDepositCount() {
       return depositCount;
   }

   public int getWithdrawalCount() {
       return withdrawalCount;
   }

   public float getAnnualInterestRate() {
       return annualInterestRate;
   }

   public void setAnnualInterestRate(float annualInterestRate) {
       this.annualInterestRate = annualInterestRate;
   }

   public float getMonthlyFee() {
       return monthlyFee;
   }

   public void setMonthlyFee(float monthlyFee) {
       this.monthlyFee = monthlyFee;
   }

  
   public void deposit(float amount) {
       balance += amount;
       depositCount++;
   }

   public void withdraw(float amount) {
       if (amount <= balance) {
           balance -= amount;
           withdrawalCount++;
       } else {
           System.out.println("Insufficient balance for the withdrawal.");
       }
   }

   public void calculateMonthlyInterest() {
       float monthlyInterestRate = (annualInterestRate / 12) / 100;
       balance += balance * monthlyInterestRate;
   }

   public void generateMonthlyStatement() {
       balance -= monthlyFee;
       calculateMonthlyInterest();
   }

   public void printAccountDetails() {
       System.out.println("Balance: " + balance);
       System.out.println("Deposit Count: " + depositCount);
       System.out.println("Withdrawal Count: " + withdrawalCount);
       System.out.println("Annual Interest Rate: " + annualInterestRate);
       System.out.println("Monthly Fee: " + monthlyFee);
   }
}
