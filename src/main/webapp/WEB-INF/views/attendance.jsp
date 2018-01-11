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
<div id="app" class="container-fluid">
    <nav class="navbar navbar-expand-lg navbar-light bg-faded">
        <a class="navbar-brand" href="#">Navbar</a>
        
        <div class="navbar-collapse collapse">
                 <ul class="navbar-nav ml-auto">
                <li class="nav-item dropdown">
                    <a class="nav-link dropdown-toggle" href="http://example.com" id="navbarDropdownMenuLink" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                      Dropdown
                    </a>
                    <div class="dropdown-menu" aria-labelledby="navbarDropdownMenuLink">
                        <a class="dropdown-item" href="#">Action</a>
                        <a class="dropdown-item" href="#">Another action</a>
                    </div>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="{{ url('/login') }}">Login</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="{{ url('/register') }}">Register</a>
                </li>
            </ul>
        </div>
    </nav>
</div>
<!-- Nav bar -->
	<!--Panel-->
	<div class="container-fluid">

		<table class="" style="width: 100%; height: 100%; margin-top: 15%">
			<tr>
				<td align="center">
					<div class="card text-center" style="max-width: 500px">
						<div class="card-header">Attendance Login</div>
						<div class="card-body marginAutoLR">
							<button href="#" class="btn btn-primary btn-block btn-width">
								<strong>Login</strong>
							</button>
						</div>
					</div>
				</td>
			</tr>
		</table>
		<div class="row justify-content-md-center">
			<div class="col" style="text-align: center;"></div>
		</div>
	</div>
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