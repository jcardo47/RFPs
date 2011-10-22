package com.rfp.manager;

import java.util.List;

import com.rfp.service.RFPService;
import com.rfp.to.RFPTO;

public class RFPManager {
	public void registerRFP(RFPTO requestTO)
	{
		RFPService service = new RFPService();
		service.registerRFP(requestTO);
	}
	
	public List<RFPTO> getAllRFPs()
	{
		RFPService service = new RFPService();
		return service.getAllRFPs();
	}
	
	public List<RFPTO> searchRFPs(String name, String company, int statusId)
	{
		RFPService service = new RFPService();
		return service.searchRFPs(name, company, statusId);
	}
	
	public RFPTO getRFP(long rfpId)
	{
		RFPService service = new RFPService();
		return service.getRFP(rfpId);
	}
	
	public boolean editRFP(RFPTO to)
	{
		RFPService service = new RFPService();
		return service.editRFP(to);
	}
}