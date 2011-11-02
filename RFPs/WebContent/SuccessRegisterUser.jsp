<%@page import="com.rfp.to.UserTO"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="f"  uri="http://java.sun.com/jsf/core"%>
<%@ taglib prefix="h"  uri="http://java.sun.com/jsf/html"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<link rel="stylesheet" type="text/css" href="css/style.css" />
</head>
<body>
<f:view>
	<jsp:include page="logo.jsp"></jsp:include>
	<center>
	<h1>Registro Completo!</h1>	
	<%
		UserTO userTO = (UserTO)session.getAttribute("username");
		String pageTo = "";
		if (userTO != null)
		{
			if (userTO.isAdmin())
			{			
				pageTo = "adminHome.jsp";				
			}	
			else
			{
				pageTo = "UserHome.jsp";		
			}
			out.println("<a href=\"" + pageTo +"\">Ir Página Principal <a/>" );
		}
	 %>	 
	</center> 
</f:view>
</body>
</html>