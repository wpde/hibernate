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
	
//	主键生成策略
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
//	对象状态
	@Test
	public void test3() {
		Session session = new Configuration().configure().buildSessionFactory().openSession();
		Transaction ts = session.beginTransaction();
		Customer customer = session.get(Customer.class, 1l);
		customer.setCust_level("1");
		ts.commit();
		session.close();
	}
	
//	一级缓存
	@Test
	public void test4() {
		Session session = new Configuration().configure().buildSessionFactory().openSession();
		Customer customer = session.get(Customer.class, 1l);
//		clear()：清空一级缓存。
//		evict()：清空一级缓存中指定的某个对象。
//		refresh()：重新查询数据库，用数据库中的信息来更新一级缓存与快照区。
		Customer customer2 = session.get(Customer.class, 1l);
		System.out.println(customer);
		System.out.println(customer2);
		System.out.println(customer2==customer);
		
	}
}
