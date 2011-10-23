package com.rfp.manager;

import java.util.List;

import com.rfp.exception.SectionAlreadySaved;
import com.rfp.service.SectionService;
import com.rfp.to.SectionTO;

public class SectionManager {
	
	public List<SectionTO> getAllSections()
	{
		SectionService service = new SectionService();
		return service.getAllSections();
	}
	
	public SectionTO registerSection (SectionTO sectionTO) throws SectionAlreadySaved
	{
		SectionService service = new SectionService();
		if (!service.sectionExists(sectionTO))
		{
			return service.registerSection(sectionTO);
		}
		else
		{
			throw new SectionAlreadySaved();
		}
	}
}