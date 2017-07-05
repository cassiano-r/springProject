<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Spring Project</title>
</head>
<body>
<h1>Hello ${user.firstName}</h1>

<h3> User Form</h3>
<a href="${pageContext.request.contextPath}/user?myLocale=en_US">English</a> |
<a href="${pageContext.request.contextPath}/user?myLocale=pt_BR">Português</a>
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
		<label><spring:message code="user.firstName"/></label>
		<form:input class="form-control" path="firstName" id="firstName" type="text"/>
	</div>
	<div class="form-group row">
		<label><spring:message code="user.lastName"/></label>
		<form:input class="form-control" path="lastName" id="lastName" type="text"/>
	</div>
	<div class="form-group row">
		<label><spring:message code="user.cpf"/></label>
		<form:input class="form-control" path="cpf" id="cpf" type="text"/>
	</div>
	<div class="form-group row">
		<button class="btn btn-primary" type="submit">
			<i class="fa fa-floppy-o" aria-hidden="true"></i> Save
		</button>
	</div>
</form:form>
</div>

<h2>List of User</h2>

<form class="form-inline" action="${pageContext.request.contextPath}/user/find-by/">
	<div class="input-group">
		<input type="text" class="form-control" name="lastName" placeholder="Digit Last Name"/>
	</div>
	<div class="input-group">
		<input type="text" class="form-control" name="firstName" placeholder="Digit First Name"/>
	</div>
	<div class="input-group">
		<input type="text" class="form-control" name="cpf" placeholder="Digit CPF"/>
	</div>
	<button type="submit" class="btn btn-primary">Pesquisar</button>
</form>

<table class="table">
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
			<td><a href="#myModal_${user.id}" role="button" class="btn btn-danger" data-toggle="modal">
					Delete
					<i class="fa fa-trash-o"></i>
				</a>
			</td>
		</tr>
		<div id="myModal_${user.id}" class="modal fade">
			<div class="modal-dialog">
				<div class="modal-header">
					<h4 class="modal-title">Confirm Delete</h4>
				</div>
				<div class="modal-body">
					<button class="btn btn default" data-dismiss="modal">Close</button>
					<a href="${pageContext.request.contextPath}/user/delete/${user.id}" class="btn btn-danger">Delete</a>
				</div>
			</div>
		</div>		
	</c:forEach>
</table>

</body>
</html>