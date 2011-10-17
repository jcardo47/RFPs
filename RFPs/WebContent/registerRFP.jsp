<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="f"  uri="http://java.sun.com/jsf/core"%>
<%@ taglib prefix="h"  uri="http://java.sun.com/jsf/html"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Registrar RFP</title>
</head>
<body>
<f:view>
<center>
	<table>
	<h:form>
		<tr>
			<td>Nombre</td>
			<td><h:inputText value="#{registerRFPMB.name}"></h:inputText></td>
		</tr>
		<tr>
			<td>Fecha de Inicio</td>
			<td><h:inputText value="#{registerRFPMB.startDate}" converter="dateConverter"></h:inputText></td>
		</tr>
		<tr>
			<td>Fecha de Decisión</td>
			<td><h:inputText value="#{registerRFPMB.decitionDate}" converter="dateConverter"></h:inputText></td>
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
			<td colspan="2"><h:commandButton value="Registrar" action="#{registerRFPMB.registerRFP} }"></h:commandButton></td>
		</tr>
	</h:form>
	</table>
</center>
</f:view>
</body>
</html>