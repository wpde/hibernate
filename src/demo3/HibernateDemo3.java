package demo3;

import java.util.HashSet;
import java.util.Set;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.junit.Test;

/**  
* @Description: TODO(������һ�仰��������������)  
* @author cofe  
* @date 2018��12��15��  
*    
*/
public class HibernateDemo3 {
	
	@Test
	public void Test1() {
		Session session = new Configuration().configure()
				.buildSessionFactory().openSession();
		Transaction ts = session.beginTransaction();
		Customer customer=new Customer();
		customer.setCust_name("one-1");
		
		LinkMan l1=new LinkMan();
		l1.setLkm_name("many-1");
		l1.setCustomer(customer);
		LinkMan l2=new LinkMan();
		l2.setLkm_name("many-2");
		l2.setCustomer(customer);
		customer.getLinkMans().add(l1);
		customer.getLinkMans().add(l2);
		session.save(l1);
		session.save(l2);
		session.save(customer);
		
		ts.commit();
	}
	
	
//	ֻ����һ��һ��
	@Test
	public void Test2() {
		Session session = new Configuration().configure()
				.buildSessionFactory().openSession();
		Transaction ts = session.beginTransaction();
		Customer customer=new Customer();
		customer.setCust_name("one-2");
		
		LinkMan l1=new LinkMan();
		l1.setLkm_name("many-3");
		l1.setCustomer(customer);
		LinkMan l2=new LinkMan();
		l2.setLkm_name("many-4");
		l2.setCustomer(customer);
		customer.getLinkMans().add(l1);
		customer.getLinkMans().add(l2);
		
//		session.save(l1);
//		session.save(l2);
		session.save(customer);
		
		ts.commit();
	}
	
//	��������������Ҫ��һ������:cascade
	@Test
	public void Test3() {
		Session session = new Configuration().configure()
				.buildSessionFactory().openSession();
		Transaction ts = session.beginTransaction();
		
		Customer customer=new Customer();
		customer.setCust_name("one-2");
		
		LinkMan l1=new LinkMan();
		l1.setLkm_name("many-3");
		l1.setCustomer(customer);
		
		customer.getLinkMans().add(l1);
		
		session.save(customer);
		ts.commit();
	}
	
	@Test
	public void Test4() {
		Session session = new Configuration().configure()
				.buildSessionFactory().openSession();
		Transaction ts = session.beginTransaction();
		Customer customer = session.get(Customer.class, 3l);
		LinkMan linkMan = session.get(LinkMan.class, 2l);
		linkMan.setCustomer(customer);
		customer.getLinkMans().add(linkMan);
		ts.commit();
	}
}
