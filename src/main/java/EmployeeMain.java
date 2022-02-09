package main.java;

import java.sql.SQLException;
import java.util.List;

import main.java.io.sevenx.employeemanagement.data.Employee;
import main.java.io.sevenx.employeemanagement.db.DbManager;
import main.java.io.sevenx.employeemanagement.parsing.XmlParser;
import main.java.io.sevenx.employeemanagement.ui.EmployeeDisplay;

public class EmployeeMain {
    public static void main(String[] args) throws SQLException {

		List<Employee> employees = XmlParser.parse();

		DbManager.storeData(employees);
		System.out.println("Here 2");

		List<Employee> employeeList = DbManager.getData();
		System.out.println("Here 3");
		
		EmployeeDisplay.getInfo(employeeList);

	}
}
