package com.rfp.bean;

import java.util.ArrayList;
import java.util.List;

import javax.faces.model.SelectItem;

import com.rfp.to.RFPStatusTO;
import com.rfp.to.RFPTO;
import com.rfp.wrapper.RFPWrapper;

public class RFPSearchMB {

	private String name;
	private String company;
	private int statusId;
	private List<SelectItem> statusList;
	private List<RFPTO> rfps;
	
	public RFPSearchMB() 
	{
		setName("");
		setCompany("");
		statusList = new ArrayList<SelectItem>();
		RFPWrapper wrapper = new RFPWrapper();
		List<RFPStatusTO> list = wrapper.getAllStatus();
		for(RFPStatusTO to : list)
		{
			SelectItem item = new SelectItem(to.getStatusId(), to.getName());
			statusList.add(item);
		}
	}

	public List<SelectItem> getStatusList() {
		return statusList;
	}

	public void setStatusList(List<SelectItem> statusList) {
		this.statusList = statusList;
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

	public int getStatusId() {
		return statusId;
	}

	public void setStatusId(int statusId) {
		this.statusId = statusId;
	}

	public List<RFPTO> getRfps() {
		return rfps;
	}

	public void setRfps(List<RFPTO> rfps) {
		this.rfps = rfps;
	}
	
	public String showAllRFPs()
	{
		RFPWrapper wrapper = new RFPWrapper();
		rfps = wrapper.getAllRFPs();
		return "success";
	}
	
	public String searchRFP()
	{
		RFPWrapper wrapper = new RFPWrapper();
		rfps = wrapper.searchRFPs(name, company, statusId);
		return "success";
	}
}