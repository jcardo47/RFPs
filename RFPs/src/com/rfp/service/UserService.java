package com.rfp.service;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import com.rfp.entity.User;
import com.rfp.to.UserTO;

public class UserService 
{
	public boolean login(UserTO userTO)
	{
		boolean result = false;
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("RFPs");
		EntityManager em = null;
		try
		{
			em = emf.createEntityManager();
			
			User user = em.find(User.class, userTO.getUsername());
			if (user != null)
			{
				if (user.getPassword().equals(userTO.getPassword()))
				{
					result = true;
				}
			}
			return result;
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
