package com.rfp.manager;

import java.util.List;

import com.rfp.exception.InvalidPassword;
import com.rfp.exception.InvalidUseName;
import com.rfp.exception.UserRegisterException;
import com.rfp.service.UserService;
import com.rfp.to.UserTO;

public class UserManager 
{
	public UserTO login(UserTO user) throws InvalidUseName, InvalidPassword 
	{
		UserService service = new UserService();
		UserTO newUserTO = service.getUserByUserName(user);
		if (newUserTO  == null)
		{
			throw new InvalidUseName();
		}
		else if (!newUserTO.getPassword().equals(user.getPassword()))
		{
			throw new InvalidPassword();
		}
		else
		{
			return newUserTO;
		}
			
		
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
	
	public List<UserTO> getUsers()
	{
		UserService service = new UserService();
		return service.getUsers();
	}
}