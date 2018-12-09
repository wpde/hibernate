package demo2;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.junit.Test;

/**  
* @Description: TODO(������һ�仰��������������)  
* @author cofe  
* @date 2018��12��9��  
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
		customer.setCust_name("�������ɲ���");
		customer.setCust_mobile("12321");
		session.save(customer);
		ts.commit();
	}
	
}
