package dev.julia;

public class SavingsAccount extends Account {
    private boolean active;

    public SavingsAccount(float initialBalance, float annualInterestRate) {
        super(initialBalance, annualInterestRate);
        this.active = initialBalance >= 10000;
    }

    
    private void checkAccountStatus() {
        active = balance >= 10000;
    }

    @Override
    public void deposit(float amount) {
        if (active) {
            super.deposit(amount);
        } else {
            System.out.println("The account is inactive. Deposits are not allowed.");
        }
        checkAccountStatus();
    }

    @Override
    public void withdraw(float amount) {
        if (active) {
            super.withdraw(amount);
        } else {
            System.out.println("The account is inactive. Withdrawals are not allowed.");
        }
        checkAccountStatus();
    }

    @Override
    public void generateMonthlyStatement() {
        if (withdrawalCount > 4) {
            monthlyFee += (withdrawalCount - 4) * 1000;
        }
        super.generateMonthlyStatement();
        checkAccountStatus();
    }

    @Override
    public void printAccountDetails() {
        super.printAccountDetails();
        System.out.println("Account Status: " + (active ? "Active" : "Inactive"));
    }
}
