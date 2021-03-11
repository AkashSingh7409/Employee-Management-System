package in.bushansirgur.dao;

import java.util.List;

import in.bushansirgur.entity.Employee;

public interface EmployeeDAO {
	
    List<Employee> get();
	
	boolean save(Employee employee);
	
	Employee get(int id);
	
	boolean update(Employee e);
	
	boolean delete(int id);
	
}
