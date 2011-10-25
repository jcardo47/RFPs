package com.rfp.bean;

import javax.faces.context.FacesContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import com.rfp.to.UserTO;
import com.rfp.wrapper.RFPWrapper;

public class LoginMB {

	private String username;
	private String password;
	private String message;
	
	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
	public String login() {
		RFPWrapper wrapper = new RFPWrapper();
		UserTO user = new UserTO();
		user.setUsername(username);
		user.setPassword(password);
		String result = "failure";
		UserTO userTO;
		try 
		{
			userTO = wrapper.login(user);
			if (userTO.isAdmin())
			{
				result = "successAdmin";
			}
			else
			{
				result = "success";
			}		
			
			saveUserSession(userTO);
		}		
		catch (Exception e) 
		{
			message = e.getMessage();			
			result = "faild";		
		}
		
		return result;
	}
	
	public static void saveUserSession (UserTO userTO)
	{
		FacesContext context = FacesContext.getCurrentInstance();
		HttpServletRequest request = (HttpServletRequest)context.getExternalContext().getRequest();  
		HttpSession session = request.getSession();		
		session.setAttribute("username", userTO);		
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
}