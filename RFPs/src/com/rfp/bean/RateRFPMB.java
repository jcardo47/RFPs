package com.rfp.bean;

import javax.faces.context.FacesContext;
import javax.servlet.http.HttpServletRequest;

import com.rfp.to.RFPTO;
import com.rfp.wrapper.RFPWrapper;

public class RateRFPMB 
{
	private long rfpId;
	private String rfpName;
	private String company;
	private double avgSections;
	private double average;
	
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

	public long getRfpId() {
		return rfpId;
	}
	public void setRfpId(long rfpId) {
		this.rfpId = rfpId;
	}
	public double getAvgSections() {
		return avgSections;
	}
	public void setAvgSections(double avgSections) {
		this.avgSections = avgSections;
	}
	public double getAverage() {
		return average;
	}
	public void setAverage(double average) {
		this.average = average;
	}
	public void updateMB()
	{
		HttpServletRequest request = (HttpServletRequest)FacesContext.getCurrentInstance().getExternalContext().getRequest();
		String strRfpId = request.getParameter("rfpId");
		if (strRfpId != null && !strRfpId.equals(""))
		{
			rfpId = Long.parseLong(strRfpId);
			RFPWrapper wrapper = new RFPWrapper();
			RFPTO rfp = wrapper.getRFP(rfpId);

			rfpName = rfp.getName();
			company = rfp.getCompany();
			avgSections = wrapper.getAvgRFPSections(rfpId);
			avgSections = (double)Math.round(avgSections * 100) / 100;
			average = rfp.getAverage();
		}
	}

	public String rateRFPn()
	{
		if (new RFPWrapper().rateRFP(rfpId, average))
		{
			return "success";
		}
		else
		{
			return "failure";
		}
	}
}
