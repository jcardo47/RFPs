package com.rfp.service;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import com.rfp.entity.Section;
import com.rfp.to.SectionTO;

public class SectionService {
	
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