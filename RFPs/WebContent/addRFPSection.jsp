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
	<div align="center"><h1>Administrar Secciones RFP</h1></div>
	<table>
		<tr>
			<td>RFP:</td>
			<td><h:outputText value="#{rfpSectionsMB.rfp.name}"/></td>
		</tr>
		<tr>
			<td>Compa&ntilde;&iacute;a</td>
			<td><h:outputText value="#{rfpSectionsMB.rfp.company}"/></td>
		</tr>
		<tr>
			<td>Fecha de Inicio</td>
			<td><h:outputText value="#{rfpSectionsMB.rfp.startDate}" converter="dateConverter"/></td>
		</tr>
		<tr>
			<td>Fecha de Decisi&oacute;n</td>
			<td><h:outputText value="#{rfpSectionsMB.rfp.decitionDate}" converter="dateConverter"/></td>
		</tr>
	</table>
	<h:dataTable border="1" value="#{rfpSectionsMB.rfpSections}" var="section">
		<h:column>
			<f:facet name="header">
				<h:outputText value="Sección"></h:outputText>
			</f:facet>
			<h:outputText value="#{section.sectionName}"></h:outputText>
		</h:column>
		<h:column>
			<f:facet name="header">
				<h:outputText value="Puntuación"></h:outputText>
			</f:facet>
			<h:outputText value="#{section.average}"/>
		</h:column>
		<h:column>
			<f:facet name="header">
				<h:outputText value="Acción"></h:outputText>
			</f:facet>
			<h:outputLink value="addItem.jsp?rfpId=#{rfpSectionsMB.rfp.requestId}&rfpSectionId=#{section.rfpSectionId}">Ver Items</h:outputLink>
		</h:column>
	</h:dataTable>
	<h:form>
	<h:panelGrid columns="1">
	<h:panelGrid columns="2">
		<h:outputText value="Agregar Sección"/>
		<h:selectOneMenu value="#{rfpSectionsMB.sectionId}">
			<f:selectItem itemLabel="-Select-" itemValue="-1"/>
			<f:selectItems value="#{rfpSectionsMB.sectionList}"/>
		</h:selectOneMenu>
		<h:outputText value="Responsable"></h:outputText>
		<h:selectOneMenu value="#{rfpSectionsMB.userName}">
			<f:selectItem itemLabel="-Select-" itemValue="-1"/>
			<f:selectItems value="#{rfpSectionsMB.userList}"/>
		</h:selectOneMenu>
	</h:panelGrid>
	<h:commandButton value="Agregar" action="#{rfpSectionsMB.addSection}"/>
	</h:panelGrid>
	</h:form>
</f:view>
</body>
</html>