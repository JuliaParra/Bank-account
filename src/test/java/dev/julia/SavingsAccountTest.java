package dev.julia;




import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class SavingsAccountTest {
    private SavingsAccount savingsAccount;

    @BeforeEach
    public void setUp() {
        savingsAccount = new SavingsAccount(15000, 2);  
    }

    @Test
    public void testDepositActiveAccount() {
        savingsAccount.deposit(5000); 
        assertEquals(20000, savingsAccount.getBalance(), 0.01);  
    }

    @Test
    public void testWithdrawActiveAccount() {
        savingsAccount.withdraw(5000);  
        assertEquals(10000, savingsAccount.getBalance(), 0.01);  
    }

    @Test
    public void testWithdrawInactiveAccount() {
        savingsAccount.withdraw(14000);  
        assertEquals(1000, savingsAccount.getBalance(), 0.01); 
        savingsAccount.deposit(5000);  
        assertEquals(1000, savingsAccount.getBalance(), 0.01);  
    }

    @Test
    public void testGenerateMonthlyStatementWithExtraWithdrawals() {
        for (int i = 0; i < 5; i++) {
            savingsAccount.withdraw(1000); 
        }
        savingsAccount.generateMonthlyStatement();  
        assertEquals(10015 - 1000, savingsAccount.getBalance(), 0.01);  
    }
}
