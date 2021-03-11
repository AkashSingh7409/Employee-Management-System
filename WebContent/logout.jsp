<%
  session.removeAttribute("email");
  session.invalidate();
  response.sendRedirect("index.jsp");
%>  
