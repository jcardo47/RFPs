package com.rfp.bean;

import javax.faces.context.FacesContext;
import javax.servlet.http.HttpServletRequest;

import com.rfp.to.RFPSectionTO;
import com.rfp.to.RFPTO;
import com.rfp.wrapper.RFPWrapper;

public class RateSectionMB {
	
	private long rfpSectionId;
	private String rfpName;
	private String company;
	private String sectionName;
	private double avgItems;
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
	public double getAvgItems() {
		return avgItems;
	}
	public void setAvgItems(double avgItems) {
		this.avgItems = avgItems;
	}

	public void updateMB()
	{
		HttpServletRequest request = (HttpServletRequest)FacesContext.getCurrentInstance().getExternalContext().getRequest();
		String strRfpId = request.getParameter("rfpId");
		String strRfpSectionId = request.getParameter("rfpSectionId");
		if (strRfpId != null && !strRfpId.equals("") && strRfpSectionId != null
				&& !strRfpSectionId.equals(""))
		{
			long rfpId = Long.parseLong(strRfpId);
			rfpSectionId = Long.parseLong(strRfpSectionId);
			RFPWrapper wrapper = new RFPWrapper();
			RFPTO rfp = wrapper.getRFP(rfpId);
			RFPSectionTO section = wrapper.getRFPSection(rfpSectionId);

			rfpName = rfp.getName();
			company = rfp.getCompany();			
			sectionName = section.getSectionName();
			value = section.getAverage();
			avgItems = wrapper.getAvgItems(rfpSectionId);
			avgItems = (double)Math.round(avgItems * 100) / 100;

		}
	}

	public String rateSection()
	{
		RFPSectionTO to = new RFPSectionTO();
		to.setRfpSectionId(rfpSectionId);
		to.setAverage(value);
		if (new RFPWrapper().rateRFPSection(to))
		{
			return "success";
		}
		else
		{
			return "failure";
		}
	}
}