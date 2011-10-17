package com.rfp.wrapper;

import java.util.List;

import com.rfp.manager.RFPManager;
import com.rfp.manager.RFPStatusManager;
import com.rfp.manager.UserManager;
import com.rfp.to.RFPStatusTO;
import com.rfp.to.RequestTO;
import com.rfp.to.UserTO;

public class RFPWrapper
{
	public boolean login(UserTO user) 
	{
		UserManager manager = new UserManager(); 
		return manager.login(user);
	}
	
	public void registerRFP(RequestTO request)
	{
		RFPManager manager = new RFPManager();
		manager.registerRFP(request);
	}
	
	public List<RFPStatusTO> getAllStatus()
	{
		RFPStatusManager manager = new RFPStatusManager();
		return manager.getAllStatus();
	}
}
