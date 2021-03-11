package in.bushansirgur.controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import in.bushansirgur.dao.EmployeeDAO;
import in.bushansirgur.dao.EmployeeDAOImpl;
import in.bushansirgur.entity.Employee;
import in.bushansirgur.util.DBConnectionUtil;

public class EmployeeController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	RequestDispatcher dispatcher = null;
	
	//Create a reference variable for employee DAO
	EmployeeDAO employeeDAO = null;
	
	//Create constructor and initialize employee DAO
    public EmployeeController( ) {
    	  employeeDAO = new EmployeeDAOImpl();
    }
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String action = request.getParameter("action");
		
		if(action == null) {
			action = "LIST";
		}
		
		switch(action) {
		 case "LIST":
		   listEmployees(request, response);
		   break;
		 case "EDIT":
		   getSingleEmployee(request, response);
		   break;
		 case "DELETE":
		   deleteEmoployee(request, response);
		   break;
		 default:
		   listEmployees(request, response);
		   break;
		}
	}

	
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		 String id = request.getParameter("id");
		 String name = request.getParameter("firstname");
		 String dob = request.getParameter("dob");
		 String department = request.getParameter("department");
			
		  Employee e = new Employee(); 
		  e.setName(name); 
		  e.setDepartment(department);
		  e.setDob(dob);
		  
		  if(id.isEmpty() || id == null) {
			  //save operation
			  if(employeeDAO.save(e)) { 
			      request.setAttribute("message", "Saved Successfully!"); 
			      }
		  }else {
			  //update operation
			  e.setId(Integer.parseInt(id));
			  if(employeeDAO.update(e)) { 
			      request.setAttribute("message", "Updated Successfully!"); 
			      }
		  }
		  listEmployees(request, response);
	}
	
	public void listEmployees(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//Call DAO method to get list of employees
		List<Employee> list = employeeDAO.get();
		
		//Add the employee to request object
		request.setAttribute("list",list);
		
		//Get the request dispatcher
	    dispatcher = request.getRequestDispatcher("/views/employee-list.jsp");
		
		//Forward the request and response objects
		dispatcher.forward(request, response);
	}
	
	public void getSingleEmployee(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String id = request.getParameter("id");
		//System.out.println("id: "+id);
		Employee employee = employeeDAO.get(Integer.parseInt(id));
		request.setAttribute("employee", employee);
		
		//Get the request dispatcher
	    dispatcher = request.getRequestDispatcher("/views/employee-add.jsp");
		
		//Forward the request and response objects
		dispatcher.forward(request, response);
	}
	
	public void deleteEmoployee(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String id = request.getParameter("id");
		//System.out.println("Employee id: "+id);
		if(employeeDAO.delete(Integer.parseInt(id))) {
			request.setAttribute("message", "Record has been deleted!");
		}
		listEmployees(request, response);
	}
	
	
}




