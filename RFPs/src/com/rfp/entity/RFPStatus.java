package com.rfp.entity;

import java.io.Serializable;
import java.lang.String;
import javax.persistence.*;

/**
 * Entity implementation class for Entity: RFPStatus
 *
 */
@Entity
@Table(name = "rfp_status")
public class RFPStatus implements Serializable {
 
	@Id
	@Column(name = "id_status")
	private int statusId;
	private String name;
  
	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getStatusId() {
		return statusId;
	}

	public void setStatusId(int statusId) {
		this.statusId = statusId;
	}
}