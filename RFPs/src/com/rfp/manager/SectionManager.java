package com.rfp.manager;

import java.util.List;

import com.rfp.service.SectionService;
import com.rfp.to.SectionTO;

public class SectionManager {
	
	public List<SectionTO> getAllSections()
	{
		SectionService service = new SectionService();
		return service.getAllSections();
	}
}