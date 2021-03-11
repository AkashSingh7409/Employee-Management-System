package in.bushansirgur.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import in.bushansirgur.dao.LoginDAO;
import in.bushansirgur.dao.LoginImplDAO;
import in.bushansirgur.entity.Login;

public class LoginController extends HttpServlet{
	
	LoginDAO loginDAO = null;
	
	public LoginController() {
		loginDAO = new LoginImplDAO();
	}
	
     @Override
	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
    	 
		 HttpSession session = req.getSession();
    	 Login login = new Login();
		 login.setEmail(req.getParameter("email"));
		 login.setPassword(req.getParameter("password"));
		 
		 String status = loginDAO.authenticate(login);
		 
		 if(status.equals("true")) {
			 session.setAttribute("email", login.getEmail());
			 res.sendRedirect("EmployeeController?action=LIST");
		 }
		 if(status.equals("false")) {
			 res.sendRedirect("index.jsp?status=false");
		 }
		 if(status.equals("error")) {
			 res.sendRedirect("index.jsp?status=error");
		 }
	}
}
