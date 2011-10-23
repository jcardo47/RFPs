package com.rfp.manager;

import java.util.Calendar;
import java.util.Date;
import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import com.rfp.service.SectionRoleService;
import com.rfp.service.UserService;
import com.rfp.to.RFPSectionTO;
import com.rfp.to.RFPTO;
import com.rfp.to.SectionRoleTO;
import com.rfp.to.UserTO;

public class SectionRoleManager extends Thread {

	private Thread thread;
	private String toMail;
	private String fromMail;
	private RFPTO rfp;
	private RFPSectionTO rfpSection;
	
	public boolean createSectionRole(SectionRoleTO to, RFPTO rfp, RFPSectionTO rfpSection)
	{
		SectionRoleService service = new SectionRoleService();
		if (service.createSectionRole(to))
		{
			this.rfp = rfp;
			this.rfpSection = rfpSection;
			UserTO user = new UserService().getUser(to.getUsername());
			toMail = user.getEmail();
			fromMail = "lgomezm4@eafit.edu.co";
			thread = new Thread(this);
			thread.start();
			return true;
		}
		else
		{
			return false;
		}
	}
	
	public void run()
	{		
		Properties properties = new Properties();
		properties.put("mail.smtp.host", "sigma.eafit.edu.co");    
        properties.put("mail.smtp.port", "25");
        properties.put("mail.smtp.starttls.enable","true");
		Session session = Session.getDefaultInstance(properties);
		
		try {
		    MimeMessage msg = new MimeMessage(session);
		    msg.setFrom(new InternetAddress(fromMail));
		    InternetAddress[] address = {new InternetAddress(toMail)};
		    msg.setRecipients(Message.RecipientType.TO, address);
		    msg.setSubject("Asignación en el RFP " + rfp.getName());
		    msg.setSentDate(new Date());
		    msg.setText("Se ha realizado la asignación de la sección " + rfpSection.getSectionName() +
		    		" en el RFP " + rfp.getName() + ".\nEl RFP tiene fecha de decisión para el " +
		    		calToString(rfp.getDecitionDate()) + ".\n\nNo responda a este correo.");
		    Transport.send(msg);
		} catch (MessagingException mex) {
			mex.printStackTrace();
		}
	}
	
	public String calToString(Calendar calendar)
	{
		return "" + (calendar.get(Calendar.MONTH) + 1) + "/" + calendar.get(Calendar.DATE) + "/" + 
				calendar.get(Calendar.YEAR); 
	}
}