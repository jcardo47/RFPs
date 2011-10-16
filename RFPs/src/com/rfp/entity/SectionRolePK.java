package com.rfp.entity;

import javax.persistence.Embeddable;

@Embeddable
public class SectionRolePK 
{
	private String username;
	private long requestSectionId;
	
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public long getRequestSectionId() {
		return requestSectionId;
	}
	public void setRequestSectionId(long requestSectionId) {
		this.requestSectionId = requestSectionId;
	}
}