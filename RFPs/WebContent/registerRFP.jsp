<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="f"  uri="http://java.sun.com/jsf/core"%>
<%@ taglib prefix="h"  uri="http://java.sun.com/jsf/html"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Registrar RFP</title>
<link rel="stylesheet" type="text/css" href="css/style.css" />
<link type="text/css" href="css/ui-lightness/jquery-ui-1.8.16.custom.css" rel="stylesheet" />
<script type="text/javascript" src="js/jquery-1.6.2.min.js"></script>
<script type="text/javascript" src="js/jquery-ui-1.8.16.custom.min.js"></script>
<script>
	$(function() {
		$("input:submit").button();
	});

	$(function() {
		$( "#startDate" ).datepicker();
	});

	$(function() {
		$( "#decitionDate" ).datepicker();
	});
</script>
</head>
<body>
<f:view>
<jsp:include page="logo.jsp"></jsp:include>
<center>
	<h1>Registrar RFP</h1>
	<table>
	<form action="RegisterRFPServlet" enctype="multipart/form-data" method="post">
	<tr>
		<td><h:outputLabel value="Nombre"/></td>
		<td><input type="text" name="name" id="name"></td>
	</tr>
	<tr>
		<td><h:outputLabel value="Fecha de Inicio"/></td>
		<td><input type="text" id="startDate" name="startDate"></td>
	</tr>
	<tr>
		<td><h:outputLabel value="Fecha de Decisión"/></td>
		<td><input type="text" id="decitionDate" name="decitionDate"></td>
	</tr>
	<tr>
		<td><h:outputLabel value="Compañía"/></td>
		<td><input type="text" id="company" name="company"></td>
	</tr>
	<tr>
		<td><h:outputLabel value="Archivo"/></td>
		<td><input type="file" name="fichero"></td>
	</tr>
	<tr>
    	<td colspan="2"><input type="submit" value="Registrar"></td>
    </tr>
    </form>
    </table>
</center>
</f:view>
</body>
</html>