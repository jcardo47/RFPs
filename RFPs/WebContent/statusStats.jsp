<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="f"  uri="http://java.sun.com/jsf/core"%>
<%@ taglib prefix="h"  uri="http://java.sun.com/jsf/html"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Status Stats</title>
<link rel="stylesheet" type="text/css" href="css/style.css" />
<link type="text/css" href="css/ui-lightness/jquery-ui-1.8.16.custom.css" rel="stylesheet" />
<script type="text/javascript" src="js/jquery-1.6.2.min.js"></script>
<script type="text/javascript" src="js/jquery-ui-1.8.16.custom.min.js"></script>
<script>
	$(function() {
		$("input:submit").button();
	});

	$(function() {
		$( "#startDate" ).datepicker();
	});
	
	$(function() {
		$( "#toDate" ).datepicker();
	});
</script>
<script type="text/javascript">
	function updateDate(textBox, dest)
	{
		document.getElementById(dest).value = textBox.value;
	}
</script>
</head>
<body>
<f:view>
<jsp:include page="logo.jsp"></jsp:include>
<center>
	<div align="center"><h1>Estad&iacute;sticas por Estado de RFP</h1></div>
	<h:form id="form">
		<h:inputHidden id="from" value="#{statusStatsMB.fromDate}"/>
		<h:inputHidden id="to" value="#{statusStatsMB.toDate}"/>
		<h:panelGrid border="1" columns="2">
			<h:outputLabel value="Desde"/>
			<input id="startDate" onchange="updateDate(document.getElementById('startDate'), 'form:from');" readonly="readonly">
			<h:outputLabel value="Hasta"/>
			<input id="toDate" onchange="updateDate(document.getElementById('toDate'), 'form:to');" readonly="readonly">
			<h:commandButton value="Ver Todos" action="#{statusStatsMB.retrieveStats}"/>
			<h:commandButton value="Buscar" action="#{statusStatsMB.retrieveByDate}"/>
		</h:panelGrid>
	</h:form>
	<h:outputLabel value="#{statusStatsMB.message}" style="color: #FF0000"/>
	<h:dataTable border="1" value="#{statusStatsMB.stats}" var="stat" rendered="#{statusStatsMB.renderTable}">
		<h:column>
			<f:facet name="header">
				<h:outputLabel value="Estado"/>
			</f:facet>
			<h:outputLabel value="#{stat.status.name}"/>
		</h:column>
		<h:column>
			<f:facet name="header">
				<h:outputLabel value="Número de RFP"/>
			</f:facet>
			<h:outputLabel value="#{stat.quantity}"/>
		</h:column>
		<h:column>
			<f:facet name="header">
				<h:outputLabel value="Calificación Promedio"/>
			</f:facet>
			<h:outputLabel value="#{stat.average}"/>
		</h:column>
	</h:dataTable>
</center>
</f:view>
</body>
</html>