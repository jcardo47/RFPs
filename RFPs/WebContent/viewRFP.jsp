<%@page import="com.rfp.bean.ViewRFPMB"%>
<%@page import="java.util.Calendar"%>
<%@page import="javax.faces.el.ValueBinding"%>
<%@page import="javax.faces.application.Application"%>
<%@page import="javax.faces.context.FacesContext"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="f"  uri="http://java.sun.com/jsf/core"%>
<%@ taglib prefix="h"  uri="http://java.sun.com/jsf/html"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Ver RFP</title>
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
		$( "#decitionDate" ).datepicker();
	});
	
	function updateDate(campo)
	{
		var strDate = document.getElementById(campo).value; 
		document.getElementById("form:" + campo).value = strDate;
	}
</script>
</head>
<%
	boolean edit = false;
	if (request.getParameter("edit") != null && request.getParameter("edit").equals("true"))
	{
		edit = true;
	}
	else
	{
		ViewRFPMB mb = (ViewRFPMB)(FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("rfpViewMB"));
		if (mb == null)
		{
			mb = new ViewRFPMB();
			FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("rfpViewMB", mb);
		}
		mb.updateMB();	    
	}
 %>
<body>
<jsp:include page="logo.jsp"></jsp:include>
<f:view>
<center>
	<h1>Administración de RFP</h1>
<% if (!edit) { %>
	<table border="1">
	<tr>
		<td><h:outputLabel value="Nombre"/></td>
		<td><h:outputLabel value="#{rfpViewMB.rfp.name}"/></td>
	</tr>
	<tr>
		<td><h:outputLabel value="Fecha de Inicio"/></td>
		<td><h:outputLabel value="#{rfpViewMB.rfp.startDate}" converter="dateConverter"/></td>
	</tr>
	<tr>
		<td><h:outputLabel value="Fecha de Decisión"/></td>
		<td><h:outputLabel value="#{rfpViewMB.rfp.decitionDate}" converter="dateConverter"/></td>
	</tr>
	<tr>
		<td><h:outputLabel value="Compañía"/></td>
		<td><h:outputLabel value="#{rfpViewMB.rfp.company}"/></td>
	</tr>
	<tr>
		<td><h:outputLabel value="Estado"/></td>
		<td><h:outputLabel value="#{rfpViewMB.rfp.status.name}"/></td>
	</tr>
	<tr>
		<td><h:outputLabel value="Comentario"/></td>
		<td><h:outputLabel value="#{rfpViewMB.rfp.comment}"/></td>
	</tr>
	<tr>
		<td><h:outputLabel value="Puntuación"/></td>
		<td><h:outputLabel value="#{rfpViewMB.rfp.average}"/></td>
	</tr>
	<tr>
		<td><h:outputLabel value="Archivo"/></td>
		<td><h:outputLink value="#{rfpViewMB.rfp.filename}">Ver/Descargar</h:outputLink></td>
	</tr>
	</table>
	<table>
	<tr>
		<td><h:outputLink value="viewRFP.jsp?id=#{rfpViewMB.rfp.requestId}&edit=true">Editar</h:outputLink></td>
		<td><h:outputLink value="addRFPSection.jsp?id=#{rfpViewMB.rfp.requestId}">Ver Secciones</h:outputLink></td>
	</tr>
	</table>
<% } else { 
		
	FacesContext context = FacesContext.getCurrentInstance();  
    Application app = context.getApplication();  
    ValueBinding binding = app.createValueBinding("#{rfpViewMB.rfp.startDate}");  
    Calendar startDate = (Calendar)binding.getValue(context);
    binding = app.createValueBinding("#{rfpViewMB.rfp.decitionDate}");  
    Calendar decitionDate = (Calendar)binding.getValue(context);
    
    String strStartDate = "" + (startDate.get(Calendar.MONTH) + 1) + "/" + startDate.get(Calendar.DATE) +
    					  "/" + startDate.get(Calendar.YEAR);
    String strDecitionDate = "" + (decitionDate.get(Calendar.MONTH) + 1) + "/" + decitionDate.get(Calendar.DATE) +
    					     "/" + decitionDate.get(Calendar.YEAR);
		
		%>
	<h:form id="form">
	<table border="1">
	<tr>
		<td><h:outputLabel value="Nombre"/></td>
		<td><h:inputText value="#{rfpViewMB.rfp.name}"></h:inputText></td>
	</tr>
	<tr>
		<td><h:outputLabel value="Fecha de Inicio"/></td>
		<td><h:inputHidden id="startDate" value="#{rfpViewMB.rfp.startDate}" converter="dateConverter"></h:inputHidden>
			<input id="startDate" onchange="updateDate('startDate');" value="<%=strStartDate%>"></td>
	</tr>
	<tr>
		<td><h:outputLabel value="Fecha de Decisión"/></td>
		<td><h:inputHidden id="decitionDate" value="#{rfpViewMB.rfp.decitionDate}" converter="dateConverter"></h:inputHidden>
			<input id="decitionDate" onchange="updateDate('decitionDate');" value="<%=strDecitionDate%>"></td>
	</tr>
	<tr>
		<td><h:outputLabel value="Compañía"/></td>
		<td><h:inputText value="#{rfpViewMB.rfp.company}"></h:inputText></td>
	</tr>
	<tr>
		<td><h:outputLabel value="Estado"/></td>
		<td><h:selectOneMenu value="#{rfpViewMB.statusId}">
				<f:selectItem itemLabel="-Select-" itemValue="-1"/>
				<f:selectItems value="#{rfpViewMB.statusList}"/>
			</h:selectOneMenu></td>
	</tr>
	<tr>
		<td><h:outputLabel value="Comentario"/></td>
		<td><h:inputText value="#{rfpViewMB.rfp.comment}"></h:inputText></td>
	</tr>
	<tr>
		<td><h:outputLabel value="Puntuación"/></td>
		<td><h:inputText value="#{rfpViewMB.rfp.average}">
			<f:validateDoubleRange minimum="0" maximum="5"/>
		</h:inputText></td>
	</tr>
	<tr>
		<td colspan="2"><h:commandButton value="Editar" action="#{rfpViewMB.editRFP}"></h:commandButton></td>
	</tr>
	</table>
	</h:form>
<% } %>
</center>
</f:view>
</body>
</html>