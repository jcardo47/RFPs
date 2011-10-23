package com.rfp.exception;

public class InvalidPassword extends Exception 
{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public InvalidPassword ()
	{
		super("La contraseña es incorrecta");
	}
	
}
