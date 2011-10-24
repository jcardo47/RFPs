<%@page import="com.rfp.bean.RateRFPMB"%>
<%@page import="javax.faces.context.FacesContext"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="f"  uri="http://java.sun.com/jsf/core"%>
<%@ taglib prefix="h"  uri="http://java.sun.com/jsf/html"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Rate RFP</title>
</head>
<%
	RateRFPMB mb = (RateRFPMB)(FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("rateRFPMB"));
	if (mb == null)
	{
		mb = new RateRFPMB();
		FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("rateRFPMB", mb);
	}
	mb.updateMB();
 %>
<body>
<f:view>
<jsp:include page="logo.jsp"></jsp:include>
<center>
<div align="center"><h1>Calificar RFP</h1></div>
	<h:form>
	<h:panelGrid columns="1">
	<h:panelGrid columns="2">
		<h:outputText value="RFP:"></h:outputText>
		<h:outputText value="#{rateRFPMB.rfpName}"></h:outputText>
		<h:outputText value="Compañía:"></h:outputText>
		<h:outputText value="#{rateRFPMB.company}"></h:outputText>
		<h:outputText value="Promedio Secciones:"/>
		<h:outputText value="#{rateRFPMB.avgSections}"/>
		<h:outputText value="Puntuación"/>
		<h:inputText value="#{rateRFPMB.average}">
			<f:validateDoubleRange minimum="0" maximum="5"/>
		</h:inputText>
	</h:panelGrid>
	<h:commandButton value="Guardar Puntuación" action="#{rateRFPMB.rateRFPn}"/>
	</h:panelGrid>
	</h:form>
	</center>
</f:view>
</body>
</html>