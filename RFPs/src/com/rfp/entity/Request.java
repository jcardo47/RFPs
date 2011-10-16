package com.rfp.entity;

import java.io.Serializable;
import java.lang.String;
import java.util.List;
import java.util.Calendar;
import javax.persistence.*;

/**
 * Entity implementation class for Entity: Request
 *
 */
@Entity
@Table(name="request")
public class Request implements Serializable {

	@Id
	@Column(name = "request_id")
	private long requestId;

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
	
	private long status;

	private double average;

	public long getRequestId() {
		return this.requestId;
	}

	public void setRequestId(long requestId) {
		this.requestId = requestId;
	}   
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
	public long getStatus() {
		return this.status;
	}

	public void setStatus(long status) {
		this.status = status;
	}   
	public double getAverage() {
		return this.average;
	}

	public void setAverage(double average) {
		this.average = average;
	}
}