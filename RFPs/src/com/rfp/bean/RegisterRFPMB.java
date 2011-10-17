package com.rfp.bean;

import java.util.Calendar;

import com.rfp.to.RequestTO;
//import com.rfp.wrapper.RFPWrapper;

public class RegisterRFPMB {
	
	private String name;
	private Calendar startDate;
	private Calendar decitionDate;
	private String company;
	private String filename;
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Calendar getStartDate() {
		return startDate;
	}

	public void setStartDate(Calendar startDate) {
		this.startDate = startDate;
	}

	public Calendar getDecitionDate() {
		return decitionDate;
	}

	public void setDecitionDate(Calendar decitionDate) {
		this.decitionDate = decitionDate;
	}

	public String getCompany() {
		return company;
	}

	public void setCompany(String company) {
		this.company = company;
	}

	public String getFilename() {
		return filename;
	}

	public void setFilename(String filename) {
		this.filename = filename;
	}

	public String registerRFP()
	{
		RequestTO request = new RequestTO();
		request.setName(name);
		request.setStartDate(startDate);
		request.setDecitionDate(decitionDate);
		request.setCompany(company);
		request.setFilename(filename);
		
		String result = "failure";
		//RFPWrapper wrapper = new RFPWrapper();
		//wrapper.registerRFP(request);
		if (request.getRequestId() != -1)
		{
			result = "success";
		}
		return result;
	}
}