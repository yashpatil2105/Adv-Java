package tester;

import static utils.HibernateUtils.getFactory;

import java.time.LocalDate;
import java.util.Scanner;

import org.hibernate.SessionFactory;
import org.hibernate.internal.build.AllowSysOut;

import dao.EmployeeDoaImpl;
import dao.EmpolyeeDao;
import pogo.Department;
import pogo.Employee;

public class EmpDetailsDeptSpecificSalary {

	public static void main(String[] args) {
		
		try (Scanner sc = new Scanner(System.in); SessionFactory sf = getFactory()) {
			
			System.out.println("Enter dept,  Specific_salary");
			
			EmpolyeeDao empDao = new EmployeeDoaImpl();
			empDao.getAllDetailsBySpecificSal(
					Department.valueOf(sc.next().toUpperCase()), 
					sc.nextDouble())
			.forEach(System.out::println);
			
		} catch (Exception e) {
			e.printStackTrace();

		}

	}
}
