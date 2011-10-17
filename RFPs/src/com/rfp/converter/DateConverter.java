package com.rfp.converter;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.ConverterException;

public class DateConverter implements Converter{

	@Override
	public Object getAsObject(FacesContext context, UIComponent component, String str) 
	{  	
		try
		{
			DateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
			Date date = (Date)formatter.parse(str); 
			Calendar cal = Calendar.getInstance();
			cal.setTime(date);
			return cal;
		}
		catch (Exception e)
		{
			throw new ConverterException();
		} 		
	}

	@Override
	public String getAsString(FacesContext context, UIComponent component, Object object)
	{
		Calendar calendar = (Calendar)object;
		return "" + calendar.get(Calendar.DATE) + "/" + calendar.get(Calendar.MONTH) + "/" + 
				calendar.get(Calendar.YEAR); 
	}
}