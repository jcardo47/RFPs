package com.rfp.service;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;


import com.rfp.entity.RFPStatus;
import com.rfp.entity.Section;
import com.rfp.to.RFPStatusTO;


public class RFPStatusService {

	
	
	
	public RFPStatusTO registerSection (RFPStatusTO rfpStatusTO)
	{
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("RFPs");
		EntityManager em = null;
		try
		{			
			RFPStatus rfpStatus = new RFPStatus();
			rfpStatus.setName(rfpStatusTO.getName());
			em = emf.createEntityManager();
			em.getTransaction().begin();
			em.persist(rfpStatus);			
			em.getTransaction().commit();
			rfpStatusTO.setStatusId(rfpStatus.getStatusId());
		}
		finally
		{
			if (em != null)
			{
				em.close();
			}
		}
		return rfpStatusTO;
	}
	
	public List<RFPStatusTO> getAllStatus()
	{
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("RFPs");
		EntityManager em = null;
		try
		{
			em = emf.createEntityManager();
			Query query = em.createQuery("select s from RFPStatus s");
			List<RFPStatus> rs = query.getResultList();
			List<RFPStatusTO> resutl = new ArrayList<RFPStatusTO>();
			for (RFPStatus status : rs)
			{
				RFPStatusTO to = new RFPStatusTO();
				to.setStatusId(status.getStatusId());
				to.setName(status.getName());
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
	
	public RFPStatusTO getStatus(int id)
	{
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("RFPs");
		EntityManager em = null;
		try
		{
			em = emf.createEntityManager();
			RFPStatusTO to = null;
			RFPStatus status = em.find(RFPStatus.class, id);
			if (status != null)
			{
				to = new RFPStatusTO();
				to.setStatusId(status.getStatusId());
				to.setName(status.getName());
			}
			return to;
		}
		finally
		{
			if (em != null)
			{
				em.close();
			}
		}
	}
	
	
	public boolean statusExists(RFPStatusTO rfpStatus)
	{
		boolean exists = false;
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("RFPs");
		EntityManager em = null;
		try
		{
			em = emf.createEntityManager();
			Query query = em.createQuery("select s from RFPStatus s where s.name = :newName");
			query.setParameter("newName", rfpStatus.getName());
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
}