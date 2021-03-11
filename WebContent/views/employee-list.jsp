<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix = "c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<link href="https://unpkg.com/bootstrap@4.3.1/dist/css/bootstrap.min.css" rel="stylesheet" />
<link rel="stylesheet" type="text/css" href="https://cdn.datatables.net/v/bs4/dt-1.10.22/datatables.min.css"/>
</head>
<body>

  <h1 style="text-align:center">Employee Management System</h1>
  <hr>
    
  <%
     String email = (String)session.getAttribute("email");
     if(email == null) {
    	 response.sendRedirect("index.jsp");
     }
  %>
   
  <div class="container">
	  <div class = "float-right">
	  <br>
	    <a href = "${pageContext.request.contextPath}/logout.jsp"><u><b>Logout</b></u></a>
	  </div>
  <p>${message}</p>
  <button class="btn btn-primary" onclick="window.location.href='views/employee-add.jsp'">Add Employee</button>
  <br/>
  <br>
  <table border = "1" class="table table-striped table-bordered" id="datatable">
  
     <thead>
        <tr class="thead-dark">
         <th>Name</th>
         <th>Department</th>
         <th>Date Of Birth</th>
         <th>Actions</th>
       </tr>
     </thead>
     <tbody>
        <c:forEach items = "${list}" var = "employee">
         <tr>
             <td>${employee.name}</td>
             <td>${employee.department}</td>
             <td>${employee.dob}</td>
             <td>
                 <a href = "${pageContext.request.contextPath}/EmployeeController?action=EDIT&id=${employee.id}">EDIT | </a>
                 <a href = "${pageContext.request.contextPath}/EmployeeController?action=DELETE&id=${employee.id}">DELETE</a>
             </td>
         </tr>
        </c:forEach>
     </tbody>
    </table>
  </div>
  <script src="https://unpkg.com/jquery@3.3.1/dist/jquery.min.js"></script>
  <script type="text/javascript" src="https://cdn.datatables.net/v/bs4/dt-1.10.22/datatables.min.js"></script>
  <script>
     $(document).ready(function(){
    	 $("#datatable").DataTable();
     })
  </script>
  
</body>
</html>


