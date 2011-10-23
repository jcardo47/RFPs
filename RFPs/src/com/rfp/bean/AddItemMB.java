package com.rfp.bean;

import java.util.List;

import javax.faces.context.FacesContext;
import javax.servlet.http.HttpServletRequest;

import com.rfp.to.ItemTO;
import com.rfp.to.RFPTO;
import com.rfp.wrapper.RFPWrapper;

public class AddItemMB {
	
	private long rfpId;
	private long rfpSectionId;
	private String rfpName;
	private String company;
	private String sectionName;
	private String itemName;
	private List<ItemTO> items;
	
	public AddItemMB()
	{
		rfpId = -1;
		rfpSectionId = -1;
	}
	
	public String getRfpName() {
		return rfpName;
	}
	public void setRfpName(String rfpName) {
		this.rfpName = rfpName;
	}
	public String getCompany() {
		return company;
	}
	public void setCompany(String company) {
		this.company = company;
	}
	public String getItemName() {
		return itemName;
	}
	public void setItemName(String itemName) {
		this.itemName = itemName;
	}
	public List<ItemTO> getItems() {
		return items;
	}
	public void setItems(List<ItemTO> items) {
		this.items = items;
	}
	public String getSectionName() {
		return sectionName;
	}
	public void setSectionName(String sectionName) {
		this.sectionName = sectionName;
	}

	public void updateMB()
	{
		HttpServletRequest request = (HttpServletRequest)FacesContext.getCurrentInstance().getExternalContext().getRequest();
		String strRfpId = request.getParameter("rfpId");
		String strRfpSectionId = request.getParameter("rfpSectionId");
		if (strRfpId != null && !strRfpSectionId.equals("") && strRfpSectionId != null
				&& !strRfpSectionId.equals(""))
		{
			rfpId = Long.parseLong(strRfpId);
			rfpSectionId = Long.parseLong(strRfpSectionId);
		}
		if (rfpId != -1 && rfpSectionId != -1)
		{
			RFPWrapper wrapper = new RFPWrapper();
			RFPTO rfp = wrapper.getRFP(rfpId);
			rfpName = rfp.getName();
			company = rfp.getCompany();
			setSectionName(wrapper.getRFPSection(rfpSectionId).getSectionName());
			items = wrapper.getSectionItems(rfpSectionId);
		}
	}

	public String addItem()
	{
		ItemTO to = new ItemTO();
		to.setRequestSectionId(rfpSectionId);
		to.setName(itemName);
		RFPWrapper wrapper = new RFPWrapper();
		if (wrapper.addItem(to))
		{
			updateMB();
			return "success";
		}
		else
		{
			return "failure";
		}
	}
}