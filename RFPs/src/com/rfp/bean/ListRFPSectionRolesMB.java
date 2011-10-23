package com.rfp.bean;

import java.util.ArrayList;

import javax.faces.context.FacesContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import com.rfp.to.UserTO;
import com.rfp.wrapper.RFPWrapper;

public class ListRFPSectionRolesMB 
{
	private ArrayList<String []> result = new ArrayList<String[]>();
	private String message;
	
	public ListRFPSectionRolesMB ()
	{
		RFPWrapper wrapper = new RFPWrapper();		
		UserTO userTO = getUserTO();
		if (userTO != null)
		{
			result = wrapper.getSectionRoles(userTO);
			if (result.size() == 0)
			{
				message = "No hay RFPs con secciones para calificar para usted " + userTO.getFirstName();
			}
		}	 
	}
	
	private UserTO getUserTO()
	{
		UserTO userTO = null;
		FacesContext context = FacesContext.getCurrentInstance();
		HttpServletRequest request = (HttpServletRequest)context.getExternalContext().getRequest();  
		HttpSession session = request.getSession();		
		userTO = (UserTO) session.getAttribute("username");	
		return userTO;
	}

	public ArrayList<String[]> getResult() {
		return result;
	}

	public void setResult(ArrayList<String[]> result) {
		this.result = result;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
}
