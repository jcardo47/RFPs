<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="f"  uri="http://java.sun.com/jsf/core"%>
<%@ taglib prefix="h"  uri="http://java.sun.com/jsf/html"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Login</title>
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
<body>
<jsp:include page="logo.jsp"></jsp:include>
<f:view>
	<h:form>	
	<center>
		<h1>Login</h1>	
			<h:panelGrid border="2" columns="1">			
			<h:panelGrid border="0" columns="2">
				<h:outputLabel value="Nombre de Usuario:"></h:outputLabel>
				<h:inputText value="#{loginMB.username}" required="true" requiredMessage="Ingrese el nombre de Usuario">					
				</h:inputText>
				<h:outputLabel value="Contraseña:"></h:outputLabel>
				<h:inputSecret value="#{loginMB.password}" required="true" requiredMessage="Ingrese la contraseña"></h:inputSecret>											
			</h:panelGrid>
			</h:panelGrid>
			<h:commandButton value="Login" action="#{loginMB.login}"></h:commandButton>
			<h:outputLabel value="#{loginMB.message}" style="color: #FF0000"></h:outputLabel>				
			<br><h:messages style="color: #FF0000"></h:messages><br>
			<h:outputLabel value="Si no tiene usuario aún "/><h:outputLink value="RegisterUserView.jsp">Regístrese aquí</h:outputLink>			
	</center>
	</h:form>
</f:view>
</body>
</html>
