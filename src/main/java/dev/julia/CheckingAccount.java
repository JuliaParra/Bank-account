package dev.julia;

public class CheckingAccount extends Account {
    private float overdraft;

 
    public CheckingAccount(float initialBalance, float annualInterestRate) {
        super(initialBalance, annualInterestRate);
        this.overdraft = 0;
    }

    @Override
    public void withdraw(float amount) {
        if (amount > balance) {
            overdraft += (amount - balance);
            balance = 0;
        } else {
            balance -= amount;
        }
        withdrawalCount++;
    }

    @Override
    public void deposit(float amount) {
        if (overdraft > 0) {
            if (amount > overdraft) {
                balance += (amount - overdraft);
                overdraft = 0;
            } else {
                overdraft -= amount;
            }
        } else {
            balance += amount;
        }
        depositCount++;
    }

    @Override
    public void generateMonthlyStatement() {
        super.generateMonthlyStatement();
    }

    @Override
    public void printAccountDetails() {
        super.printAccountDetails();
        System.out.println("Overdraft: " + overdraft);
    }
}

