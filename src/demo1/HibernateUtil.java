package demo1;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

/**  
* @Description: TODO(hibernate连接工具)  
* @author cofe  
* @date 2018年12月7日  
*    
*/
public class HibernateUtil {
	public static final Configuration cfg;
	public static final SessionFactory sessionFactory;
	static {
		cfg = new Configuration().configure();
		sessionFactory = cfg.buildSessionFactory();
	}
	
	public static Session openSession() {
		return sessionFactory.openSession();
	}
	
}
