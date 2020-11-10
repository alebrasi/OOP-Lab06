package it.unibo.oop.lab.exception1;

public class NotEnoughBatteryException extends RuntimeException{
	/**
	 * 
	 */
	private static final long serialVersionUID = -288979685441144222L;
	
	public NotEnoughBatteryException() {
		
	}
	
	@Override
	public String toString() {
		return "The robot doesn't have enough energy";
	}
	
	@Override
	public String getMessage() {
		return this.toString();
	}

}
