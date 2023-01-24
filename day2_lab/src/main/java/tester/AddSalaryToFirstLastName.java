package tester;

import static utils.HibernateUtils.getFactory;

import java.time.LocalDate;
import java.util.Scanner;

import org.hibernate.SessionFactory;

import dao.EmployeeDoaImpl;
import dao.EmpolyeeDao;
import pogo.Department;
import pogo.Employee;

public class AddSalaryToFirstLastName {

	public static void main(String[] args) {
		try (Scanner sc = new Scanner(System.in); SessionFactory sf = getFactory()) {
			System.out.println("firstName,  lastName and salary to add");
			EmpolyeeDao empDao = new EmployeeDoaImpl();
			System.out.println(empDao.addSalary(sc.next(),sc.next(),sc.nextDouble()));
			
		} catch (Exception e) {
			e.printStackTrace();

		}

	}
}
