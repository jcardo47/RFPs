package com.rfp.exception;

public class SectionAlreadySaved extends Exception 
{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public SectionAlreadySaved ()
	{
		super("Ya existe una secci�n almacenada con el mismo nombre");
	}
	
}
