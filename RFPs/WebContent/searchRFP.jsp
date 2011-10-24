<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="f"  uri="http://java.sun.com/jsf/core"%>
<%@ taglib prefix="h"  uri="http://java.sun.com/jsf/html"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Buscar RFP</title>
</head>
<body>
<f:view>
<jsp:include page="logo.jsp"></jsp:include>
	<center>
		<h1>Buscar RFPs</h1>
	<h:form>
	<table>
	<tr>
		<td>Nombre</td>
		<td><h:inputText value="#{rfpSearchMB.name}"/></td>
	</tr>
	<tr>
		<td>Compa&ntilde;&iacute;a</td>
		<td><h:inputText value="#{rfpSearchMB.company}"/></td>
	</tr>
	<tr>
		<td>Estado</td>
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
				<h:outputText value="Nombre"></h:outputText>
			</f:facet>
			<h:outputText value="#{rfp.name}"></h:outputText>
		</h:column>
		<h:column>
			<f:facet name="header">
				<h:outputText value="Compañía"></h:outputText>
			</f:facet>
			<h:outputText value="#{rfp.company}"></h:outputText>
		</h:column>
		<h:column>
			<f:facet name="header">
				<h:outputText value="Fecha de Inicio"></h:outputText>
			</f:facet>
			<h:outputText value="#{rfp.startDate}" converter="dateConverter"></h:outputText>
		</h:column>
		<h:column>
			<f:facet name="header">
				<h:outputText value="Fecha de Decisión"></h:outputText>
			</f:facet>
			<h:outputText value="#{rfp.decitionDate}" converter="dateConverter"></h:outputText>
		</h:column>
		<h:column>
			<f:facet name="header">
				<h:outputText value="Estado"></h:outputText>
			</f:facet>
			<h:outputText value="#{rfp.status.name}"></h:outputText>
		</h:column>
		<h:column>
			<f:facet name="header">
				<h:outputText value="Puntaje"></h:outputText>
			</f:facet>
			<h:outputText value="#{rfp.average}"></h:outputText>
		</h:column>
		<h:column>
			<f:facet name="header">
				<h:outputText value="Comentario"></h:outputText>
			</f:facet>
			<h:outputText value="#{rfp.comment}"></h:outputText>
		</h:column>
		<h:column>
			<f:facet name="header">
				<h:outputText value="Documento"></h:outputText>
			</f:facet>
			<h:outputLink value="#{rfp.filename}">Ver</h:outputLink>
		</h:column>
		<h:column>
			<f:facet name="header">
				<h:outputText value="Administrar"></h:outputText>
			</f:facet>
			<h:outputLink value="viewRFP.jsp?id=#{rfp.requestId}">Administrar</h:outputLink>
		</h:column>
		<h:column>
			<f:facet name="header">
				<h:outputText value="Calificar"></h:outputText>
			</f:facet>
			<h:outputLink value="rateRFP.jsp?rfpId=#{rfp.requestId}">Calificar</h:outputLink>
		</h:column>
	</h:dataTable>
	</center>
</f:view>
</body>
</html>