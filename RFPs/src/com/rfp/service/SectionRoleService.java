package com.rfp.service;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import com.rfp.entity.SectionRole;
import com.rfp.entity.SectionRolePK;
import com.rfp.to.SectionRoleTO;

public class SectionRoleService {
	
	public boolean createSectionRole(SectionRoleTO to)
	{
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("RFPs");
		EntityManager em = null;
		try
		{
			em = emf.createEntityManager();

			SectionRole entity = new SectionRole();
			SectionRolePK pk = new SectionRolePK();
			pk.setRfpSectionId(to.getRfpSectionId());
			pk.setUsername(to.getUsername());
			entity.setSectionRoleId(pk);
			entity.setAverage(to.getAverage());
			entity.setComment(to.getComment());
			entity.setStatus(to.getStatus());

			em.getTransaction().begin();			
			em.persist(entity);
			em.getTransaction().commit();
			return true;
		}
		catch (Exception e) 
		{
			return false;
		}
		finally
		{
			if (em != null)
			{
				em.close();
			}
		}
	}
}