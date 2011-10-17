package com.rfp.entity;

import java.io.Serializable;
import java.lang.String;
import java.util.Calendar;
import javax.persistence.*;

/**
 * Entity implementation class for Entity: Request
 *
 */
@Entity
@Table(name="rfp")
public class RFP implements Serializable {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name = "rfp_id")
	private long rfpId;

	private String name;

	@Column(name = "start_date")
	@Temporal(TemporalType.DATE)
	private Calendar startDate;

	@Column(name = "decition_date")
	@Temporal(TemporalType.DATE)
	private Calendar decitionDate;

	private String company;
	private String comment;

	@Column(name = "file_name")
	private String filename;

	@Column(name = "response_time")
	private long responseTime;

	@ManyToOne(cascade = CascadeType.MERGE)
	@JoinColumn(name = "status")
	private RFPStatus status;

	private double average;
 
	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}   
	public Calendar getStartDate() {
		return this.startDate;
	}

	public void setStartDate(Calendar startDate) {
		this.startDate = startDate;
	}   
	public Calendar getDecitionDate() {
		return this.decitionDate;
	}

	public void setDecitionDate(Calendar decitionDate) {
		this.decitionDate = decitionDate;
	}   
	public String getCompany() {
		return this.company;
	}

	public void setCompany(String company) {
		this.company = company;
	}   
	public String getComment() {
		return this.comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}   
	public String getFilename() {
		return this.filename;
	}

	public void setFilename(String filename) {
		this.filename = filename;
	}   
	public long getResponseTime() {
		return this.responseTime;
	}

	public void setResponseTime(long responseTime) {
		this.responseTime = responseTime;
	} 
	public double getAverage() {
		return this.average;
	}

	public void setAverage(double average) {
		this.average = average;
	}

	public long getRfpId() {
		return rfpId;
	}

	public void setRfpId(long rfpId) {
		this.rfpId = rfpId;
	}

	public RFPStatus getStatus() {
		return status;
	}

	public void setStatus(RFPStatus status) {
		this.status = status;
	}
}