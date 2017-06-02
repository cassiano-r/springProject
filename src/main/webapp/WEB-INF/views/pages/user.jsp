<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Spring Project</title>
</head>
<body>
<h1>Hello ${user.firstName}</h1>

<h3> User Form</h3>

<form:form modelAttribute="user" action="${pageContext.request.contextPath}/user/save" method="GET">

	<div>
		<label>Name:</label>
		<form:input path="firstName" id="firstName" type="text"/>
	</div>
	<div>
		<label>Last Name:</label>
		<form:input path="lastName" id="lastName" type="text"/>
	</div>
	<div>
		<label>CPF:</label>
		<form:input path="cpf" id="cpf" type="text"/>
	</div>
	<div>
		<form:button>Save</form:button>
	</div>

</form:form>

<h2>List of User</h2>

<table>
	<tr>
		<td>Last Name</td>
		<td>First Name</td>
		<td>CPF</td>
	</tr>
	<c:forEach items="${users}" var="user">
		<tr>
			<td>${user.lastName}</td>
			<td>${user.firstName}</td>
			<td>${user.cpf}</td>
		</tr>
	</c:forEach>
</table>

</body>
</html>