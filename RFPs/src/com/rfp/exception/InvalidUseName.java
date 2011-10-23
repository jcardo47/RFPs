package com.rfp.exception;

public class InvalidUseName extends Exception 
{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public InvalidUseName ()
	{
		super("El Nombre de usuario es Inválido");
	}
}
