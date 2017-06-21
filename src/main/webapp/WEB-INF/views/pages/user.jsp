<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Spring Project</title>
</head>
<body>
<h1>Hello ${user.firstName}</h1>

<h3> User Form</h3>
<c:choose>
	<c:when test="${user.id > 0}">
		<c:set var="formMethod" value="PUT"></c:set>
		<c:url var="formAction" value="/user/${user.id}"></c:url>
	</c:when>
	<c:otherwise>
		<c:set var="formMethod" value="POST"></c:set>
		<c:url var="formAction" value="/user"></c:url>
	</c:otherwise>
</c:choose>

<div class="container-fluid">
<form:form modelAttribute="user" action="${formAction}" method="${formMethod}">
	<div class="form-group row">
		<label>Name:</label>
		<form:input class="form-control" path="firstName" id="firstName" type="text"/>
	</div>
	<div class="form-group row">
		<label>Last Name:</label>
		<form:input class="form-control" path="lastName" id="lastName" type="text"/>
	</div>
	<div class="form-group row">
		<label>CPF:</label>
		<form:input class="form-control" path="cpf" id="cpf" type="text"/>
	</div>
	<div class="form-group row">
		<button class="btn btn-primary" type="submit">
			<i class="fa fa-floppy-o" aria-hidden="true"></i>Save
		</button>
	</div>
</form:form>
</div>

<h2>List of User</h2>

<table>
	<tr>
		<td>Last Name</td>
		<td>First Name</td>
		<td>CPF</td>
		<td>Edit</td>
		<td>Delete</td>
	</tr>
	<c:forEach items="${users}" var="user">
		<tr>
			<td>${user.lastName}</td>
			<td>${user.firstName}</td>
			<td>${user.cpf}</td>
			<td><a href="${pageContext.request.contextPath}/user/${user.id}">Edit</a></td>
		</tr>
	</c:forEach>
</table>

</body>
</html>