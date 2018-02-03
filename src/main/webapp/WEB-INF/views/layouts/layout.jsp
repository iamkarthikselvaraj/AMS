<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page isELIgnored="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<c:set var="contextPath" value="${pageContext.request.contextPath}" />
<html>
<head>
<!--  Required meta tags -->
<meta charset="utf-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">
<meta name="_csrf" content="${_csrf.token}" />
<!-- default header name is X-CSRF-TOKEN -->
<meta name="_csrf_header" content="${_csrf.headerName}" />
<!-- ... -->
<!-- Bootstrap CSS -->
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-beta.3/css/bootstrap.min.css">
<%-- 	   <link href="${contextPath}/resources/css/common.css" rel="stylesheet"> --%>
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
<title><tiles:getAsString name="title" /></title>


</head>

<body>
	<header id="header">
		<tiles:insertAttribute name="header" />
	</header>

	<section id="site-content">
		<tiles:insertAttribute name="body" />
	</section>

	<!-- Optional JavaScript -->
	<!-- jQuery first, then Popper.js, then Bootstrap JS -->
	<script src="https://code.jquery.com/jquery-3.2.1.slim.min.js"></script>
	<script
		src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js"></script>
	<script
		src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-beta.3/js/bootstrap.min.js"></script>

	<!-- JQuery for validation  -->
	<%-- 	<script src="${contextPath}/resources/js/jquery-3.3.1.min"></script> --%>
	<script
		src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
	<script src="${contextPath}/resources/js/jquery.validate.js"></script>
	<!-- 	Custom JQuery -->
	<script src="${contextPath}/resources/js/validation.js">
		
	</script>
	<script src="${contextPath}/resources/js/effects.js">
		
	</script>

	<!-- 	javascript action -->
	<script src="${contextPath}/resources/js/action.js">
		
	</script>

</body>
</html>