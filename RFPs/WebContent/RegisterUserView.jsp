<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="f"  uri="http://java.sun.com/jsf/core"%>
<%@ taglib prefix="h"  uri="http://java.sun.com/jsf/html"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
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
				<h:inputText id="txtUserName" value="#{userMB.username}" required="true" requiredMessage="Ingrese el Nombre de Usuario"></h:inputText>
				<h:outputLabel value="Contraseña:"></h:outputLabel>
				<h:inputSecret id="txtPassword" value="#{userMB.password}" rendered="true" requiredMessage="Ingresa la Contraseña"></h:inputSecret>
					<h:outputLabel value="Repita la contraseña" ></h:outputLabel>
					<h:inputSecret id="txtPassword2" value="#{userMB.password2}"></h:inputSecret>
					<h:outputLabel value="Correo:"></h:outputLabel>
				<h:inputText id="txtEmail" value="#{userMB.email}"></h:inputText>
					<h:outputLabel value="Repita el correo:"></h:outputLabel>
					<h:inputText id="txtEmail2" value="#{userMB.email2}"></h:inputText>
				</h:panelGrid>
			
				<h:commandButton type="submit" value="#{userMB.butLabel}" action="#{userMB.registerUser}"></h:commandButton>
				<br><h:outputLabel value="#{userMB.message}" style="color: #FF0000"></h:outputLabel><br><h:messages style="color: #FF0000"></h:messages>
			</center>
		</h:form>
</f:view>
</body>
</html>