package com.rfp.service;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import com.rfp.to.UserTO;

public class RFPSectionRoleService 
{
	public ArrayList<String[]> getSectionRoles(UserTO userTO)
	{
		ArrayList<String[]> result = new ArrayList<String[]>();
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("RFPs");
		EntityManager em = null;
		try
		{
			em = emf.createEntityManager();
			Query query = em.createQuery("Select rfps.rfpId, rfps.sectionId from SectionRole sr, RFPSection rfps, Section s, RFP rfp where" +
					" sr.sectionRoleId.username = :username and sr.sectionRoleId.rfpSectionId = rfps.rfpSectionId and" +
					" s.sectionId = rfps.sectionId and rfp.rfpId = rfps.rfpId");
			query.setParameter("username", userTO.getUsername());
			List<Object[]> rs = query.getResultList();			
			for (Object[] r : rs)
			{				
				String [] obj = new String [2];
				obj[0] = r[0].toString();
				obj[1] = r[1].toString();
				result.add(obj);
			}
		}
		finally
		{
			if (em != null)
			{
				em.close();
			}
		}
					
		return result;
	}
}
