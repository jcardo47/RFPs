<%@page import="javax.faces.context.FacesContext"%>
<%@page import="com.rfp.bean.AdminRFPSectionsMB"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="f"  uri="http://java.sun.com/jsf/core"%>
<%@ taglib prefix="h"  uri="http://java.sun.com/jsf/html"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>RFP Sections</title>
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
<%
	AdminRFPSectionsMB mb = (AdminRFPSectionsMB)(FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("rfpSectionsMB"));
	if (mb == null)
	{
		mb = new AdminRFPSectionsMB();
		FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("rfpSectionsMB", mb);
	}
	mb.updateMB();	
 %>
<body>
<f:view>
<jsp:include page="logo.jsp"></jsp:include>
<center>
	<div align="center"><h1>Administrar Secciones RFP</h1></div>
	<table>
		<tr>
			<td><h:outputLabel value="RFP:"/></td>
			<td><h:outputLabel value="#{rfpSectionsMB.rfp.name}"/></td>
		</tr>
		<tr>
			<td><h:outputLabel value="Compañía"/></td>
			<td><h:outputLabel value="#{rfpSectionsMB.rfp.company}"/></td>
		</tr>
		<tr>
			<td><h:outputLabel value="Fecha de Inicio"/></td>
			<td><h:outputLabel value="#{rfpSectionsMB.rfp.startDate}" converter="dateConverter"/></td>
		</tr>
		<tr>
			<td><h:outputLabel value="Fecha de Decisión"/></td>
			<td><h:outputLabel value="#{rfpSectionsMB.rfp.decitionDate}" converter="dateConverter"/></td>
		</tr>
	</table>
	<% if (!mb.getRfpSections().isEmpty()) { %>
	<h:dataTable border="1" value="#{rfpSectionsMB.rfpSections}" var="section">
		<h:column>
			<f:facet name="header">
				<h:outputLabel value="Sección"/>
			</f:facet>
			<h:outputLabel value="#{section.sectionName}"/>
		</h:column>
		<h:column>
			<f:facet name="header">
				<h:outputLabel value="Puntuación"/>
			</f:facet>
			<h:outputLabel value="#{section.average}"/>
		</h:column>
		<h:column>
			<f:facet name="header">
				<h:outputLabel value="Acción"/>
			</f:facet>
			<h:outputLink value="addItem.jsp?rfpId=#{rfpSectionsMB.rfp.requestId}&rfpSectionId=#{section.rfpSectionId}">Ver Items</h:outputLink>
		</h:column>
	</h:dataTable>
	<% } %>
	<h:form>
	<h:panelGrid columns="1">
	<h:panelGrid columns="2">
		<h:outputLabel value="Agregar Sección"/>
		<h:selectOneMenu value="#{rfpSectionsMB.sectionId}">
			<f:selectItem itemLabel="-Select-" itemValue="-1"/>
			<f:selectItems value="#{rfpSectionsMB.sectionList}"/>
		</h:selectOneMenu>
		<h:outputLabel value="Responsable"/>
		<h:selectOneMenu value="#{rfpSectionsMB.userName}">
			<f:selectItem itemLabel="-Select-" itemValue="-1"/>
			<f:selectItems value="#{rfpSectionsMB.userList}"/>
		</h:selectOneMenu>
	</h:panelGrid>
	<h:commandButton value="Agregar" action="#{rfpSectionsMB.addSection}"/>
	</h:panelGrid>
	</h:form>
	</center>
</f:view>
</body>
</html>