<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="f"  uri="http://java.sun.com/jsf/core"%>
<%@ taglib prefix="h"  uri="http://java.sun.com/jsf/html"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
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
<f:view>
<jsp:include page="logo.jsp"></jsp:include>
	<h:form>
	<center>
		<h1><h:outputLabel value="#{userMB.butLabel}"/> Usuario</h1>
			<h:panelGrid border="1" columns="2">
				<h:outputLabel value="Nombre:"></h:outputLabel>
				<h:inputText id="txtName" value="#{userMB.firstName}"></h:inputText>
				<h:outputLabel value="Apellido:"></h:outputLabel>
				<h:inputText id="txtLastName" value="#{userMB.lastName}"></h:inputText>
				<h:outputLabel value="Nombre Usuario:"></h:outputLabel>
				<h:inputText id="txtUserName" value="#{userMB.username}" required="true" requiredMessage="Ingrese el Nombre de Usuario" disabled="#{userMB.renderPass}" ></h:inputText>				
				<h:outputLabel value="Contraseņa:"></h:outputLabel>
				<h:inputSecret id="txtPassword" value="#{userMB.password}" rendered="true" requiredMessage="Ingresa la Contraseņa" disabled="#{userMB.renderPass }"></h:inputSecret>
					<h:outputLabel value="Repita la contraseņa" ></h:outputLabel>
					<h:inputSecret id="txtPassword2" value="#{userMB.password2}" disabled="#{userMB.renderPass }" ></h:inputSecret>					
					<h:outputLabel value="Correo:"></h:outputLabel>
				<h:inputText id="txtEmail" value="#{userMB.email}"></h:inputText>
					<h:outputLabel value="Repita el correo:"></h:outputLabel>
					<h:inputText id="txtEmail2" value="#{userMB.email2}"></h:inputText>
				</h:panelGrid>
			
				<h:commandButton type="submit" value="#{userMB.butLabel}" action="#{userMB.processRequest}"></h:commandButton>
				<br><h:outputLabel value="#{userMB.message}" style="color: #FF0000"></h:outputLabel><br><h:messages style="color: #FF0000"></h:messages>
			</center>
		</h:form>
</f:view>
</body>
</html>