package dao;

import java.util.List;

import pogo.Department;
import pogo.Employee;

public interface EmpolyeeDao {
	
//	3.2 List emp id , first name , last name , salary for all permanent emps
//
//	3.3 Transfer emp to a new department n salary raise, having specified first name n last name
//
//	3.4 Delete all temporary employees
	
	 String addEmpDetails(Employee newEmp);
	 
	 List<Employee> getAllDetailsBySpecificSal(Department dept, double SpecificSal);
	 
	 List<Employee> getAllDetailsOfPermanentEmps();
}
