<%@page import="javax.faces.context.FacesContext"%>
<%@page import="com.rfp.bean.RateSectionMB"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="f"  uri="http://java.sun.com/jsf/core"%>
<%@ taglib prefix="h"  uri="http://java.sun.com/jsf/html"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Rate Section</title>
</head>
<%
	RateSectionMB mb = (RateSectionMB)(FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("rateSectionMB"));
	if (mb == null)
	{
		mb = new RateSectionMB();
		FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("rateSectionMB", mb);
	}
	mb.updateMB();
 %>
<body>
<f:view>
<div align="center"><h1>Calificar Secci&oacute;n</h1></div>
	<h:form>
	<h:panelGrid columns="1">
	<h:panelGrid columns="2">
		<h:outputText value="RFP:"></h:outputText>
		<h:outputText value="#{rateSectionMB.rfpName}"></h:outputText>
		<h:outputText value="Compañía:"></h:outputText>
		<h:outputText value="#{rateSectionMB.company}"></h:outputText>
		<h:outputText value="Sección:"/>
		<h:outputText value="#{rateSectionMB.sectionName}"/>
		<h:outputText value="Promedio Items:"/>
		<h:outputText value="#{rateSectionMB.avgItems}"/>
		<h:outputText value="Puntuación"/>
		<h:inputText value="#{rateSectionMB.value}">
			<f:validateDoubleRange minimum="0" maximum="5"/>
		</h:inputText>
	</h:panelGrid>
	<h:commandButton value="Guardar Puntuación" action="#{rateSectionMB.rateSection}"/>
	</h:panelGrid>
	</h:form>
</f:view>
</body>
</html>