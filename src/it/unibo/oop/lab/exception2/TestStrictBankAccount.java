package it.unibo.oop.lab.exception2;

import org.junit.Assert;
import org.junit.Test;

/**
 * JUnit test to test
 * {@link StrictBankAccount}.
 * 
 */
public class TestStrictBankAccount {

    /**
     * Used to test Exceptions on {@link StrictBankAccount}.
     */
    @Test
    public void testBankOperations() {
        /*
         * 1) Creare due StrictBankAccountImpl assegnati a due AccountHolder a
         * scelta, con ammontare iniziale pari a 10000 e nMaxATMTransactions=10
         * 
         * 2) Effetture un numero di operazioni a piacere per verificare che le
         * eccezioni create vengano lanciate soltanto quando opportuno, cioè in
         * presenza di un id utente errato, oppure al superamento del numero di
         * operazioni ATM gratuite.
         */
    	
    	BankAccount ba1 = new StrictBankAccount(1, 10000, 10);
    	BankAccount ba2 = new StrictBankAccount(2, 10000, 10);
    	
    	AccountHolder ah1 = new AccountHolder("mr clean", "d'annunzio", 1);
    	AccountHolder ah2 = new AccountHolder("mr clean", "d'annunzio 2", 2);
    	
    	try {
    		ba1.deposit(ah2.getUserID(), 12);
    		Assert.fail();
    	}catch(WrongAccountHolderException | TransactionsOverQuotaException ex) {
    		Assert.assertNotNull(ex);
    	}
    	
    	try {
    		ba1.deposit(ah1.getUserID(), 12);
    	}catch(WrongAccountHolderException | TransactionsOverQuotaException ex) {
    		Assert.fail();
    		Assert.assertNotNull(ex);
    	}
    	
    	ba1.withdraw(ah1.getUserID(), 10012);
    	
    	try {
    		ba1.withdraw(ah1.getUserID(), 1);
    		Assert.fail();
    	}catch(WrongAccountHolderException | TransactionsOverQuotaException | NotEnoughFoundsException ex) {
    		Assert.assertNotNull(ex);
    	}
    	
    	ba1.deposit(ah1.getUserID(), 10000);
    	
    	for(int i = ba1.getNTransactions();i <= 10;i++) {
    		ba1.withdrawFromATM(ah1.getUserID(), 1);
    	}
    	
    	try {
    		ba1.withdrawFromATM(ah1.getUserID(), 12);
    		Assert.fail();
    	}catch(WrongAccountHolderException | TransactionsOverQuotaException | NotEnoughFoundsException ex) {
    		Assert.assertNotNull(ex);
    	}
    	
    	
    	
    }
}
