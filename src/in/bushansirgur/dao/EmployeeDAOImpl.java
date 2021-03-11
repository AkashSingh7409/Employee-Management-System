package in.bushansirgur.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import in.bushansirgur.entity.Employee;
import in.bushansirgur.util.DBConnectionUtil;

public class EmployeeDAOImpl implements EmployeeDAO {
	
	Connection connection = null;
	ResultSet resultSet = null;
	Statement statement = null;
	PreparedStatement preparedStatement = null; 
	
	@Override
	public List<Employee> get() {
		
		// Create reference variables
		List<Employee> list = null;
		Employee employee = null;
		
		try {
			
			list = new ArrayList<Employee>();
			
			// Create a sql query
			String sql = "SELECT * FROM tbl_employee";
			
			// Get the database connection
			connection = DBConnectionUtil.openConnection();
			
			// Create a statement
			statement = connection.createStatement();
			
			// Execute the sql query, execute query will pass the statement
			resultSet = statement.executeQuery(sql);
			
			// Process the result set
			while(resultSet.next()) {
				employee = new Employee();
				employee.setId(resultSet.getInt("id"));
				employee.setName(resultSet.getString("name"));
				employee.setDepartment(resultSet.getString("department"));
				employee.setDob(resultSet.getString("dob"));
				
		   // Add employee to list
		   list.add(employee);
		   }
			
		}catch(SQLException e) {
			e.printStackTrace();
		}
		
		// Return the list
		return list;
	}
	
	@Override
	public boolean save(Employee e) {
		boolean flag = false;
		try {
			String sql = "INSERT INTO tbl_employee(name, department, dob)VALUES('"+e.getName()+"', '"+e.getDepartment()+"', '"+e.getDob()+"')";
					
			connection = DBConnectionUtil.openConnection();
			preparedStatement = connection.prepareStatement(sql);
			preparedStatement.executeUpdate();
			flag = true;
		}catch(SQLException ex) {
			ex.printStackTrace();
		}
		return flag;
	}

	@Override
	public Employee get(int id) {
		Employee employee = null;
		try {
			employee = new Employee();
			String sql = "SELECT * FROM tbl_employee WHERE id="+id;
		    connection = DBConnectionUtil.openConnection();
		    statement = connection.createStatement();
		    resultSet = statement.executeQuery(sql);
		    while(resultSet.next()) {
		    	employee.setId(resultSet.getInt("id"));
		    	employee.setName(resultSet.getString("name"));
		    	employee.setDepartment(resultSet.getString("department"));
		    	employee.setDob(resultSet.getString("dob"));
		    }
		}catch(SQLException ex) {
			ex.printStackTrace();
		}
		System.out.println("Employee Name: "+employee.getName()+" Employee DOB: "+employee.getDob()+" Employee Department: "+employee.getDepartment());
		return employee;
	}

	@Override
	public boolean update(Employee e) {
		boolean flag = false;
		try {
			String sql = "UPDATE tbl_employee SET name='"+e.getName()+"', dob='"+e.getDob()+"', department='"+e.getDepartment()+"' where id="+e.getId();
			connection = DBConnectionUtil.openConnection();
			preparedStatement = connection.prepareStatement(sql);
			preparedStatement.executeUpdate();
			flag = true;
		}catch(SQLException ex) {
			ex.printStackTrace();
		}
		return flag;
	}

	@Override
	public boolean delete(int id) {
		boolean flag = false;
		try {
	        String sql = "DELETE FROM tbl_employee WHERE id="+id;
	        preparedStatement = connection.prepareStatement(sql);
	        preparedStatement.executeUpdate();
	        flag = true;
		}catch(SQLException ex) {
			ex.printStackTrace();
		}
		return flag;
	}

}	



