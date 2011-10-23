package com.rfp.manager;

import java.util.ArrayList;

import com.rfp.service.RFPSectionRoleService;
import com.rfp.to.UserTO;

public class RFPSectionRoleManager 
{
	public ArrayList <String []> getListSectionRolesByUser (UserTO userTO)
	{
		RFPSectionRoleService service = new RFPSectionRoleService();		
		return service.getSectionRoles(userTO); 
	}
}
