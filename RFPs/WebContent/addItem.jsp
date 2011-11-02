<%@page import="javax.faces.context.FacesContext"%>
<%@page import="com.rfp.bean.AddItemMB"%>
<%@page import="javax.servlet.http.HttpServletRequest"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="f"  uri="http://java.sun.com/jsf/core"%>
<%@ taglib prefix="h"  uri="http://java.sun.com/jsf/html"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" type="text/css" href="css/style.css" />
<link type="text/css" href="css/ui-lightness/jquery-ui-1.8.16.custom.css" rel="stylesheet" />
<script type="text/javascript" src="js/jquery-1.6.2.min.js"></script>
<script type="text/javascript" src="js/jquery-ui-1.8.16.custom.min.js"></script>
<title>Administrar Items</title>
<script>
	$(function() {
		$("input:submit").button();
	});
</script>
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
<jsp:include page="logo.jsp"></jsp:include>
<center>
	<div align="center"><h1>Administrar Items</h1></div>
	<h:form>
	<h:panelGrid columns="2">
		<h:outputLabel value="RFP:"/>
		<h:outputLabel value="#{addItemMB.rfpName}"/>
		<h:outputLabel value="Compañía:"/>
		<h:outputLabel value="#{addItemMB.company}"/>
		<h:outputLabel value="Sección:"/>
		<h:outputLabel value="#{addItemMB.sectionName}"/>
		<h:outputLabel value=""/>
		<h:outputLink value="rateSection.jsp?rfpId=#{addItemMB.rfpId}&rfpSectionId=#{addItemMB.rfpSectionId}">Calificar Secci&oacute;n</h:outputLink>
	</h:panelGrid>
	<% if (!mb.getItems().isEmpty()) { %>
	<h:dataTable border="1" value="#{addItemMB.items}" var="item">
		<h:column>
			<f:facet name="header">
				<h:outputLabel value="Item"/>
			</f:facet>
			<h:outputLabel value="#{item.name}"/>
		</h:column>
		<h:column>
			<f:facet name="header">
				<h:outputLabel value="Puntuación"/>
			</f:facet>
			<h:outputLabel value="#{item.value}"/>
		</h:column>
		<h:column>
			<f:facet name="header">
				<h:outputLabel value="Acción"/>
			</f:facet>			
			<h:outputLink value="rateItem.jsp?itemId=#{item.itemId}&rfpSectionId=#{item.requestSectionId}">Calificar</h:outputLink>
		</h:column>
		<h:column>
			<f:facet name="header">
				<h:outputLabel value="Acción"/>
			</f:facet>			
			<h:outputLink value="deleteItem.jsp?itemId=#{item.itemId}&rfpSectionId=#{item.requestSectionId}&rfpId=#{addItemMB.rfpId}">Eliminar</h:outputLink>
		</h:column>
	</h:dataTable>
	<% } %>
	<h:panelGrid columns="3">
		<h:outputLabel value="Nuevo Item:"/>
		<h:inputText value="#{addItemMB.itemName}"/>
		<h:commandButton value="Agregar Item" action="#{addItemMB.addItem}"/>
	</h:panelGrid>
	</h:form>
	</center>
</f:view>
</body>
</html>