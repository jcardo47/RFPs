package com.rfp.manager;

import com.rfp.service.RequestService;
import com.rfp.to.RequestTO;

public class RequestManager {
	public void registerRFP(RequestTO requestTO)
	{
		RequestService service = new RequestService();
		service.registerRFP(requestTO);
	}
}
