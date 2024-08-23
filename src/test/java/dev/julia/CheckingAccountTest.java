package dev.julia;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class CheckingAccountTest {
    private CheckingAccount checkingAccount;

    @BeforeEach
    public void setUp() {
        checkingAccount = new CheckingAccount(10000, 1.5f);  // Saldo inicial: 10000, Tasa anual: 1.5%
    }

    @Test
    public void testWithdrawWithinBalance() {
        checkingAccount.withdraw(5000);  // Retirar 5000
        assertEquals(5000, checkingAccount.getBalance(), 0.01);  // El saldo debería ser 5000
        // No debería haber sobregiro
    }

    @Test
    public void testWithdrawOverdraft() {
        checkingAccount.withdraw(15000);  // Retirar 15000, lo que causa un sobregiro
        assertEquals(0, checkingAccount.getBalance(), 0.01);  // El saldo debería ser 0
         // El sobregiro debería ser 5000
    }

    @Test
    public void testDepositToCoverOverdraftPartially() {
        checkingAccount.withdraw(15000);  // Crear un sobregiro de 5000
        checkingAccount.deposit(3000);  // Consignar 3000
         // El sobregiro debería reducirse a 2000
        assertEquals(0, checkingAccount.getBalance(), 0.01);  // No debería haber saldo positivo aún
    }

    @Test
    public void testDepositMoreThanOverdraft() {
        checkingAccount.withdraw(15000);  // Crear un sobregiro de 5000
        checkingAccount.deposit(6000);  // Consignar 6000
         // El sobregiro debería ser 0
        assertEquals(1000, checkingAccount.getBalance(), 0.01);  // El saldo debería ser 1000
    }

 
}

