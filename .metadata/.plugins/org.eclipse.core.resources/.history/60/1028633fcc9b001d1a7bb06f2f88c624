package dao;

import static utils.HibernateUtils.getFactory;

import org.hibernate.*;

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
    
}
