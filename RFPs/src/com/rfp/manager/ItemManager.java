package com.rfp.manager;

import java.util.List;

import com.rfp.service.ItemService;
import com.rfp.to.ItemTO;

public class ItemManager {

	public boolean addItem(ItemTO to)
	{
		ItemService service = new ItemService();
		return service.addItem(to);
	}
	
	public List<ItemTO> getSectionItems(long rfpSectionId)
	{
		ItemService service = new ItemService();
		return service.getSectionItems(rfpSectionId);
	}
	
	public ItemTO getItem(long id)
	{
		ItemService service = new ItemService();
		return service.getItem(id);
	}
	
	public boolean rateItem(ItemTO to)
	{
		ItemService service = new ItemService();
		return service.rateItem(to);
	}
	
	public double getAvgItems(long rfpSectionId)
	{
		ItemService service = new ItemService();
		return service.getAvgItems(rfpSectionId);
	}
}