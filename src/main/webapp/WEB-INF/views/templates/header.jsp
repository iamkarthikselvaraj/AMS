<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="contextPath" value="${pageContext.request.contextPath}"/>
<!-- Nav bar -->
	<div class="container-fluid">
		<div class="navbar navbar-expand-lg navbar-light" style="background-color: #f7f7f7;">
		<ul class="navbar-nav mr-auto">
				<li class="nav-item"><a class="nav-link" href="${contextPath}/createUser">Create User</a></li>
				<li class="nav-item"><a class="nav-link" href="${contextPath}/listUsers">List User</a></li>
							</ul>
			<ul class="navbar-nav ml-auto">
				<li class="nav-item"><p class="navbar-text">Welcome</p></li>
				<li class="nav-item dropdown"><a
					class="nav-link dropdown-toggle" href="#" id="navbarDropdown"
					role="button" data-toggle="dropdown" aria-haspopup="true"
					aria-expanded="false"> ${name}</a>
					<div class="dropdown-menu" aria-labelledby="navbarDropdown">
						<a class="dropdown-item" href="#">Logout</a>
					</div></li>
			</ul>
		</div>

	</div>
	<!-- Nav bar -->