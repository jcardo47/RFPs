package com.rfp.exception;

public class UserRegisterException extends Exception 
{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public UserRegisterException ()
	{
		super ("El nombre de usuario ya se encuentra registrado");
	}
}
