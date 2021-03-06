<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<c:set var="contextPath" value="${pageContext.request.contextPath}" />
<!--Table-->
<div class="container-fluid">
		<c:if test="${not empty msg}">
			<div class="alert alert-${css} alert-dismissible" role="alert">
				<button type="button" class="close" data-dismiss="alert" aria-label="Close">
					<span aria-hidden="true">&times;</span>
				</button>
				<strong>${msg}</strong>
			</div>
		</c:if>
	<table class="table table-bordered table-striped table-sm">
		<thead>
			<tr>
				<th scope="col col-sm">#Id</th>
				<th scope="col">Username</th>
				<th scope="col">Email</th>
				<th scope="col">Privilege</th>
				<th scope="col">Action</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach var="user" items="${users}">
				<tr>
					<th scope="row">${user.userId}</th>
					<td>${user.username}</td>
					<td>${user.email}</td>
					<td>${user.privilege.access}</td>
					<td>
						<%-- 						<form action="${contextPath}/users/${user.userId}/delete"  method="post"><input class="btn btn-danger" type="submit" value="Delete"/></form> --%>
						<%-- 						<form action="${contextPath}/users/${user.userId}/update"  method="post"><input class="btn btn-danger" type="submit" value="Update"/></form> --%>
						<spring:url value="/users/${user.userId}/delete" var="deleteUrl" />
<%-- 						<spring:url value="/users/${user.userId}/update" var="updateUrl" /> --%>
<!-- 						<button class="btn btn-primary" -->
<%-- 							onclick="location.href='${updateUrl}'">Update</button> --%>
						<button class="btn btn-danger"
							onclick="this.disabled=true;post('${deleteUrl}')">Delete</button>
					</td>

				</tr>
			</c:forEach>
		</tbody>
	</table>
	<input type="hidden" name="${_csrf.parameterName}"
				value="${_csrf.token}" />
</div>

<!--/Table-->