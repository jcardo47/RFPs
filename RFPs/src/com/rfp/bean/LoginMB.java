package com.rfp.bean;

import com.rfp.to.UserTO;
//import com.rfp.wrapper.RFPWrapper;

public class LoginMB {

	private String username;
	private String password;

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
		System.out.println("Hola Mundo");
		//RFPWrapper wrapper = new RFPWrapper();
		UserTO user = new UserTO();
		user.setUsername(username);
		user.setPassword(password);
		String result = "failure";
		/*
		if (wrapper.login(user))
		{
			if (username.equals("admin"))
			{
				result = "successAdmin";
			}
			else
			{
				result = "success";
			}
		}
		*/
		return result;
	}
}