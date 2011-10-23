package com.rfp.service;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import com.rfp.entity.Section;
import com.rfp.exception.SectionAlreadySaved;
import com.rfp.to.SectionTO;

public class SectionService {
	
	
	public boolean sectionExists(SectionTO sectionTO)
	{
		boolean exists = false;
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("RFPs");
		EntityManager em = null;
		try
		{
			em = emf.createEntityManager();
			Query query = em.createQuery("select s from Section s where s.name = :newName");
			query.setParameter("newName", sectionTO.getName());
			List<Section> rs = query.getResultList();
			if (rs.size() > 0)
			{
				exists = true;
			}
		}
		finally
		{
			if (em != null)
			{
				em.close();
			}
		}
		return exists;
	}
	
	
	public SectionTO registerSection (SectionTO sectionTO)
	{
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("RFPs");
		EntityManager em = null;
		try
		{			
			Section section = new Section();
			section.setName(sectionTO.getName());
			em = emf.createEntityManager();
			em.getTransaction().begin();
			em.persist(section);			
			em.getTransaction().commit();
			sectionTO.setSectionId(section.getSectionId());
		}
		finally
		{
			if (em != null)
			{
				em.close();
			}
		}
		return sectionTO;
	}
	
	public List<SectionTO> getAllSections()
	{
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("RFPs");
		EntityManager em = null;
		try
		{
			em = emf.createEntityManager();
			Query query = em.createQuery("select s from Section s");
			List<Section> rs = query.getResultList();
			List<SectionTO> resutl = new ArrayList<SectionTO>();
			for (Section section : rs)
			{
				SectionTO to = new SectionTO();
				to.setSectionId(section.getSectionId());
				to.setName(section.getName());
				resutl.add(to);
			}
			return resutl;
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