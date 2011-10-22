package com.rfp.bean;

import java.util.ArrayList;
import java.util.List;

import javax.faces.context.FacesContext;
import javax.faces.model.SelectItem;
import javax.servlet.http.HttpServletRequest;

import com.rfp.to.RFPStatusTO;
import com.rfp.to.RFPTO;
import com.rfp.wrapper.RFPWrapper;

public class ViewRFPMB {
	
	private RFPTO rfp;
	private List<SelectItem> statusList;
	private int statusId;
	private String message;
	
	public void updateMB()
	{
		HttpServletRequest request = (HttpServletRequest)FacesContext.getCurrentInstance().getExternalContext().getRequest();
		String value = request.getParameter("id");
		if (value != null && !value.equals(""))
		{
			long id = Long.parseLong(value);
			RFPWrapper wrapper = new RFPWrapper();
			setRfp(wrapper.getRFP(id));
			if (rfp.getStatus() != null)
			{
				statusId = rfp.getStatus().getStatusId();
			}
			statusList = new ArrayList<SelectItem>();
			List<RFPStatusTO> list = wrapper.getAllStatus();
			for(RFPStatusTO to : list)
			{
				SelectItem item = new SelectItem(to.getStatusId(), to.getName());
				statusList.add(item);
			}
		}
	}

	public RFPTO getRfp() {
		return rfp;
	}

	public void setRfp(RFPTO rfp) {
		this.rfp = rfp;
	}

	public List<SelectItem> getStatusList() {
		return statusList;
	}

	public void setStatusList(List<SelectItem> statusList) {
		this.statusList = statusList;
	}

	public int getStatusId() {
		return statusId;
	}

	public void setStatusId(int statusId) {
		this.statusId = statusId;
	}
	
	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
	
	public String editRFP()
	{
		RFPWrapper wrapper = new RFPWrapper(); 
		if (statusId != -1)
		{
			RFPStatusTO status = wrapper.getRFPStatus(statusId);
			rfp.setStatus(status);
		}
		else
		{
			rfp.setStatus(null);
		}
		if (wrapper.editRFP(rfp))
		{
			setRfp(new RFPWrapper().getRFP(rfp.getRequestId()));
			return "success";
		}
		else
		{
			return "failure";
		}
	}
}