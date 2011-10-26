package com.rfp.bean;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import com.rfp.to.StatusStatsTO;
import com.rfp.wrapper.RFPWrapper;

public class StatusStatsMB {
	
	private String fromDate;
	private String toDate;
	private List<StatusStatsTO> stats;
	private String message;
	private boolean renderTable;
	
	public StatusStatsMB() {
		renderTable = false;
	}

	public List<StatusStatsTO> getStats() {
		return stats;
	}

	public void setStats(List<StatusStatsTO> stats) {
		this.stats = stats;
	}

	public String getFromDate() {
		return fromDate;
	}

	public void setFromDate(String fromDate) {
		this.fromDate = fromDate;
	}

	public String getToDate() {
		return toDate;
	}

	public void setToDate(String toDate) {
		this.toDate = toDate;
	}

	public String retrieveStats()
	{
		if (stats != null)
		{
			fromDate = "";
			toDate = "";
			stats.clear();
		}
		RFPWrapper wrapper = new RFPWrapper();
		stats = wrapper.getStatusStats();
		if (stats.size() > 0)
		{
			renderTable = true;
		}
		else
		{
			renderTable = false;
		}
		message = "";
		return "success";
	}
	
	public String retrieveByDate()
	{
		if (stats != null)
		{
			stats.clear();
		}
		DateFormat formatter = new SimpleDateFormat("MM/dd/yyyy");
		Calendar calFrom = Calendar.getInstance();
		Calendar calTo = Calendar.getInstance();
		try
		{
			calFrom.setTime((Date)formatter.parse(fromDate));
			calTo.setTime((Date)formatter.parse(toDate));
			
			RFPWrapper wrapper = new RFPWrapper();
			stats = wrapper.getStatusStats(calFrom, calTo);
			if (stats.size() > 0)
			{
				renderTable = true;
			}
			else
			{
				renderTable = false;
			}
			fromDate = "";
			toDate = "";
			message = "";
			return "success";
		}
		catch (Exception e) {
			message = "Debe seleccionar dos fechas";
			return "failure";
		}
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public boolean isRenderTable() {
		return renderTable;
	}

	public void setRenderTable(boolean renderTable) {
		this.renderTable = renderTable;
	}
}