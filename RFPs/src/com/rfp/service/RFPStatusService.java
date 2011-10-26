package com.rfp.service;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;


import com.rfp.entity.RFPStatus;
import com.rfp.entity.Section;
import com.rfp.to.RFPStatusTO;
import com.rfp.to.StatusStatsTO;


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
	
	public List<StatusStatsTO> getStatusStats()
	{
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("RFPs");
		EntityManager em = null;
		try
		{
			em = emf.createEntityManager();
			List<StatusStatsTO> resutl = new ArrayList<StatusStatsTO>();
			List<RFPStatusTO> status = getAllStatus();
			for (RFPStatusTO st : status)
			{
				Query query = em.createQuery("select count(rfp.rfpId) from RFP rfp where rfp.status.statusId = :statusId");
				query.setParameter("statusId", st.getStatusId());
				long count = (Long)query.getSingleResult();
				double avg = 0.0;
				if (count > 0)
				{
					query = em.createQuery("select avg(rfp.average) from RFP rfp where rfp.status.statusId = :statusId");
					query.setParameter("statusId", st.getStatusId());
					avg = (Double)query.getSingleResult();
				}
				StatusStatsTO to = new StatusStatsTO();
				to.setAverage(avg);
				to.setQuantity(count);
				to.setStatus(st);
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
	
	public List<StatusStatsTO> getStatusStats(Calendar fromDate, Calendar toDate)
	{
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("RFPs");
		EntityManager em = null;
		try
		{
			em = emf.createEntityManager();
			List<StatusStatsTO> resutl = new ArrayList<StatusStatsTO>();
			List<RFPStatusTO> status = getAllStatus();
			for (RFPStatusTO st : status)
			{
				Query query = em.createQuery("select count(rfp.rfpId) from RFP rfp where rfp.status.statusId = :statusId and rfp.decitionDate between :fromDate and :toDate");
				query.setParameter("statusId", st.getStatusId());
				query.setParameter("fromDate", fromDate);
				query.setParameter("toDate", toDate);
				long count = (Long)query.getSingleResult();
				double avg = 0.0;
				if (count > 0)
				{
					query = em.createQuery("select avg(rfp.average) from RFP rfp where rfp.status.statusId = :statusId and rfp.decitionDate between :fromDate and :toDate");
					query.setParameter("statusId", st.getStatusId());
					query.setParameter("fromDate", fromDate);
					query.setParameter("toDate", toDate);
					avg = (Double)query.getSingleResult();
				}
				StatusStatsTO to = new StatusStatsTO();
				to.setAverage(avg);
				to.setQuantity(count);
				to.setStatus(st);
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