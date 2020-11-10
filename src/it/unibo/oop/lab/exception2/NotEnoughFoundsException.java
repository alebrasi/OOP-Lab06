package it.unibo.oop.lab.exception2;

public class NotEnoughFoundsException extends RuntimeException{

	/**
	 * 
	 */
	private static final long serialVersionUID = -1159808475879283028L;
	public NotEnoughFoundsException() {
	
	}
	
	@Override
	public String toString() {
		return "Not enough money to perform withdraw";
	}
	
	@Override
	public String getMessage() {
		return this.toString();
	}

}
