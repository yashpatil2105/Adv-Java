package dao;

import static utils.HibernateUtils.getFactory;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import pogo.Department;
import pogo.Employee;

public class EmployeeDoaImpl implements EmpolyeeDao {

	@Override
	public String addEmpDetails(Employee newEmp) {
		
		// newEmp : TRANSIENT 
		String mess = "Failed to add emp details...!!!!! ";
		
		//1.
		Session session = getFactory().getCurrentSession();
		//2.
		Transaction tx = session.beginTransaction();
		
		try {
			//Session API: public Serializable save(Object transientObjRef) throws HibernateExc
			Long  empId = (Long) session.save(newEmp);
			// newEmp : PERSISTENT --> entity ref added to L1 Cache 
 			tx.commit();//Hibernate performing dirty Checking --> session.flush()
 			//DML --> insert --> session.close() ==> L1 cache destroyed, 
 			//returns DB cn to DBCP (db connection pool)
 			//==> newEmp : DETACHED (from L1 cache)
 			mess = "Added emp details , ID " + empId;
			
		}catch(RuntimeException e) {
			if(tx != null)
			   tx.rollback();
			throw e;
		}
		
		return mess;
	}

	@Override
	public List<Employee> getAllDetailsBySpecificSal(Department dept,double SpecificSal) {
		
		String jpql = "select e from Employee e where e.dept=:dpt and e.salary>:sal";
		List<Employee> emps = null;
		Session session = getFactory().getCurrentSession();
		Transaction tx = session.beginTransaction();
		try {
			emps = session.createQuery(jpql,Employee.class)
					.setParameter("dpt", dept)
					.setParameter("sal", SpecificSal)
					.getResultList();
			
			tx.commit();
		}catch(RuntimeException e) {
			if(tx != null)
			   tx.rollback();
			throw e;
		}
		return emps;
	}
	

	@Override
	public List<Employee> getAllDetailsOfPermanentEmps() {
		//emp id , first name , last name , salary
		
		String jpql = "select new pogo.Employee(empId,firstName,lastName,salary) from Employee e where e.isPermanent=true";
		List<Employee> emps = null;
		Session session = getFactory().getCurrentSession();
		Transaction tx = session.beginTransaction();
		try {
			tx.commit();
		}catch(RuntimeException e) {
			if(tx != null)
			   tx.rollback();
			throw e;
		}
		return null;
	}
    
}
