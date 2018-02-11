<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<c:set var="contextPath" value="${pageContext.request.contextPath}" />
<!--Panel-->

<div class="container-fluid auth-form"
	style="max-width: 500px; margin-top: 10%;">
<div class="input-group date" data-provide="datepicker">
    <input type="text" class="form-control">
    <div class="input-group-addon">
        <span class="glyphicon glyphicon-th"></span>
    </div>
</div>
	<c:if test="${not empty msg}">
		<div class="alert alert-${css} alert-dismissible" role="alert">
			<button type="button" class="close" data-dismiss="alert"
				aria-label="Close">
				<span aria-hidden="true">&times;</span>
			</button>
			<strong>${msg}</strong>
		</div>
	</c:if>
	<form:form method="POST" action="${contextPath}/attendance"
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
					Report</a> &nbsp;|&nbsp; <a id="instructionShow" href="#"
					style="text-decoration: none;">Instructions</a>
			</p>
		</div>
		<input type="hidden" name="${_csrf.parameterName}"
			value="${_csrf.token}" />
	</form:form>

	<c:if test="${not empty showComments}">
		<div>
			<form:form method="POST" action="${contextPath}/attendance/Comments"
				id="commentsForm" class="form-group">
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
			</form:form>
		</div>
	</c:if>
<div id="instructions" class="hidden" style="background-color: #f8f9fa;"><ul>
<li><p>Login and Logout is necessary to maintain your attendance report</p></li>
<li><p>Please Login as soon as you come in.</p></li>
<li><p>Login can be done from any system.</p></li>
<li><p>Please do not forget to Logout.</p></li>
<li><p>Logout at the end of your shift.</p></li>
<li><p>If you want to Logout before 9 hours, Supervisor's permission is needed.</p></li>
</ul>
<p style="text-align: center;"><a id="instructionHide" href="#"
					style="text-decoration: none;">Hide Instructions</a></p>
</div>
</div>




<!--/.Panel-->
