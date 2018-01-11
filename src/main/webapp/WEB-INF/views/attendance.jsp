<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="contextPath" value="${pageContext.request.contextPath}"/>
<!doctype html>
<html lang="en">
<head>
<!--  Required meta tags -->
<meta charset="utf-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">

<!-- Bootstrap CSS -->
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-beta.3/css/bootstrap.min.css"
	integrity="sha384-Zug+QiDoJOrZ5t4lssLdxGhVrurbmBWopoEl+M6BdEfwnCJZtKxi1KgxUyJq13dy"
	crossorigin="anonymous">
<style>
.card-width {
	width: 500px;
	border-radius: 14px;
	height: 150px;
	text-align: center;
}

.btn-width {
	width: 180px;
	border-radius: 14px;
	text-align: center;
}

.marginAutoLR {
	margin-right: auto;
	margin-left: auto;
	margin-top: auto;
	margin-bottom: auto;
}
</style>
<title>Attendance</title>
</head>
<body>
	<!-- Nav bar -->
	<div class="container-fluid">
		<div class="navbar navbar-expand-lg navbar-light" style="background-color: #f7f7f7;">
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
	<!--Panel-->
	<form method="POST" action="${contextPath}/attendance" class="form-signin">
	<div class="container-fluid">

		<table class="" style="width: 100%; height: 100%; margin-top: 15%">
			<tr>
				<td align="center">
					<div class="card text-center" style="max-width: 500px">
						<div class="card-header">Attendance Login</div>
						<div class="card-body marginAutoLR">
							<button type="submit" href="#" class="btn btn-primary btn-block btn-width">
								<strong>${login_logout}</strong>
							</button>
						</div>
						<p style=" text-align: center;">       
                    <a href="#" style=" text-decoration:none;">View Report</a>
                    &nbsp;|&nbsp;
                    <a id="a_ins" href="#" style="text-decoration:none;">Instructions</a>                  
                </p>
					</div>
				</td>
			</tr>
		</table>
		<div class="row justify-content-md-center">
			<div class="col" style="text-align: center;"></div>
		</div>
	</div>
	</form>
	<!--/.Panel-->

	<!-- Optional JavaScript -->
	<!-- jQuery first, then Popper.js, then Bootstrap JS -->
	<script src="https://code.jquery.com/jquery-3.2.1.slim.min.js"
		integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN"
		crossorigin="anonymous"></script>
	<script
		src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js"
		integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q"
		crossorigin="anonymous"></script>
	<script
		src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-beta.3/js/bootstrap.min.js"
		integrity="sha384-a5N7Y/aK3qNeh15eJKGWxsqtnX/wWdSZSKp+81YjTmS15nvnvxKHuzaWwXHDli+4"
		crossorigin="anonymous"></script>
</body>
</html>