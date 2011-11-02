<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="f"  uri="http://java.sun.com/jsf/core"%>
<%@ taglib prefix="h"  uri="http://java.sun.com/jsf/html"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Registrar RFP</title>
<link rel="stylesheet" type="text/css" href="css/style.css" />
</head>
<body>
<f:view>
<jsp:include page="logo.jsp"></jsp:include>
	<center>
		<h1>Resultado Registro RFP</h1>
	<% if (request.getParameter("success").equals("true"))
	   { %>
	   <label>RFP Registrado con exito.</label>
	<% }
	   else
	   { %>
	   <label>RFP No pudo ser Registrado con exito.</label>
	<% } %>
	</center>
</f:view>
</body>
</html>