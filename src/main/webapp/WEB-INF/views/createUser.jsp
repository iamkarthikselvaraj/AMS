<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="contextPath" value="${pageContext.request.contextPath}"/>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
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

<title>Attendance</title>
</head>
<body>
	<div class="container">
	<div class="row">
		<form method="POST" action="${contextPath}/createUser">
			<div class="col-md-12">
			    <div class="row">
		  			<div class="form-group col-md-6">
		  				<label for="exampleInputUsername">Username</label>
				    	<input type="text" class="form-control" id="emp_code" placeholder="" disabled>
			  		</div>
			  		<div class="form-group col-md-6">
				    	<label for="name">Employee Name</label>
				    	<input type="text" class="form-control" name="name" placeholder=" Enter Employee Name">
				  	</div>	
				  	<div class="form-group col-md-6">
				    	<label for="father_name">Father/Husband Name</label>
				    	<input type="text" class="form-control" name="father_name" placeholder=" Enter Father/Husband Name no.">
		  			</div>
		  			<div class="form-group col-md-6">
				    	<label for="email">Email</label>
				    	<input type="text" class="form-control" id="email" name="email" placeholder=" Enter Email">
		  			</div>
		  		</div>
	  			  			<div class="form-group">
			    	<label for="present_address">Present Address</label>
			    	<textarea  class="form-control" name="present_address" placeholder="Present Address"></textarea>
	  			</div>
	  			<div class="form-group">
			    	<label for="permanent_address">Permanent Address</label>
			    	<textarea  class="form-control" name="permanent_address" placeholder="Permanent Address"></textarea>
	  			</div>
	  			
	  			<div class="row">
		  			
		  			<div class="form-group col-md-6">
				    	<label for="mobile">Mobile Number</label>
				    	<input type="text" class="form-control" name="mobile" placeholder=" Enter Mobile no.">
		  			</div>
		  			<div class="form-group col-md-6">
				    	<label for="telephone">Designation</label>
				    	<select class="form-control">
				    	    <option>--Select Designation--</option>
				    	    <option>--Select Designation--</option>
				    	    <option>--Select Designation--</option>
				    	</select>
		  			</div>
		  					  			<div class="form-group col-md-6">
				    	<label for="telephone">Gender</label>
				    	<select class="form-control">
				    	    <option>--Select Gender--</option>
				    	    <option>Male</option>
				    	    <option>Female</option>
				    	</select>
		  			</div>
		  			<div class="form-group col-md-6">
				    	<label for="telephone">DOJ</label>
				    	<input type="date" class="form-control" name="doj" placeholder=" Enter DOJ">
		  			</div>
		  			<div class="form-group col-md-6">
				    	<label for="telephone">DOB</label>
				    	<input type="date" class="form-control" name="dob" placeholder=" Enter DOB">
		  			</div>
		  					  		</div>
	  			
	  			
	  		</div>
	  		   	  			
    	  			<button type="submit" class="btn btn-default col-md-12 submit">Create Employee</button>
	  			
		</form>
	</div>
</div>

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