<%@page import="javax.faces.context.FacesContext"%>
<%@page import="com.rfp.bean.AddItemMB"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="f"  uri="http://java.sun.com/jsf/core"%>
<%@ taglib prefix="h"  uri="http://java.sun.com/jsf/html"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Add Item</title>
</head>
<%
	AddItemMB mb = (AddItemMB)(FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("addItemMB"));
	if (mb == null)
	{
		mb = new AddItemMB();
		FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("addItemMB", mb);
	}
	mb.updateMB();
 %>
<body>
<f:view>
	<div align="center"><h1>Administrar Items</h1></div>
	<h:form>
	<h:panelGrid columns="2">
		<h:outputText value="RFP:"></h:outputText>
		<h:outputText value="#{addItemMB.rfpName}"></h:outputText>
		<h:outputText value="Compañía:"></h:outputText>
		<h:outputText value="#{addItemMB.company}"></h:outputText>
		<h:outputText value="Sección:"/>
		<h:outputText value="#{addItemMB.sectionName}"/>
	</h:panelGrid>
	<h:dataTable border="1" value="#{addItemMB.items}" var="item">
		<h:column>
			<f:facet name="header">
				<h:outputText value="Item"></h:outputText>
			</f:facet>
			<h:outputText value="#{item.name}"/>
		</h:column>
		<h:column>
			<f:facet name="header">
				<h:outputText value="Puntuación"></h:outputText>
			</f:facet>
			<h:outputText value="#{item.value}"/>
		</h:column>
	</h:dataTable>
	<h:panelGrid columns="3">
		<h:outputText value="Nuevo Item:"/>
		<h:inputText value="#{addItemMB.itemName}"/>
		<h:commandButton value="Agregar Item" action="#{addItemMB.addItem}"/>
	</h:panelGrid>
	</h:form>
</f:view>
</body>
</html>