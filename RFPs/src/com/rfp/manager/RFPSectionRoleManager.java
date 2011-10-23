package com.rfp.manager;

import java.util.ArrayList;

import com.rfp.service.RFPSectionRoleService;
import com.rfp.to.RFPSectionTO;
import com.rfp.to.UserTO;

public class RFPSectionRoleManager 
{
	public ArrayList <Object []> getListSectionRolesByUser (UserTO userTO)
	{
		RFPSectionRoleService service = new RFPSectionRoleService();
		ArrayList<RFPSectionTO> rfpSectionTOs = service.getSectionRoles(userTO);
		ArrayList<Object[]> objects = new ArrayList<Object[]>();
		RFPManager manager = new RFPManager();		
		for (RFPSectionTO rfps : rfpSectionTOs)
		{
			Object [] items = new Object[2];
			items[1] = rfps;			
			items[0] = manager.getRFP(rfps.getRfpId());		
			objects.add(items);
		}
		return objects; 
	}
}
