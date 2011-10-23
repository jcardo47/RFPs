<%@page import="javax.faces.context.FacesContext"%>
<%@page import="com.rfp.bean.RateItemMB"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="f"  uri="http://java.sun.com/jsf/core"%>
<%@ taglib prefix="h"  uri="http://java.sun.com/jsf/html"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Rate Item</title>
</head>
<%
	RateItemMB mb = (RateItemMB)(FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("rateItemMB"));
	if (mb == null)
	{
		mb = new RateItemMB();
		FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("rateItemMB", mb);
	}
	mb.updateMB();
 %>
<body>
<f:view>
	<div align="center"><h1>Calificar Item</h1></div>
	<h:form>
	<h:panelGrid columns="1">
	<h:panelGrid columns="2">
		<h:outputText value="RFP:"></h:outputText>
		<h:outputText value="#{rateItemMB.rfpName}"></h:outputText>
		<h:outputText value="Compañía:"></h:outputText>
		<h:outputText value="#{rateItemMB.company}"></h:outputText>
		<h:outputText value="Sección:"/>
		<h:outputText value="#{rateItemMB.sectionName}"/>
		<h:outputText value="Item:"/>
		<h:outputText value="#{rateItemMB.itemName}"/>
		<h:outputText value="Puntuación"/>
		<h:inputText value="#{rateItemMB.value}">
			<f:validateDoubleRange minimum="0" maximum="5"/>
		</h:inputText>
	</h:panelGrid>
	<h:commandButton value="Guardar Puntuación" action="#{rateItemMB.rateItem}"/>
	</h:panelGrid>
	</h:form>
</f:view>
</body>
</html>