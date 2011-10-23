package com.rfp.entity;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class SectionRolePK 
{
	@Column(name = "user_name")
	private String username;
	@Column (name = "rfp_section_id")
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
