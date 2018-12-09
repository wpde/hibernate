package demo2;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.junit.Test;

/**  
* @Description: TODO(这里用一句话描述这个类的作用)  
* @author cofe  
* @date 2018年12月9日  
*    
*/
public class HibernateDemo2 {
	
	@Test
	public void test1() {
		Session session = new Configuration().configure().buildSessionFactory().openSession();
		Customer customer = session.get(Customer.class, new Long(1));
		System.out.println(customer);
	}
	
	@Test
	public void test2() {
		Session session = new Configuration().configure().buildSessionFactory().openSession();
		Transaction ts = session.beginTransaction();
		Customer customer = new Customer();
		customer.setCust_name("主键生成策略");
		customer.setCust_mobile("12321");
		session.save(customer);
		ts.commit();
	}
	
}
