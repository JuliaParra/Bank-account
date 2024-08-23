package dev.julia;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class CheckingAccountTest {
    private CheckingAccount checkingAccount;

    @BeforeEach
    public void setUp() {
        checkingAccount = new CheckingAccount(10000, 1.5f);  
    }

    @Test
    public void testWithdrawWithinBalance() {
        checkingAccount.withdraw(5000);  
        assertEquals(5000, checkingAccount.getBalance(), 0.01);  
       
    }

    @Test
    public void testWithdrawOverdraft() {
        checkingAccount.withdraw(15000);  
        assertEquals(0, checkingAccount.getBalance(), 0.01);  
         
    }

    @Test
    public void testDepositToCoverOverdraftPartially() {
        checkingAccount.withdraw(15000);  
        checkingAccount.deposit(3000);  
        
        assertEquals(0, checkingAccount.getBalance(), 0.01); 
    }

    @Test
    public void testDepositMoreThanOverdraft() {
        checkingAccount.withdraw(15000); 
        checkingAccount.deposit(6000); 
        
        assertEquals(1000, checkingAccount.getBalance(), 0.01);  
    }

 
}

