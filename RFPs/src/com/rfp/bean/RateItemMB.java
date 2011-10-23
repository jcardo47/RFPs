package com.rfp.bean;

import javax.faces.context.FacesContext;
import javax.servlet.http.HttpServletRequest;

import com.rfp.to.ItemTO;
import com.rfp.to.RFPTO;
import com.rfp.wrapper.RFPWrapper;

public class RateItemMB {

	private String rfpName;
	private String company;
	private String sectionName;
	private long itemId;
	private String itemName;
	private double value;
	
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
	public String getSectionName() {
		return sectionName;
	}
	public void setSectionName(String sectionName) {
		this.sectionName = sectionName;
	}
	public double getValue() {
		return value;
	}
	public void setValue(double value) {
		this.value = value;
	}

	public void updateMB()
	{
		HttpServletRequest request = (HttpServletRequest)FacesContext.getCurrentInstance().getExternalContext().getRequest();
		String strRfpId = request.getParameter("rfpId");
		String strRfpSectionId = request.getParameter("rfpSectionId");
		String strItemId = request.getParameter("itemId");
		if (strRfpId != null && !strRfpId.equals("") && strRfpSectionId != null
				&& !strRfpSectionId.equals("") && strItemId != null && !strItemId.equals(""))
		{
			long rfpId = Long.parseLong(strRfpId);
			long rfpSectionId = Long.parseLong(strRfpSectionId);
			itemId = Long.parseLong(strItemId);
			RFPWrapper wrapper = new RFPWrapper();
			RFPTO rfp = wrapper.getRFP(rfpId);
			ItemTO item = wrapper.getItem(itemId);
			rfpName = rfp.getName();
			company = rfp.getCompany();
			itemName = item.getName();
			value = item.getValue();
			setSectionName(wrapper.getRFPSection(rfpSectionId).getSectionName());
		}
	}

	public String rateItem()
	{
		ItemTO to = new ItemTO();
		to.setItemId(itemId);
		to.setValue(value);
		if (new RFPWrapper().rateItem(to))
		{
			return "success";
		}
		else
		{
			return "failure";
		}
	}
}