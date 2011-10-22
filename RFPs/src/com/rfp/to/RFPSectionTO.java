package com.rfp.to;

public class RFPSectionTO {

	private long rfpSectionId;
	private long rfpId;
	private long sectionId;
	private double average;
	private String sectionName;
	
	public long getSectionId() {
		return sectionId;
	}
	
	public void setSectionId(long sectionId) {
		this.sectionId = sectionId;
	}
	
	public double getAverage() {
		return this.average;
	}
	
	public void setAverage(double average) {
		this.average = average;
	}
	
	public long getRfpSectionId() {
		return rfpSectionId;
	}
	
	public void setRfpSectionId(long rfpSectionId) {
		this.rfpSectionId = rfpSectionId;
	}

	public long getRfpId() {
		return rfpId;
	}

	public void setRfpId(long rfpId) {
		this.rfpId = rfpId;
	}

	public String getSectionName() {
		return sectionName;
	}

	public void setSectionName(String sectionName) {
		this.sectionName = sectionName;
	}
}