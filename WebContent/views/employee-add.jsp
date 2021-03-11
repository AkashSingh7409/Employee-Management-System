<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Edit Employee</title>
</head>
<link href="https://unpkg.com/bootstrap@4.3.1/dist/css/bootstrap.min.css" rel="stylesheet" />
<body>
<div class="container">
<div class = "float-right">
<br>
<a href = "${pageContext.request.contextPath}/logout.jsp"><u><b>Logout</b></u></a>
</div>
<h1>Add a new Employee</h1>
<hr>
<br/>
   
   <div class="row">
   <div class="col-md-4">
  <form action="${pageContext.request.contextPath}/EmployeeController" method="Post">
   <div class="form-group">
      <input type="text" name="firstname" value="${employee.name}" placeholder="Enter Employee Name" class="form-control"/><br/>
   </div>
   <div class="form-group">
      <input type="date" name="dob" value="${employee.dob}" placeholder="Enter Employee DOB" class="form-control"/><br/>   
   </div>
   <div class="form-group">
      <input type="text" name="department" value="${employee.department}" placeholder="Enter Employee Department" class="form-control"/><br/>
   </div>
     <input type = "hidden" value = "${employee.id}" name="id"/> <!-- this condition is used for update operation for same button -->
     <button class="btn btn-primary" type="submit">Save Employee</button>
   </form>
   </div>
   </div>
     
</div>
</body>
</html>