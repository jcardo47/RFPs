<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="f"  uri="http://java.sun.com/jsf/core"%>
<%@ taglib prefix="h"  uri="http://java.sun.com/jsf/html"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Registrar RFP</title>
<link type="text/css" href="css/ui-lightness/jquery-ui-1.8.16.custom.css" rel="stylesheet" />	
<script type="text/javascript" src="js/jquery-1.6.2.min.js"></script>
<script type="text/javascript" src="js/jquery-ui-1.8.16.custom.min.js"></script>
<script>
	$(function() {
		$( "#startDate" ).datepicker();
	});
	
	$(function() {
		$( "#decitionDate" ).datepicker();
	});
	
	function updateStartDate() {
		var sDate = document.getElementById("startDate").value;
		document.getElementById("form:startDate").value = sDate;
	}
	
	function updateDecitionDate() {
		var sDate = document.getElementById("decitionDate").value;
		document.getElementById("form:decitionDate").value = sDate;
	}
</script>
</head>
<body>
<f:view>
<center>
	<table>
	<h:form id="form">
		<tr>
			<td>Nombre</td>
			<td><h:inputText value="#{registerRFPMB.name}"></h:inputText> </td>
		</tr>
		<tr>
			<td>Fecha de Inicio</td>
			<td><input type="text" id="startDate" onchange="updateStartDate()">
			<h:inputHidden id="startDate" value="#{registerRFPMB.startDate}" converter="dateConverter"></h:inputHidden></td>
		</tr>
		<tr>
			<td>Fecha de Decisión</td>
			<td><input type="text" id="decitionDate" onchange="updateDecitionDate()">
			<h:inputHidden id="decitionDate" value="#{registerRFPMB.decitionDate}" converter="dateConverter"></h:inputHidden></td>
		</tr>
		<tr>
			<td>Compañia</td>
			<td><h:inputText value="#{registerRFPMB.company}"></h:inputText></td>
		</tr>
		<tr>
			<td>Archivo</td>
			<td><h:inputText value="#{registerRFPMB.filename}"></h:inputText></td>
		</tr>
		<tr>
			<td colspan="2"><h:commandButton value="Registrar" action="#{registerRFPMB.registerRFP}" onclick=""></h:commandButton></td>
		</tr>
	</h:form>
	</table>
	<h:messages></h:messages>
</center>
</f:view>
</body>
</html>