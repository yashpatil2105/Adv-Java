package utils;
import org.hibernate.*;
import org.hibernate.cfg.Configuration;

public class HibernateUtils {
	
	private static SessionFactory factory;
	
	static {
		System.out.println("in static init block");
		// build singleton, immutable, thread safe SessionFactory
		factory = new Configuration().configure().buildSessionFactory();
		//configure = at that time hibernate.cfg.xml file is loaded.
		
		//<property name="hibernate.hbm2ddl.auto">update</property> ------>
		//-------->   It will check if the table is exist for pogo or not then create it
	}

	public static SessionFactory getFactory() {
		return factory;
	}

}
