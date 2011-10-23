<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="f"  uri="http://java.sun.com/jsf/core"%>
<%@ taglib prefix="h"  uri="http://java.sun.com/jsf/html"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Admin Home</title>
</head>
<body>
	<%@include file="UserTemplate.jsp"%>
<f:view>
	<center>
	<h:form>
			<h:panelGrid border="1" columns="1">
				<h:outputLink value="SectionRegister.jsp">Crear Secciones</h:outputLink>				
				<h:outputLink value="RFPStatusRegister.jsp">Crear RFP Estados</h:outputLink>
				<h:outputLink value="RegisterUserView.jsp">Editar Perfil</h:outputLink>	
				<h:outputLink value="ListSectionRoles.jsp">Listar RFPs Asignados</h:outputLink>
				<h:outputLink value="searchRFP.jsp">Buscar RFPs</h:outputLink>						
			</h:panelGrid>
		</h:form>
</f:view>
</center>
</body>
</html>