<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<c:set var="contextPath" value="${pageContext.request.contextPath}" />

<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<!-- The above 3 meta tags *must* come first in the head; any other head content must come *after* these tags -->
<meta name="description" content="">
<meta name="author" content="">

<title>Log in with your account</title>

<link href="${contextPath}/resources/css/bootstrap.min.css"
	rel="stylesheet">
<link href="${contextPath}/resources/css/common.css" rel="stylesheet">

<!-- HTML5 shim and Respond.js for IE8 support of HTML5 elements and media queries -->
<!--[if lt IE 9]>
    <script src="https://oss.maxcdn.com/html5shiv/3.7.2/html5shiv.min.js"></script>
    <script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>
    <![endif]-->


</head>
<body>
	<div class="container" align="center">
		<form method="POST" action="${contextPath}/login" class="form-signin"
			id="loginform">
			<h2 class="form-heading">Log in</h2>
			<div class="form-group ${error != null ? 'has-error' : ''}">
				<span>${message}</span> <input name="username" type="text"
					class="form-control" placeholder="Username" autofocus="true" /> <input
					name="password" type="password" class="form-control"
					placeholder="Password" /> <span>${error}</span>
				<button class="btn btn-lg btn-primary btn-block" type="submit">Log
					In</button>
			</div>
			<input type="hidden" name="${_csrf.parameterName}"
				value="${_csrf.token}" />
		</form>

	</div>

	<!-- /container -->
	<script
		src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.2/jquery.min.js"></script>
	<script src="${contextPath}/resources/js/bootstrap.min.js"></script>
	<!-- JQuery for validation  -->
	<script src="${contextPath}/resources/js/jquery-3.3.1.min"></script>
	<script src="${contextPath}/resources/js/jquery.validate.js"></script>
	<script type="text/javascript">
		$(document).ready(function() {

			$('#loginform').validate({ // initialize the plugin
				rules : {
					username : {
						required : true
					}
				},
				messages : {
					username : {
						required : "Please Enter Your Username"
					}
				}
			}

			);

		});
	</script>



</body>
</html>
