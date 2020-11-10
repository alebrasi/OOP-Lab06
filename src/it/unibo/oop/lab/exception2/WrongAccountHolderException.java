package it.unibo.oop.lab.exception2;

public class WrongAccountHolderException extends IllegalStateException{

	/**
	 * 
	 */
	private static final long serialVersionUID = 7190620326792084901L;
	
	private int id;
	
	public WrongAccountHolderException(final int id) {
		this.id = id;
	}
	
	@Override
	public String toString() {
		return "Operation executed from unauthorized user. User Id: " + id;
	}
	
	@Override
	public String getMessage() {
		return this.toString();
	}

}
