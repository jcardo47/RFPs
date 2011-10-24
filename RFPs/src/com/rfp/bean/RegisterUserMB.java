package com.rfp.bean;

import javax.faces.context.FacesContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import com.rfp.to.UserTO;
import com.rfp.wrapper.RFPWrapper;


public class RegisterUserMB 
{
	private String username;
	private String firstName;
	private String lastName;
	private String password;
	private String password2;
	private String email;
	private String message;
	private String email2;
	private String butLabel = "Registrar";
	private Boolean renderPass = true;
	
	public RegisterUserMB ()
	{
		isLogged ();
	}
	
	private void isLogged ()
	{
		FacesContext context = FacesContext.getCurrentInstance();
		HttpServletRequest request = (HttpServletRequest)context.getExternalContext().getRequest();  
		HttpSession session = request.getSession();		
		UserTO userTo = (UserTO) session.getAttribute("username");
		if (userTo != null)
		{
			butLabel = "Guardar";
			renderPass = false;
			fillTexts(userTo);
			
		}
	}
	
	public void fillTexts (UserTO userTO)
	{
		email = userTO.getEmail();
		firstName = userTO.getFirstName();
		lastName = userTO.getLastName();
		username = userTO.getUsername();
		email2 = email;
	}
	
	public 	String processRequest ()
	{
		
		if(renderPass)
		{
			return updateUser();
		}
		else
		{
			return registerUser();
		}
			
	}
	
	public String updateUser ()
	{
		RFPWrapper wrapper = new RFPWrapper();
		String returnValue = "failure";	
		if (isEmialValid())
		{
			
		}
		else
		{
			message = "Los correos no coinciden";
		}
		return returnValue;		
	}
	
	public String registerUser ()
	{
		RFPWrapper wrapper = new RFPWrapper();
		String returnValue = "failure";		
		if (isPassValid())
		{
			if (isEmialValid())
			{
				try 
				{
					UserTO userTO = new UserTO();	
					userTO = getAsUserTO ();
					userTO = wrapper.registerUser(userTO);
					returnValue = "success";
					LoginMB.saveUserSession(userTO);
				} 
				catch (Exception e) 
				{
					message = e.getMessage();
				}
			}
			else
			{
				message = "Los correos no coinciden";
			}
		}
		else
		{
			message = "Las contraseñan no coinciden";
		}		
		return returnValue;
	}
	
	public boolean isEmialValid()
	{
		return email.equals(email2);
	}	
	public boolean isPassValid()
	{
		return password.equals(password2);
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

	public String getPassword2() {
		return password2;
	}

	public void setPassword2(String password2) {
		this.password2 = password2;
	}

	public String getEmail2() {
		return email2;
	}

	public void setEmail2(String email2) {
		this.email2 = email2;
	}

	public String getButLabel() {
		return butLabel;
	}

	public void setButLabel(String butLabel) {
		this.butLabel = butLabel;
	}

	public boolean isRenderPass() {
		return renderPass;
	}

	public void setRenderPass(boolean renderPass) {
		this.renderPass = renderPass;
	}
	
}
