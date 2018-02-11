<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<c:set var="contextPath" value="${pageContext.request.contextPath}" />
<!--Panel-->

<div class="container-fluid auth-form">

	<table class="" style="width: 100%; height: 85%;">
		<tr>
			<td align="center"><c:if test="${not empty msg}">
					<div class="alert alert-${css} alert-dismissible" role="alert">
						<button type="button" class="close" data-dismiss="alert"
							aria-label="Close">
							<span aria-hidden="true">&times;</span>
						</button>
						<strong>${msg}</strong>
					</div>
				</c:if> <form:form method="POST" action="${contextPath}/attendance"
					class="form-signin">
					<div class="card text-center" style="max-width: 500px">
						<div class="card-header">Attendance Login</div>
						<div class="card-body marginAutoLR">
							<%-- 							<form:input path="login" type="hidden" /> --%>
							<%-- 							<form:input path="userId" type="hidden" /> --%>
							<button type="submit" class="btn btn-primary btn-block btn-width">
								<strong>${attendance.login==0 ? "Login" : "Logout"}</strong>
							</button>
						</div>
						<p style="text-align: center;">
							<a href="${contextPath}/report" style="text-decoration: none;">View
								Report</a> &nbsp;|&nbsp; <a id="a_ins" href="#"
								style="text-decoration: none;">Instructions</a>
						</p>
					</div>
					<input type="hidden" name="${_csrf.parameterName}"
						value="${_csrf.token}" />
				</form:form></td>
		</tr>
		<c:if test="${not empty showComments}">
		<tr>
			<td><form:form method="POST"
					action="${contextPath}/attendance/Comments" id="commentsForm" class="form-group">
					<div class="form-group">
						<label for="Comments">Comments</label>
						<textarea class="form-control" name="Comments" rows="3"></textarea>
						<button type="submit" class="btn float-right"
							style="margin-top: 5px;">
							<strong>Submit</strong>
						</button>
					</div>
					<input type="hidden" name="${_csrf.parameterName}"
						value="${_csrf.token}" />
				</form:form></td>
		</tr>
</c:if>
	</table>
	<!-- 		<div class="row justify-content-md-center"> -->
	<!-- 			<div class="col" style="text-align: center;"></div> -->
	<!-- 		</div> -->

</div>




<!--/.Panel-->
