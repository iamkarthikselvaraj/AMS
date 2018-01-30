<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="security"
  uri="http://www.springframework.org/security/tags" %>
<c:set var="contextPath" value="${pageContext.request.contextPath}" />
<!-- Nav bar -->
<div class="container-fluid">
	<div class="navbar navbar-expand-lg navbar-light"
		style="background-color: #f7f7f7;">
		<ul class="navbar-nav mr-auto">
			<li class="nav-item"><a class="nav-link"
				href="${contextPath}/attendance">Home</a></li>
			<security:authorize access="hasRole('ROLE_FULL')">
				<li class="nav-item"><a class="nav-link"
					href="${contextPath}/createUser">Create User</a></li>
				<li class="nav-item"><a class="nav-link"
					href="${contextPath}/listUsers">List User</a></li>
			</security:authorize>
		</ul>
		<ul class="navbar-nav ml-auto">
			<c:if test="${pageContext.request.userPrincipal.name != null}">
				<form id="logoutForm" method="POST" action="${contextPath}/logout">
					<input type="hidden" name="${_csrf.parameterName}"
						value="${_csrf.token}" />
				</form>
				<li class="nav-item"><p class="navbar-text">Welcome</p></li>
				<li class="nav-item dropdown"><a
					class="nav-link dropdown-toggle" href="#" id="navbarDropdown"
					role="button" data-toggle="dropdown" aria-haspopup="true"
					aria-expanded="false">
						${pageContext.request.userPrincipal.name}</a>
					<div class="dropdown-menu" aria-labelledby="navbarDropdown">
						<a class="dropdown-item"
							onclick="document.forms['logoutForm'].submit()">Logout</a>
					</div></li>
			</c:if>
		</ul>
	</div>

</div>
<!-- Nav bar -->