package com.rfp.manager;

import java.util.List;

import com.rfp.service.RFPStatusService;
import com.rfp.to.RFPStatusTO;

public class RFPStatusManager {
	
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