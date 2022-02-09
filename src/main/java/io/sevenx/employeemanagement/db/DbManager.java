package main.java.io.sevenx.employeemanagement.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import main.java.io.sevenx.employeemanagement.data.Employee;

public class DbManager {
	static final String url = "jdbc:mysql://localhost:3306/employeedb";
	static final String username = "root";
	static final String password = "";
	// static final String driver = "com.mysql.cj.jdbc.Driver";

	public static Connection getConnection(){
		try {
			// Class.forName(driver);
			Connection conn  = DriverManager.getConnection(url, username, password);
			System.out.println("Database Connected");
			return conn;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	public static void storeData(List<Employee> employeeList) {
		try {
			Statement statement = getConnection().createStatement();
			System.out.println("inside store data 1");
			for (Employee emp: employeeList) {
				statement.execute("INSERT INTO employees('employeeId', 'firstName', 'lastName, 'email', 'baseSalary') VALUES ('" +
				emp.getEmployeeId() + "', '"+emp.getFirstName() + "', '" + emp.getLastName() + "', '" +emp.getEmail()+"', '" + emp.getBaseSalary() + "');");
			}
			getConnection().close();
			System.out.println("inside store data 2");
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}
	
	public static List<Employee> getData() throws SQLException{
		List<Employee> employee = new ArrayList<>();
		Statement statement = getConnection().createStatement();
		ResultSet stmt = statement.executeQuery("SELECT * FROM employees.employee;");
		
		while(stmt.next()) {
			Employee e = new Employee();
			e.setEmployeeId(stmt.getInt(1));
			e.setFirstName(stmt.getString(2));
			e.setLastName(stmt.getString(3));
			e.setBaseSalary(stmt.getInt(4));
			
			employee.add(e);
		}
		getConnection().close();
		return employee;
	}

}
