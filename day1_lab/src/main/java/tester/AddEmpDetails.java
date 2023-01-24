package tester;

import static utils.HibernateUtils.getFactory;

import java.time.LocalDate;
import java.util.Scanner;

import org.hibernate.SessionFactory;

import dao.EmployeeDoaImpl;
import dao.EmpolyeeDao;
import pogo.Department;
import pogo.Employee;

public class AddEmpDetails {

	public static void main(String[] args) {
		try (Scanner sc = new Scanner(System.in); SessionFactory sf = getFactory()) {
			System.out.println("firstName,  lastName,  dept,  salary,  dob, Permanent");
			Employee emp = new Employee(sc.next(),sc.next(),Department.valueOf(sc.next().toUpperCase()), sc.nextDouble(),LocalDate.parse(sc.next()),sc.nextBoolean());
			EmpolyeeDao empDao = new EmployeeDoaImpl();
			System.out.println(empDao.addEmpDetails(emp));
			
		} catch (Exception e) {
			e.printStackTrace();

		}

	}
}
