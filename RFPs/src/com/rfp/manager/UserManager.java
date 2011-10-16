package com.rfp.manager;

import com.rfp.service.UserService;
import com.rfp.to.UserTO;

public class UserManager 
{
	public boolean login(UserTO user) 
	{
		UserService service = new UserService();
		return service.login(user);
	}
}