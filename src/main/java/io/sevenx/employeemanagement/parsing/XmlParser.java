package main.java.io.sevenx.employeemanagement.parsing;

import java.io.File;
import java.util.List;

import jakarta.xml.bind.JAXBContext;
import jakarta.xml.bind.JAXBException;
import jakarta.xml.bind.Unmarshaller;
import main.java.io.sevenx.employeemanagement.data.Employee;
import main.java.io.sevenx.employeemanagement.data.EmployeeList;

public class XmlParser {
    public static List<Employee> parse() {
		File file = new File("C:\\Users\\Lenovo\\Desktop\\EmployeeManagement\\src\\main\\resources\\employeeData.xml"); 

		JAXBContext jaxbContext;
		try {
			jaxbContext = JAXBContext.newInstance(EmployeeList.class);

			Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();

			EmployeeList employees = (EmployeeList) jaxbUnmarshaller.unmarshal(file);
			List<Employee> employee = employees.getEmployees();
			System.out.println(employee);

			return employee;
			
		} catch (JAXBException e) {
			e.printStackTrace();
		}
		return null;
	}
}
