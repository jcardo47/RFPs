package com.rfp.entity;

import java.io.Serializable;
import java.lang.String;
import javax.persistence.*;

/**
 * Entity implementation class for Entity: Section
 *
 */
@Entity
@Table(name="section")

public class Section implements Serializable {

	   
	@Id
	@Column(name = "section_id")
	private long sectionId;

	private String name;
  
	public long getSectionId() {
		return this.sectionId;
	}

	public void setSectionId(long sectionId) {
		this.sectionId = sectionId;
	}   
	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}
}