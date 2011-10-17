<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="f"  uri="http://java.sun.com/jsf/core"%>
<%@ taglib prefix="h"  uri="http://java.sun.com/jsf/html"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Lista de RFPs</title>
</head>
<body>
<f:view>
<center>
	<h1>Lista de RFPs</h1>
	<h:dataTable border="1" value="#{}">
		<h:column id="column1">
			<f:facet name="header">
				<h:outputText value="Nombre"></h:outputText>
			</f:facet>
			
		</h:column>
		<h:column id="column2">
			<f:facet name="header">
				<h:outputText value="Fecha de Inicio"></h:outputText>
			</f:facet>
		</h:column>
		<h:column id="column3">
			<f:facet name="header">
				<h:outputText value="Fecha de Decisión"></h:outputText>
			</f:facet>
		</h:column>
		<h:column id="column4">
			<f:facet name="header">
				<h:outputText value="Compañía"></h:outputText>
			</f:facet>
		</h:column>
	</h:dataTable>
		</center>
</f:view>
</body>
</html>