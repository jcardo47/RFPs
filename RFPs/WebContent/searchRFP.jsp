<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="f"  uri="http://java.sun.com/jsf/core"%>
<%@ taglib prefix="h"  uri="http://java.sun.com/jsf/html"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Buscar RFP</title>
<link rel="stylesheet" type="text/css" href="css/style.css" />
<link type="text/css" href="css/ui-lightness/jquery-ui-1.8.16.custom.css" rel="stylesheet" />
<script type="text/javascript" src="js/jquery-1.6.2.min.js"></script>
<script type="text/javascript" src="js/jquery-ui-1.8.16.custom.min.js"></script>
<script>
	$(function() {
		$("input:submit").button();
	});
</script>
</head>
<body>
<f:view>
<jsp:include page="logo.jsp"></jsp:include>
	<center>
		<h1>Buscar RFPs</h1>
	<h:form>
	<table>
	<tr>
		<td><h:outputLabel value="Nombre"/></td>
		<td><h:inputText value="#{rfpSearchMB.name}"/></td>
	</tr>
	<tr>
		<td><h:outputLabel value="Compa&ntilde;&iacute;a"/></td>
		<td><h:inputText value="#{rfpSearchMB.company}"/></td>
	</tr>
	<tr>
		<td><h:outputLabel value="Estado"/></td>
		<td><h:selectOneMenu value="#{rfpSearchMB.statusId}">
				<f:selectItem itemLabel="-Select-" itemValue="-1"/>
				<f:selectItems value="#{rfpSearchMB.statusList}"/>
			</h:selectOneMenu>
		</td>
	</tr>
	<tr>
		<td><h:commandButton value="Buscar" action="#{rfpSearchMB.searchRFP}"/></td>
		<td><h:commandButton value="Mostrar Todos" action="#{rfpSearchMB.showAllRFPs}"/></td>
	</tr>
	</table>
	</h:form>
	<h:dataTable border="1" value="#{rfpSearchMB.rfps}" var="rfp" rendered="#{rfpSearchMB.renderTable}">
		<h:column>
			<f:facet name="header">
				<h:outputLabel value="Nombre"/>
			</f:facet>
			<h:outputLabel value="#{rfp.name}"/>
		</h:column>
		<h:column>
			<f:facet name="header">
				<h:outputLabel value="Compañía"/>
			</f:facet>
			<h:outputLabel value="#{rfp.company}"/>
		</h:column>
		<h:column>
			<f:facet name="header">
				<h:outputLabel value="Fecha de Inicio"/>
			</f:facet>
			<h:outputLabel value="#{rfp.startDate}" converter="dateConverter"/>
		</h:column>
		<h:column>
			<f:facet name="header">
				<h:outputLabel value="Fecha de Decisión"/>
			</f:facet>
			<h:outputLabel value="#{rfp.decitionDate}" converter="dateConverter"/>
		</h:column>
		<h:column>
			<f:facet name="header">
				<h:outputLabel value="Estado"/>
			</f:facet>
			<h:outputLabel value="#{rfp.status.name}"/>
		</h:column>
		<h:column>
			<f:facet name="header">
				<h:outputLabel value="Puntaje"/>
			</f:facet>
			<h:outputLabel value="#{rfp.average}"/>
		</h:column>
		<h:column>
			<f:facet name="header">
				<h:outputLabel value="Comentario"/>
			</f:facet>
			<h:outputLabel value="#{rfp.comment}"/>
		</h:column>
		<h:column>
			<f:facet name="header">
				<h:outputLabel value="Documento"/>
			</f:facet>
			<h:outputLink value="#{rfp.filename}">Ver</h:outputLink>
		</h:column>
		<h:column>
			<f:facet name="header">
				<h:outputLabel value="Administrar"/>
			</f:facet>
			<h:outputLink value="viewRFP.jsp?id=#{rfp.requestId}">Administrar</h:outputLink>
		</h:column>
		<h:column>
			<f:facet name="header">
				<h:outputLabel value="Calificar"/>
			</f:facet>
			<h:outputLink value="rateRFP.jsp?rfpId=#{rfp.requestId}">Calificar</h:outputLink>
		</h:column>
	</h:dataTable>
	</center>
</f:view>
</body>
</html>