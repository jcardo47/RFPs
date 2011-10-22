package com.rfp.service;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import org.apache.catalina.manager.StatusTransformer;

import com.rfp.entity.RFPStatus;
import com.rfp.to.RFPStatusTO;

public class RFPStatusService {

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
}