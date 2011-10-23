<%@page import="javax.faces.context.FacesContext"%>
<%@page import="com.rfp.to.UserTO"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="f"  uri="http://java.sun.com/jsf/core"%>
<%@ taglib prefix="h"  uri="http://java.sun.com/jsf/html"%>
	<center>
	<h1>Bienvenido:  
		<%		
			UserTO userTo = (UserTO) session.getAttribute("username");	
			if (userTo != null)
			{
				out.println(userTo.getFirstName() + " " + userTo.getLastName());
			}			
	 	%>
	 	
	</h1>
	</center>