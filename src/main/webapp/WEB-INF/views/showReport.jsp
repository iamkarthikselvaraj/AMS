<!DOCTYPE html>
<c:set var="contextPath" value="${pageContext.request.contextPath}" />
<html>
<head>
	<meta charset="utf-8" />
	<title>Spring Boot + JPA + Datatables</title>
	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>
	<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
	<link rel="stylesheet" href="https://cdn.datatables.net/1.10.12/css/jquery.dataTables.min.css">
	<script src="https://cdn.datatables.net/1.10.12/js/jquery.dataTables.min.js"></script>
	<script src="${contextPath}/resources/js/datatable.js"></script>
</head>
<body>
	<h1>Employees Table</h1>
	<table id="employeesTable" class="display">
      
       <!-- Header Table -->
       <thead>
            <tr>
                <th>Id</th>
				<th>Day</th>
                <th>workedHours</th>
                          </tr>
        </thead>
        <!-- Footer Table -->
        <tfoot>
            <tr>
               <th>Id</th>
				<th>Day</th>
                <th>workedHours</th>
              
            </tr>
        </tfoot>
    </table>
    
</body>
</html>