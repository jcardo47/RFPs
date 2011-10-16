package com.rfp.entity;

import com.rfp.entity.Section;
import java.io.Serializable;
import javax.persistence.*;

/**
 * Entity implementation class for Entity: RequestSection
 *
 */
@Entity
@Table(name="request_section")
public class RequestSection implements Serializable {

	   
	@Id
	@Column(name = "request_section_id")
	private long requestSectionId;
	
	public long getRequestId() {
		return requestId;
	}

	public void setRequestId(long requestId) {
		this.requestId = requestId;
	}

	public long getSectionId() {
		return sectionId;
	}

	public void setSectionId(long sectionId) {
		this.sectionId = sectionId;
	}

	@Column(name = "request_id")
	private long requestId;
	
	@Column(name = "section_id") 
	private long sectionId;

	private double average;

	public long getRequestSectionId() {
		return this.requestSectionId;
	}

	public void setRequestSectionId(long requestSectionId) {
		this.requestSectionId = requestSectionId;
	}
	public double getAverage() {
		return this.average;
	}

	public void setAverage(double average) {
		this.average = average;
	}
}
