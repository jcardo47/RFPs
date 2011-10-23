package com.rfp.exception;

public class RFPStatusAlreadySaved extends Exception
{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public RFPStatusAlreadySaved()
	{
		super("Ya existe una estado almacenada con el mismo nombre");
	}
	
}
