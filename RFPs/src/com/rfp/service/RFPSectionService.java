package com.rfp.service;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import com.rfp.entity.RFPSection;
import com.rfp.entity.Section;
import com.rfp.to.RFPSectionTO;

public class RFPSectionService {

	public List<RFPSectionTO> getRFPSections(long rfpId)
	{
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("RFPs");
		EntityManager em = null;
		try
		{
			em = emf.createEntityManager();
			Query query = em.createQuery("select rs from RFPSection rs where rs.rfpId = :id");
			query.setParameter("id", rfpId);
			List<RFPSection> rs = query.getResultList();
			List<RFPSectionTO> list = new ArrayList<RFPSectionTO>(); 
			for (RFPSection sec : rs)
			{
				Section section = em.find(Section.class, sec.getSectionId());
				RFPSectionTO to = new RFPSectionTO();
				to.setSectionId(sec.getSectionId());
				to.setRfpSectionId(sec.getRfpSectionId());
				to.setRfpId(sec.getRfpId());
				to.setAverage(sec.getAverage());
				to.setSectionName(section.getName());
				list.add(to);
			}
			return list;
		}
		finally
		{
			if (em != null)
			{
				em.close();
			}
		}
	}
	
	public boolean addRFPSection(RFPSectionTO to)
	{
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("RFPs");
		EntityManager em = null;
		try
		{
			em = emf.createEntityManager();
			RFPSection entity = new RFPSection();
			entity.setRfpId(to.getRfpId());
			entity.setSectionId(to.getSectionId());
			entity.setAverage(to.getAverage());
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
	
	public RFPSectionTO getRFPSection(long id)
	{
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("RFPs");
		EntityManager em = null;
		try
		{
			em = emf.createEntityManager();
			RFPSection entity = em.find(RFPSection.class, id);
			if (entity != null)
			{
				RFPSectionTO to = new RFPSectionTO();
				to.setAverage(entity.getAverage());
				to.setRfpId(to.getRfpId());
				to.setRfpSectionId(id);
				to.setSectionId(entity.getSectionId());
				Section section = em.find(Section.class, to.getSectionId());
				to.setSectionName(section.getName());
				return to;
			}
			else
			{
				return null;
			}
		}
		catch (Exception e) 
		{
			return null;
		}
		finally
		{
			if (em != null)
			{
				em.close();
			}
		}
	}
	
	public boolean rateRFPSection(RFPSectionTO to)
	{
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("RFPs");
		EntityManager em = null;
		try
		{
			em = emf.createEntityManager();
			RFPSection entity = em.find(RFPSection.class, to.getRfpSectionId());
			if (entity != null)
			{
				em.getTransaction().begin();
				entity.setAverage(to.getAverage());
				em.getTransaction().commit();
				return true;
			}
			else
			{
				return false;
			}
		}
		finally
		{
			if (em != null)
			{
				em.close();
			}
		}
	}
	
	public double getAvgRFPSections(long rfpId)
	{
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("RFPs");
		EntityManager em = null;
		try
		{
			em = emf.createEntityManager();
			Query query = em.createQuery("select rs from RFPSection rs where rs.rfpId = :id");
			query.setParameter("id", rfpId);
			List<RFPSection> rs = query.getResultList();
			double avg = 0.0;
			for (RFPSection section : rs)
			{
				avg += section.getAverage();
			}
			return avg / rs.size();
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