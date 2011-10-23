package com.rfp.service;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import com.rfp.entity.User;
import com.rfp.to.UserTO;

public class UserService 
{
	
	public UserTO getUserByUserName(UserTO userTO)
	{
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("RFPs");
		UserTO newUserTO = null;
		EntityManager em = null;
		try
		{
			em = emf.createEntityManager();
			User user = em.find(User.class, userTO.getUsername());
			if (user != null)
			{
				newUserTO = entityUserTO(user);
			}
		}
		finally
		{
			if (em != null)
			{
				em.close();
			}
		}
			
		return newUserTO;
	}
	
	
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
	
	public boolean userNameExist (UserTO userTO)
	{
		boolean exist = false;
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("RFPs");
		EntityManager em = null;
		try
		{
			em = emf.createEntityManager();
			User user = em.find(User.class, userTO.getUsername());
			if (user != null)
			{
				exist = true;
			}
		}
		finally
		{
			if (em != null)
			{
				em.close();
			}
		}		
		return exist;
	}
	
	
	public UserTO registerUser(UserTO userTo)
	{
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("RFPs");
		EntityManager em = null;
		try
		{
			em = emf.createEntityManager();
			em.getTransaction().begin();
			User user = userTOEntity(userTo);
			em.persist(user);
			em.getTransaction().commit();			
		}
		finally
		{
			if (em != null)
			{
				em.close();
			}
		}		
		return userTo;
	}

	public static UserTO entityUserTO (User user)
	{
		UserTO userTO = new UserTO();
		userTO.setEmail(user.getEmail());
		userTO.setFirstName(user.getFirstName());
		userTO.setLastName(user.getLastName());
		userTO.setUsername(user.getUsername());
		userTO.setPassword(user.getPassword());
		userTO.setAdmin(user.isAdmin());
		return userTO;
	}
	
	public static User userTOEntity (UserTO userTo)
	{
		User user = new User();
		user.setEmail(userTo.getEmail());
		user.setFirstName(userTo.getFirstName());
		user.setLastName(userTo.getLastName());
		user.setUsername(userTo.getUsername());
		user.setPassword(userTo.getPassword());
		
		return user;
	}
}