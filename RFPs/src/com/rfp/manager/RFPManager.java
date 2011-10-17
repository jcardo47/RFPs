package com.rfp.manager;

import com.rfp.service.RFPService;
import com.rfp.to.RequestTO;

public class RFPManager {
	public void registerRFP(RequestTO requestTO)
	{
		RFPService service = new RFPService();
		service.registerRFP(requestTO);
	}
}
