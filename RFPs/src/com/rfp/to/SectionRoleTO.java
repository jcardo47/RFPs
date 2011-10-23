package com.rfp.to;

import com.rfp.entity.SectionRolePK;

public class SectionRoleTO {

	private String username;
	private long rfpSectionId;
	private SectionRolePK sectionRoleId;
	private String comment;
	private double average;
	private long status;
  
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public long getRfpSectionId() {
		return rfpSectionId;
	}
	public void setRfpSectionId(long rfpSectionId) {
		this.rfpSectionId = rfpSectionId;
	}
	public String getComment() {
		return this.comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}   
	public double getAverage() {
		return this.average;
	}

	public void setAverage(double average) {
		this.average = average;
	}   
	public long getStatus() {
		return this.status;
	}

	public void setStatus(long status) {
		this.status = status;
	}
	public SectionRolePK getSectionRoleId() {
		return sectionRoleId;
	}
	public void setSectionRoleId(SectionRolePK sectionRoleId) {
		this.sectionRoleId = sectionRoleId;
	}
}