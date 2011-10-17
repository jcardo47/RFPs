package com.rfp.entity;

import java.io.Serializable;
import javax.persistence.*;

/**
 * Entity implementation class for Entity: RequestSection
 *
 */
@Entity
@Table(name="rfp_section")
public class RFPSection implements Serializable {

	   
	@Id
	@Column(name = "request_section_id")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long rfpSectionId;
	
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
}
