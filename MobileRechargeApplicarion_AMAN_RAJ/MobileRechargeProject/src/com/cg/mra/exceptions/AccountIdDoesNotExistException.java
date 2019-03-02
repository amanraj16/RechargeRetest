package com.cg.mra.exceptions;

public class AccountIdDoesNotExistException extends Exception {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public AccountIdDoesNotExistException(String msg)
	{
		super(msg);
	}
}
