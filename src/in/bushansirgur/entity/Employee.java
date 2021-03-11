package in.bushansirgur.entity;

import java.sql.Date;

public class Employee {
	
	// Define the fields
	private Integer id;
	
	private String name;
	
	private String department;
	
	private String dob;

	// Generate setters and getters [Alt + Shift + S]
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDepartment() {
		return department;
	}

	public void setDepartment(String department) {
		this.department = department;
	}

	public String getDob() {
		return dob;
	}

	public void setDob(String dob) {
		this.dob = dob;
	}
	
	// Generate toString() [Alt + Shift + S]
	@Override
	public String toString() {
		return "Employee [id=" + id + ", name=" + name + ", department=" + department + ", dob=" + dob + ", getId()="
				+ getId() + ", getName()=" + getName() + ", getDepartment()=" + getDepartment() + ", getDob()="
				+ getDob() + ", getClass()=" + getClass() + ", hashCode()=" + hashCode() + ", toString()="
				+ super.toString() + "]";
	}
} 

