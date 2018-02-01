<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<c:set var="contextPath" value="${pageContext.request.contextPath}" />
<!--Panel-->
<form:form modelAttribute="attendance" method="POST"
	action="${contextPath}/attendance" class="form-signin">
	<div class="container-fluid">

		<table class="" style="width: 100%; height: 85%;">
			<tr>
				<td align="center">
					<div class="card text-center" style="max-width: 500px">
						<div class="card-header">Attendance Login</div>
						<div class="card-body marginAutoLR">
							<form:input path="login" type="hidden" />
							<form:input path="userId" type="hidden" />
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
				</td>
			</tr>
		</table>
		<div class="row justify-content-md-center">
			<div class="col" style="text-align: center;"></div>
		</div>
	</div>
	<input type="hidden" name="${_csrf.parameterName}"
		value="${_csrf.token}" />
</form:form>
<!--/.Panel-->
