package com.rfp.bean;

import com.rfp.exception.RFPStatusAlreadySaved;
import com.rfp.to.RFPStatusTO;
import com.rfp.wrapper.RFPWrapper;

public class RFPStatusRegisterMB 
{
	private String message;
	private String name;
	
	public String register ()
	{
		String returnResult = "failure";
		RFPWrapper wrapper = new RFPWrapper();
		RFPStatusTO rfpStatusTO =  new RFPStatusTO();
		rfpStatusTO.setName(name);
		try 
		{
			rfpStatusTO = wrapper.registerRFPStatus(rfpStatusTO);
			returnResult = "success";
		}
		catch (RFPStatusAlreadySaved e) 
		{
			message = e.getMessage();
		}
		return returnResult;
	}
	
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
}
