package com.rfp.service;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import com.rfp.entity.Item;
import com.rfp.to.ItemTO;

public class ItemService {

	public boolean addItem(ItemTO to)
	{
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("RFPs");
		EntityManager em = null;
		try
		{
			em = emf.createEntityManager();
			Item item = new Item();
			item.setName(to.getName());
			item.setRequestSectionId(to.getRequestSectionId());
			item.setValue(to.getValue());
			em.getTransaction().begin();
			em.persist(item);
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
	
	public List<ItemTO> getSectionItems(long rfpSectionId)
	{
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("RFPs");
		EntityManager em = null;
		try
		{
			em = emf.createEntityManager();
			Query query = em.createQuery("select i from Item i where i.requestSectionId = :id");
			query.setParameter("id", rfpSectionId);
			List<Item> rs = query.getResultList();
			List<ItemTO> list = new ArrayList<ItemTO>(); 
			for (Item item : rs)
			{
				ItemTO to = new ItemTO();
				to.setItemId(item.getItemId());
				to.setName(item.getName());
				to.setValue(item.getValue());
				to.setRequestSectionId(rfpSectionId);
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
	
	public ItemTO getItem(long id)
	{
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("RFPs");
		EntityManager em = null;
		try
		{
			em = emf.createEntityManager();
			Item entity = em.find(Item.class, id);
			if (entity != null)
			{
				ItemTO to = new ItemTO();
				to.setItemId(id);
				to.setRequestSectionId(entity.getRequestSectionId());
				to.setName(entity.getName());
				to.setValue(entity.getValue());
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
	
	public boolean rateItem(ItemTO to)
	{
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("RFPs");
		EntityManager em = null;
		try
		{
			em = emf.createEntityManager();
			Item entity = em.find(Item.class, to.getItemId());
			if (entity != null)
			{
				em.getTransaction().begin();
				entity.setValue(to.getValue());
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
	
	public double getAvgItems(long rfpSectionId)
	{
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("RFPs");
		EntityManager em = null;
		try
		{
			em = emf.createEntityManager();
			Query query = em.createQuery("select i from Item i where i.requestSectionId = :id");
			query.setParameter("id", rfpSectionId);
			List<Item> rs = query.getResultList();
			double avg = 0.0;
			for (Item item : rs)
			{
				avg += item.getValue();
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