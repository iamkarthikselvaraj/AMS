<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<c:set var="contextPath" value="${pageContext.request.contextPath}" />


<div class="container">
	<c:if test="${not empty msg}">
		<div class="alert alert-${css} alert-dismissible" role="alert">
			<button type="button" class="close" data-dismiss="alert"
				aria-label="Close">
				<span aria-hidden="true">&times;</span>
			</button>
			<strong>${msg}</strong>
		</div>
	</c:if>
	<form:form method="POST" modelAttribute="userForm" id="createUserform"
		class="form-signin">
		<h2 class="form-signin-heading">Create User</h2>
		<spring:bind path="username">
			<div class="form-group ${status.error ? 'has-error' : ''}">
				<form:input type="text" path="username" name="username1"
					class="form-control" placeholder="Username" autofocus="true"></form:input>
				<form:errors path="username"></form:errors>
			</div>
		</spring:bind>
		<spring:bind path="email">
			<div class="form-group ${status.error ? 'has-error' : ''}">
				<form:input type="text" path="email" name="email"
					class="form-control" placeholder="Email"></form:input>
				<form:errors path="email"></form:errors>
			</div>
		</spring:bind>
		<spring:bind path="password">
			<div class="form-group ${status.error ? 'has-error' : ''}">
				<form:input type="password" path="password" name="password"
					class="form-control" placeholder="Password"></form:input>
				<form:errors path="password"></form:errors>
			</div>
		</spring:bind>

		<spring:bind path="passwordConfirm">
			<div class="form-group ${status.error ? 'has-error' : ''}">
				<form:input type="password" path="passwordConfirm"
					name="passwordConfirm" class="form-control"
					placeholder="Confirm your password"></form:input>
				<form:errors path="passwordConfirm"></form:errors>
			</div>
		</spring:bind>
		<spring:bind path="privilege">
			<div class="form-group">
				<form:select path="privilege.privilegeId" name="privilege">
					<form:option value="0" label="--- Select Privilege---" />
					<form:options items="${privilegeList}" itemValue="privilegeId"
						itemLabel="access"></form:options>
				</form:select>
				<form:errors path="privilege"></form:errors>
			</div>
		</spring:bind>
		<button class="btn btn-lg btn-primary btn-block" type="submit">Submit</button>
	</form:form>
</div>
