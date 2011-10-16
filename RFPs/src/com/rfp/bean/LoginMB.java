package com.rfp.bean;

import com.rfp.to.UserTO;
import com.rfp.wrapper.RFPWrapper;

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
		RFPWrapper wrapper = new RFPWrapper();
		UserTO user = new UserTO();
		user.setUsername(username);
		user.setPassword(password);
		if (wrapper.login(user))
		{
			return "success";
		}
		else
		{
			return "failure";
		}
	}
}