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
<f:view>
	<table>
	<h:form>
		<tr>
			<td>User Name</td>
			<td><h:inputText value="#{loginMB.username}"></h:inputText></td>
		</tr>
		<tr>
			<td>Password</td>
			<td><h:inputText value="#{loginMB.password}"></h:inputText></td>
		</tr>
		<tr>
			<td colspan="2"><h:commandButton type="submit" value="Login"></h:commandButton></td>
		</tr>
	</h:form>
	</table>
</f:view>
</body>
</html>