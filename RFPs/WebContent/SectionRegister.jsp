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
	<center>
		<h1>Registro de Secciones</h1>
		<h:form>
				<h:panelGrid border="1" columns="2">
					<h:outputLabel value="Nombre"></h:outputLabel>
					<h:inputText id="txtName" value="#{ sectionRegisterMB.name }" required="true" requiredMessage="Ingrese el nombre de la sección"></h:inputText>
				</h:panelGrid>
				<h:commandButton id="butAdd" value="Registrar" action="#{sectionRegisterMB.register}"></h:commandButton>
				<br><h:outputLabel value="#{sectionRegisterMB.message }" style="color: #FF0000"></h:outputLabel>
				<br><h:messages style="color: #FF0000"></h:messages>
			</h:form>		
	</center>
</f:view>
</body>
</html>