package com.rfp.service;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import com.rfp.entity.RFP;
import com.rfp.to.RequestTO;

public class RFPService {

	public void registerRFP(RequestTO requestTO)
	{
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("RFPs");
		EntityManager em = null;
		try
		{
			em = emf.createEntityManager();

			RFP request = new RFP();
			request.setName(requestTO.getName());
			request.setStartDate(requestTO.getStartDate());
			request.setDecitionDate(requestTO.getDecitionDate());
			request.setCompany(requestTO.getCompany());
			request.setFilename(requestTO.getFilename());
			
			em.persist(request);
			requestTO.setRequestId(request.getRfpId());
		}
		catch (Exception e) 
		{
			requestTO.setRequestId(-1);
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