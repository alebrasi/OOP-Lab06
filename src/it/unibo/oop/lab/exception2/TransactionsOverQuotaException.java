package it.unibo.oop.lab.exception2;

public class TransactionsOverQuotaException extends RuntimeException{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 380919217883973559L;

	public TransactionsOverQuotaException() {
	
	}
	
	@Override
	public String toString() {
		return "ATM transactions over the the maximum allowed";
	}
	
	@Override
	public String getMessage() {
		return this.toString();
	}
}
