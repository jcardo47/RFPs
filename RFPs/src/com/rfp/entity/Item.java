package com.rfp.entity;

import java.io.Serializable;
import java.lang.String;
import javax.persistence.*;

/**
 * Entity implementation class for Entity: Item
 *
 */
@Entity
@Table(name="section_item")
public class Item implements Serializable {

	   
	@Id
	@Column(name = "section_item_id")
	private long itemId;
	@Column(name = "request_section_id")
	private long requestSectionId;

	public long getRequestSectionId() {
		return requestSectionId;
	}

	public void setRequestSectionId(long requestSectionId) {
		this.requestSectionId = requestSectionId;
	}

	private String name;
	private double value;
  
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