package com.rfp.manager;

import com.rfp.exception.UserRegisterException;
import com.rfp.service.UserService;
import com.rfp.to.UserTO;

public class UserManager 
{
	public boolean login(UserTO user) 
	{
		UserService service = new UserService();
		return service.login(user);
	}
	
	public UserTO registerUser(UserTO userTO) throws UserRegisterException
	{
		UserService service = new UserService();
		if (service.userNameExist(userTO))
		{
			throw new UserRegisterException();
		}
		else
		{
			return service.registerUser(userTO);
		}
		
	}
}