package main.java.io.sevenx.employeemanagement.data;

import java.util.List;

import jakarta.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "employees")
public class EmployeeList {
    private List<Employee> employees;

	public List<Employee> getEmployees() {
		return employees;
	}

	public void setEmployees(List<Employee> employees) {
		this.employees = employees;
	}
}
