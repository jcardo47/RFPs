package com.rfp.wrapper;

import com.rfp.exception.UserRegisterException;
import com.rfp.manager.RequestManager;
import com.rfp.manager.UserManager;
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
		RequestManager manager = new RequestManager();
		manager.registerRFP(request);
	}
	
	public UserTO registerUser(UserTO userTO) throws UserRegisterException
	{
		UserManager manager = new UserManager(); 
		return manager.registerUser(userTO);
	}
	
}
