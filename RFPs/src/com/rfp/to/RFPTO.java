package com.rfp.to;

import java.util.Calendar;

public class RFPTO {
	
	private long requestId;
	private String name;
	private Calendar startDate;
	private Calendar decitionDate;
	private String company;
	private String comment;
	private String filename;
	private long responseTime;
	private RFPStatusTO status;
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
	public RFPStatusTO getStatus() {
		return this.status;
	}

	public void setStatus(RFPStatusTO status) {
		this.status = status;
	}   
	public double getAverage() {
		return this.average;
	}

	public void setAverage(double average) {
		this.average = average;
	}
}