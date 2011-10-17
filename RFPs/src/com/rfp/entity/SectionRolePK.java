package com.rfp.entity;

import javax.persistence.Embeddable;

@Embeddable
public class SectionRolePK 
{
	private String username;
	private long rfpSectionId;
	
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
}