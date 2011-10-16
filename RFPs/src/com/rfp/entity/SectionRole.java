package com.rfp.entity;

import java.io.Serializable;
import java.lang.String;
import javax.persistence.*;

/**
 * Entity implementation class for Entity: SectionRole
 *
 */
@Entity
@Table(name="section_role")
public class SectionRole implements Serializable {

	@EmbeddedId
	private SectionRolePK sectionRoleId;
	private String comment;
	private double average;
	private long status;
	private static final long serialVersionUID = 1L;

	public SectionRole() {
		super();
	}   
	public String getComment() {
		return this.comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}   
	public double getAverage() {
		return this.average;
	}

	public void setAverage(double average) {
		this.average = average;
	}   
	public long getStatus() {
		return this.status;
	}

	public void setStatus(long status) {
		this.status = status;
	}
	public SectionRolePK getSectionRoleId() {
		return sectionRoleId;
	}
	public void setSectionRoleId(SectionRolePK sectionRoleId) {
		this.sectionRoleId = sectionRoleId;
	}
   
}
