package com.rfp.manager;

import java.util.List;

import com.rfp.exception.RFPStatusAlreadySaved;
import com.rfp.service.RFPStatusService;
import com.rfp.to.RFPStatusTO;

public class RFPStatusManager {
	
	public RFPStatusTO registerStatus (RFPStatusTO rfpStatusTO) throws RFPStatusAlreadySaved
	{
		RFPStatusService service = new RFPStatusService();
		if (!service.statusExists(rfpStatusTO))
		{
			return service.registerSection(rfpStatusTO);
		}
		else
		{
			throw new RFPStatusAlreadySaved();
		}
	}
	
	public List<RFPStatusTO> getAllStatus()
	{
		RFPStatusService service = new RFPStatusService();
		return service.getAllStatus();
	}
	
	public RFPStatusTO getStatus(int id)
	{
		RFPStatusService service = new RFPStatusService();
		return service.getStatus(id);	
	}
}