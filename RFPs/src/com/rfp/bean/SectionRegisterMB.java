package com.rfp.bean;

import com.rfp.exception.SectionAlreadySaved;
import com.rfp.to.SectionTO;
import com.rfp.wrapper.RFPWrapper;

public class SectionRegisterMB 
{
	private String message;
	private String name;
	
	public String register()
	{
		String result = "failure";
		RFPWrapper wrapper = new RFPWrapper();
		SectionTO sectionTO = new SectionTO();
		sectionTO.setName(name);
		try 
		{
			sectionTO = wrapper.registerSection(sectionTO);
			result = "success";			
		}
		catch (SectionAlreadySaved e) 
		{
			message = e.getMessage();
		}
		return result;
		
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
