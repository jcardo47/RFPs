package com.rfp.bean;

import java.util.ArrayList;
import java.util.List;

import javax.faces.context.FacesContext;
import javax.faces.model.SelectItem;
import javax.servlet.http.HttpServletRequest;

import com.rfp.to.RFPSectionTO;
import com.rfp.to.RFPTO;
import com.rfp.to.SectionTO;
import com.rfp.wrapper.RFPWrapper;

public class AdminRFPSectionsMB {
	
	private RFPTO rfp;
	private List<RFPSectionTO> rfpSections;
	private List<SelectItem> sectionList;
	private int sectionId;
	private String message;	
	
	public RFPTO getRfp() {
		return rfp;
	}

	public void setRfp(RFPTO rfp) {
		this.rfp = rfp;
	}

	public List<SelectItem> getSectionList() {
		return sectionList;
	}

	public void setSectionList(List<SelectItem> sectionList) {
		this.sectionList = sectionList;
	}

	public int getSectionId() {
		return sectionId;
	}

	public void setSectionId(int sectionId) {
		this.sectionId = sectionId;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
	
	public void updateMB()
	{
		HttpServletRequest request = (HttpServletRequest)FacesContext.getCurrentInstance().getExternalContext().getRequest();
		RFPWrapper wrapper = new RFPWrapper();
		String value = request.getParameter("id");
		long id = -1;
		if (value != null && !value.equals(""))
		{
			id = Long.parseLong(value);
		}
		else if (rfp != null)
		{
			id = rfp.getRequestId();
		}
		else
		{
			rfpSections = new ArrayList<RFPSectionTO>();
		}
		if (id != -1)
		{
			setRfp(wrapper.getRFP(id));
			rfpSections = wrapper.getRFPSections(id);
		}
		sectionList = new ArrayList<SelectItem>();
		List<SectionTO> list = wrapper.getAllSections();
		for(SectionTO to : list)
		{
			if (!belongsToRFP(to.getSectionId()))
			{
				SelectItem item = new SelectItem(to.getSectionId(), to.getName());
				sectionList.add(item);
			}
		}
	}
	
	public boolean belongsToRFP(long sectionId)
	{
		boolean x = false;
		for (int i = 0; !x && i < rfpSections.size(); i++)
		{
			if (rfpSections.get(i).getSectionId() == sectionId)
			{
				x = true;
			}
		}
		return x;
	}
	
	public String addSection()
	{
		if (sectionId != -1)
		{
			RFPSectionTO to = new RFPSectionTO();
			to.setRfpId(rfp.getRequestId());
			to.setSectionId(sectionId);
			RFPWrapper wrapper = new RFPWrapper();
			if (wrapper.addRFPSection(to))
			{
				updateMB();
				return "success";
			}
			else
			{
				return "failure";
			}
		}
		else
		{
			return "failure";
		}
	}

	public List<RFPSectionTO> getRfpSections() {
		return rfpSections;
	}

	public void setRfpSections(List<RFPSectionTO> rfpSections) {
		this.rfpSections = rfpSections;
	}
}
