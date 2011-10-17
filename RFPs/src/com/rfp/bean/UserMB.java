package com.rfp.bean;

import com.rfp.to.UserTO;
//import com.rfp.wrapper.RFPWrapper;


public class UserMB 
{
	private String username;
	private String firstName;
	private String lastName;
	private String password;
	private String email;
	private String message;
	
	public String registerUser ()
	{
		//RFPWrapper wrapper = new RFPWrapper();
		String returnValue = "failure";
		try 
		{
			UserTO userTO = new UserTO();	
			userTO = getAsUserTO ();
			//userTO = wrapper.registerUser(userTO);
			returnValue = "success";
		} 
		catch (Exception e) 
		{
			message = e.getMessage();
		}
		return returnValue;
	}
	
	private UserTO getAsUserTO ()
	{
		UserTO userTO = new UserTO();
		userTO.setEmail(email);
		userTO.setFirstName(firstName);
		userTO.setLastName(lastName);
		userTO.setPassword(password);
		userTO.setUsername(username);
		return userTO;
	}
	
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
	
}
