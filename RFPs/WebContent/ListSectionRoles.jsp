<%@page import="com.rfp.to.RFPTO"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="f"  uri="http://java.sun.com/jsf/core"%>
<%@ taglib prefix="h"  uri="http://java.sun.com/jsf/html"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Asignaciones</title>
<link rel="stylesheet" type="text/css" href="css/style.css" />
</head>
<body>
<f:view>
<jsp:include page="logo.jsp"></jsp:include>
	<center>
		<h1>RFPs Asignados</h1>
		<h:form>
				<h:dataTable border="1" value="#{listRFPSectionRoles.result}" var="result">
					<h:column id="column1">
						<f:facet name="header">							
							<h:outputLabel value="RFP"/>
						</f:facet>
						<h:outputLabel value="#{result[0]}"/>					
					</h:column>
					<h:column id="column2">
						<f:facet name="header">
							<h:outputLabel value="Acción"/>							
						</f:facet>						
						<h:outputLink value="viewRFP.jsp?id=#{result[1]}">Ver RFP</h:outputLink>						
					</h:column>
					<h:column id="column3">
						<f:facet name="header">
							<h:outputLabel value="Sección"/>							
						</f:facet>				
						<h:outputLabel value="#{result[2]}"/>																
					</h:column>
					<h:column id="column4">
						<f:facet name="header">
							<h:outputLabel value="Acción"/>							
						</f:facet>
						<h:outputLink value="addItem.jsp?rfpId=#{result[1]}&rfpSectionId=#{result[3]}">Ver Sección</h:outputLink>												
					</h:column>
				</h:dataTable>
				<%
					request.setAttribute("oelo", "oelo");									
				%>
			</h:form>
	</center>
</f:view>
</body>
</html>