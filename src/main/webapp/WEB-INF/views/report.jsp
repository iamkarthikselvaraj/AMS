<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="contextPath" value="${pageContext.request.contextPath}" />

<!--Table-->
<div class="container-fluid">
	<table class="table table-bordered">
		<thead>
			<tr>
				<th>#</th>
								<th>Date</th>
				<th>Day</th>
				<th>Time of Login</th>
				<th>Time of Logout</th>
				<th>Worked Hours</th>
<!-- 				<th>Comments</th> -->
				<th>Flag</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach var="report" items="${reports}">
				<tr>
					<th scope="row">${report.id}</th>
					<td>${report.date}</td>
					<td>${report.day}</td>
					<td>${report.timeOfLogin}</td>
					<td>${report.timeOfLogout}</td>
					<td>${report.workedHours}</td>
<%-- 					<td>${report.comments}</td> --%>
					<td>${report.flag}</td>
				</tr>
			</c:forEach>

		</tbody>
	</table>
</div>
<!--/Table-->

