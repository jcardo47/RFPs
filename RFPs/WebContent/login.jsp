<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="f"  uri="http://java.sun.com/jsf/core"%>
<%@ taglib prefix="h"  uri="http://java.sun.com/jsf/html"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Login</title>
</head>
<body>
<jsp:include page="logo.jsp"></jsp:include>
<f:view>
	<h:form>	
	<center>
		<h1>Login</h1>				
			<h:panelGrid border="1" columns="2">
				<h:outputLabel value="Nombre de Usuario:"></h:outputLabel>
				<h:inputText value="#{loginMB.username}" required="true" requiredMessage="Ingrese el nombre de Usuario">					
				</h:inputText>
				<h:outputLabel value="Contrase�a:"></h:outputLabel>
				<h:inputSecret value="#{loginMB.password}" required="true" requiredMessage="Ingrese la contrase�a"></h:inputSecret>											
			</h:panelGrid>
			<h:commandButton value="Login" action="#{loginMB.login}"></h:commandButton>
				<br>
				<h:outputLabel value="#{loginMB.message}" style="color: #FF0000"></h:outputLabel>				
<<<<<<< HEAD
				<br><h:messages style="color: #FF0000"></h:messages><br>
				Si no tiene usuario a�n <h:outputLink value="RegisterUserView.jsp">Reg�strese aqu�</h:outputLink>				
=======
				<br><h:messages style="color: #FF0000"></h:messages>			
>>>>>>> branch 'master' of https://jcardo47@github.com/jcardo47/RFPs.git
			</center>
		</h:form>
</f:view>
</body>
</html>
