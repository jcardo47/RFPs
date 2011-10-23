package com.rfp.wrapper;

import java.util.ArrayList;
import java.util.List;
import com.rfp.exception.InvalidPassword;
import com.rfp.exception.InvalidUseName;
import com.rfp.exception.RFPStatusAlreadySaved;
import com.rfp.exception.SectionAlreadySaved;
import com.rfp.exception.UserRegisterException;
import com.rfp.manager.ItemManager;
import com.rfp.manager.RFPManager;
import com.rfp.manager.RFPSectionManager;
import com.rfp.manager.RFPSectionRoleManager;
import com.rfp.manager.RFPStatusManager;
import com.rfp.manager.SectionManager;
import com.rfp.manager.SectionRoleManager;
import com.rfp.manager.UserManager;
import com.rfp.to.ItemTO;
import com.rfp.to.RFPSectionTO;
import com.rfp.to.RFPStatusTO;
import com.rfp.to.RFPTO;
import com.rfp.to.SectionRoleTO;
import com.rfp.to.SectionTO;
import com.rfp.to.UserTO;

public class RFPWrapper
{
	public ArrayList<Object[]> getSectionRoles(UserTO userTO)
	{
		RFPSectionRoleManager manager = new RFPSectionRoleManager();
		return manager.getListSectionRolesByUser(userTO);
	}
	
	public UserTO login(UserTO user) throws InvalidUseName, InvalidPassword 
	{
		UserManager manager = new UserManager(); 
		return manager.login(user);
	}
	
	public void registerRFP(RFPTO request)
	{
		RFPManager manager = new RFPManager();
		manager.registerRFP(request);
	}
	
	public List<RFPStatusTO> getAllStatus()
	{
		RFPStatusManager manager = new RFPStatusManager();
		return manager.getAllStatus();
	}
	
	public UserTO registerUser(UserTO userTO) throws UserRegisterException
	{
		UserManager manager = new UserManager(); 
		return manager.registerUser(userTO);
	}

	public List<RFPTO> getAllRFPs()
	{
		RFPManager manager = new RFPManager();
		return manager.getAllRFPs();
	}
	
	public List<RFPTO> searchRFPs(String name, String company, int statusId)
	{
		RFPManager manager = new RFPManager();
		return manager.searchRFPs(name, company, statusId);
	}
	
	public RFPTO getRFP(long rfpId)
	{
		RFPManager manager = new RFPManager();
		return manager.getRFP(rfpId);
	}
	
	public RFPStatusTO getRFPStatus(int id)
	{
		RFPStatusManager manager = new RFPStatusManager();
		return manager.getStatus(id);
	}
	
	public boolean editRFP(RFPTO to)
	{
		RFPManager manager = new RFPManager();
		return manager.editRFP(to);
	}
	
	public List<SectionTO> getAllSections()
	{
		SectionManager manager = new SectionManager();
		return manager.getAllSections();
	}
	
	public List<RFPSectionTO> getRFPSections(long rfpId)
	{
		RFPSectionManager manager = new RFPSectionManager();
		return manager.getRFPSections(rfpId);
	}
	
	public SectionTO registerSection (SectionTO sectionTO) throws SectionAlreadySaved
	{
		SectionManager manager = new SectionManager();
		return manager.registerSection(sectionTO);
	}
	
	public RFPStatusTO registerRFPStatus (RFPStatusTO rfpStatusTO) throws RFPStatusAlreadySaved 
	{
		RFPStatusManager manager = new RFPStatusManager();
		return manager.registerStatus(rfpStatusTO);
	}
	
	public long addRFPSection(RFPSectionTO to)
	{
		RFPSectionManager manager = new RFPSectionManager();
		return manager.addRFPSection(to);
	}
	
	public boolean addItem(ItemTO to)
	{
		ItemManager manager = new ItemManager();
		return manager.addItem(to);
	}
	
	public RFPSectionTO getRFPSection(long id)
	{
		RFPSectionManager manager = new RFPSectionManager();
		return manager.getRFPSection(id);
	}

	public List<ItemTO> getSectionItems(long rfpSectionId)
	{
		ItemManager manager = new ItemManager();
		return manager.getSectionItems(rfpSectionId);
	}
	
	public ItemTO getItem(long id)
	{
		ItemManager manager = new ItemManager();
		return manager.getItem(id);
	}
	
	public boolean rateItem(ItemTO to)
	{
		ItemManager manager = new ItemManager();
		return manager.rateItem(to);
	}
	
	public double getAvgItems(long rfpSectionId)
	{
		ItemManager manager = new ItemManager();
		return manager.getAvgItems(rfpSectionId);
	}
	
	public boolean rateRFPSection(RFPSectionTO to)
	{
		RFPSectionManager manager = new RFPSectionManager();
		return manager.rateRFPSection(to);
	}
	
	public double getAvgRFPSections(long rfpId)
	{
		RFPSectionManager manager = new RFPSectionManager();
		return manager.getAvgRFPSections(rfpId);
	}
	
	public boolean rateRFP(long rfpId, double rate)
	{
		RFPManager manager = new RFPManager();
		return manager.rateRFP(rfpId, rate);
	}
	
	public List<UserTO> getUsers()
	{
		UserManager manager = new UserManager();
		return manager.getUsers();
	}
	
	public boolean createSectionRole(SectionRoleTO to, RFPTO rfp, RFPSectionTO rfpSection)
	{
		SectionRoleManager manager = new SectionRoleManager();
		return manager.createSectionRole(to, rfp, rfpSection);
	}
}
