package dev.julia;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class AccountTest {
    private Account account;

    @BeforeEach
    public void setUp() {
        account = new Account(10000, 2);  
    }

    @Test
    public void testDeposit() {
        account.deposit(5000);  
        assertEquals(15000, account.getBalance(), 0.01);  
    }

    @Test
    public void testWithdraw() {
        account.withdraw(2000);  
        assertEquals(8000, account.getBalance(), 0.01);  
    }

    @Test
    public void testWithdrawInsufficientBalance() {
        account.withdraw(12000);  
        assertEquals(10000, account.getBalance(), 0.01);  
    }

    @Test
    public void testCalculateMonthlyInterest() {
        account.calculateMonthlyInterest();  
        assertEquals(10016.67, account.getBalance(), 0.01);  
    }

    @Test
    public void testGenerateMonthlyStatement() {
        account.setMonthlyFee(100);  
        account.generateMonthlyStatement();  
        assertEquals(9916.5, account.getBalance(), 0.01);  
    }
}
