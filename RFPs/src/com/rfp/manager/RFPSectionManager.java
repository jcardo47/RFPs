package com.rfp.manager;

import java.util.List;

import com.rfp.service.RFPSectionService;
import com.rfp.to.RFPSectionTO;

public class RFPSectionManager {

	public List<RFPSectionTO> getRFPSections(long rfpId)
	{
		RFPSectionService service = new RFPSectionService();
		return service.getRFPSections(rfpId);
	}

	public boolean addRFPSection(RFPSectionTO to)
	{
		RFPSectionService service = new RFPSectionService();
		return service.addRFPSection(to);
	}
	
	public RFPSectionTO getRFPSection(long id)
	{
		RFPSectionService service = new RFPSectionService();
		return service.getRFPSection(id);
	}
	
	public boolean rateRFPSection(RFPSectionTO to)
	{
		RFPSectionService service = new RFPSectionService();
		return service.rateRFPSection(to);
	}
	
	public double getAvgRFPSections(long rfpId)
	{
		RFPSectionService service = new RFPSectionService();
		return service.getAvgRFPSections(rfpId);
	}
}