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
<jsp:include page="logo.jsp"></jsp:include>
<center>
<div align="center"><h1>Calificar Secci&oacute;n</h1></div>
	<h:form>
	<h:panelGrid columns="1">
	<h:panelGrid columns="2">
		<h:outputLabel value="RFP:"/>
		<h:outputLabel value="#{rateSectionMB.rfpName}"/>
		<h:outputLabel value="Compañía:"/>
		<h:outputLabel value="#{rateSectionMB.company}"/>
		<h:outputLabel value="Sección:"/>
		<h:outputLabel value="#{rateSectionMB.sectionName}"/>
		<h:outputLabel value="Promedio Items:"/>
		<h:outputLabel value="#{rateSectionMB.avgItems}"/>
		<h:outputLabel value="Puntuación"/>
		<h:inputText value="#{rateSectionMB.value}">
			<f:validateDoubleRange minimum="0" maximum="5"/>
		</h:inputText>
	</h:panelGrid>
	<h:commandButton value="Guardar Puntuación" action="#{rateSectionMB.rateSection}"/>
	</h:panelGrid>
	</h:form>
	<h:messages></h:messages>
	</center>
</f:view>
</body>
</html>