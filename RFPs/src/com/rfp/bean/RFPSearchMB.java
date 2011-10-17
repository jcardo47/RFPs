package com.rfp.bean;

import java.util.ArrayList;
import java.util.List;

import javax.faces.model.SelectItem;

import com.rfp.to.RFPStatusTO;
import com.rfp.wrapper.RFPWrapper;

public class RFPSearchMB {

	private String name;
	private String company;
	private List<SelectItem> status;
	
	public RFPSearchMB() 
	{
		setName("");
		setCompany("");
		status = new ArrayList<SelectItem>();
		RFPWrapper wrapper = new RFPWrapper();
		List<RFPStatusTO> list = wrapper.getAllStatus();
		for(RFPStatusTO to : list)
		{
			SelectItem item = new SelectItem(to.getStatusId(), to.getName());
			status.add(item);
		}
	}

	public List<SelectItem> getStatus() {
		return status;
	}

	public void setStatus(List<SelectItem> status) {
		this.status = status;
	}

	public String getCompany() {
		return company;
	}

	public void setCompany(String company) {
		this.company = company;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
}