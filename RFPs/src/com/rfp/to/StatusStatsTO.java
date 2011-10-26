package com.rfp.to;

public class StatusStatsTO {
	
	private RFPStatusTO status;
	private long quantity;
	private double average;

	public RFPStatusTO getStatus() {
		return status;
	}
	public void setStatus(RFPStatusTO status) {
		this.status = status;
	}
	public long getQuantity() {
		return quantity;
	}
	public void setQuantity(long quantity) {
		this.quantity = quantity;
	}
	public double getAverage() {
		return average;
	}
	public void setAverage(double average) {
		this.average = average;
	}
}