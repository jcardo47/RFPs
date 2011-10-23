package com.rfp.to;

public class ItemTO {

	private long itemId;
	private long requestSectionId;
	private String name;
	private double value;

	public long getRequestSectionId() {
		return requestSectionId;
	}

	public void setRequestSectionId(long requestSectionId) {
		this.requestSectionId = requestSectionId;
	}
  
	public long getItemId() {
		return this.itemId;
	}

	public void setItemId(long itemId) {
		this.itemId = itemId;
	}   
	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}   
	public double getValue() {
		return this.value;
	}

	public void setValue(double value) {
		this.value = value;
	}
}