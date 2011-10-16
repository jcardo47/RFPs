package com.rfp.wrapper;

import com.rfp.manager.UserManager;
import com.rfp.to.UserTO;

public class RFPWrapper
{
	public boolean login(UserTO user) 
	{
		UserManager manager = new UserManager(); 
		return manager.login(user);
	}
}
