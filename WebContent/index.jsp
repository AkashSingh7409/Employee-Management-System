<%-- <% response.sendRedirect("EmployeeController?action=LIST"); %> --%>
<html>
  <head>
  <title></title>
  <link href="https://unpkg.com/bootstrap@4.3.1/dist/css/bootstrap.min.css" rel="stylesheet" />
  </head>
    <body>
      <br>
      <div class="container">
         <form action="loginprocess" method="post">
       <div class="card">
	       <div class="card-header">
	         Login
	       </div>
	       <div class="card-body">
	         <div class="form-group">
	           <input type="text" name="email" class="form-control" placeholder="Enter Email: "/><br/>
	         </div>
	         <div class="form-group">
	           <input type="password" name="password" class="form-control" placeholder="Enter Password: "/><br/>
	         </div>
	       </div>
	       <div class="card-footer">
	         <input type="submit" value="Login" class="btn btn-primary"/>
	       </div>
       </div>
     </form>
      </div>
      <hr>
      
        <%
         String email = (String)session.getAttribute("email");
         //if user is already logged in redirect it is list employees
         if(email != null) {
        	 response.sendRedirect("EmployeeController?action=LIST");
         }
         String status = request.getParameter("status");
         if(status != null) {
        	if(status.equals("false")) {
        		out.println("Bad Credentials! | Email or Password is Wrong!");
        	}else if(status.equals("error")) {
        		out.println(" Some error occured!");
        	}
         }   
       %>
        </%>
       <hr>
    </body>
</html>

