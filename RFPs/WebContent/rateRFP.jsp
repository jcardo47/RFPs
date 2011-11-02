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
<h1>Calificar RFP</h1>
	<h:form>
	<h:panelGrid columns="1">
	<h:panelGrid columns="2">
		<h:outputLabel value="RFP:"/>
		<h:outputLabel value="#{rateRFPMB.rfpName}"/>
		<h:outputLabel value="Compañía:"/>
		<h:outputLabel value="#{rateRFPMB.company}"/>
		<h:outputLabel value="Promedio Secciones:"/>
		<h:outputLabel value="#{rateRFPMB.avgSections}"/>
		<h:outputLabel value="Puntuación"/>
		<h:inputText value="#{rateRFPMB.average}" validatorMessage="El valor debe estar entre 0 y 5">
			<f:validateDoubleRange minimum="0" maximum="5"/>
		</h:inputText>
	</h:panelGrid>
	<h:commandButton value="Guardar Puntuación" action="#{rateRFPMB.rateRFPn}"/>
	</h:panelGrid>
	</h:form>
	<h:messages></h:messages>
	</center>
</f:view>
</body>
</html>