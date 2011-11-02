<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="f"  uri="http://java.sun.com/jsf/core"%>
<%@ taglib prefix="h"  uri="http://java.sun.com/jsf/html"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<link rel="stylesheet" type="text/css" href="css/style.css" />
</head>
<body>
<%@include file="UserTemplate.jsp"%>

<f:view>
<h:form>
	<center>
		<h:panelGrid border="1" columns="1">
			<h:outputLink value="ListSectionRoles.jsp">Listar RFPs Asignados</h:outputLink>
			<h:outputLink value="RegisterUserView.jsp">Editar Perfil</h:outputLink>					
		</h:panelGrid>
	</center>	
</h:form>
</f:view>
</body>
</html>