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

	@Column(name = "rfp_id")
	private long rfpId;

	@Column(name = "section_id")
	private long sectionId;
	
	private double average;
	
	public long getRfpId() {
		return rfpId;
	}
	
	public void setRfpId(long rfpId) {
		this.rfpId = rfpId;
	}
	
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
}