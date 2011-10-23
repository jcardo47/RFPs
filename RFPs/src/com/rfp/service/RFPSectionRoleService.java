package com.rfp.service;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import com.rfp.entity.RFPSection;
import com.rfp.to.RFPSectionTO;
import com.rfp.to.UserTO;

public class RFPSectionRoleService 
{
	public ArrayList<RFPSectionTO> getSectionRoles(UserTO userTO)
	{
		
		ArrayList<RFPSectionTO> result = new ArrayList<RFPSectionTO>();
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("RFPs");
		EntityManager em = null;
		try
		{
			em = emf.createEntityManager();
			Query query = em.createQuery("Select rfps from SectionRole sr, RFPSection rfps, Section s, RFP rfp where" +
					" sr.sectionRoleId.username = :username and sr.sectionRoleId.rfpSectionId = rfps.rfpSectionId and" +
					" s.sectionId = rfps.sectionId and rfp.rfpId = rfps.rfpId");
			query.setParameter("username", userTO.getUsername());
			List <RFPSection> rs = query.getResultList();
			RFPSectionService service = new RFPSectionService();
			for (RFPSection rfps : rs)
			{
				result.add(service.getRFPSection(rfps.getRfpSectionId()));
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
