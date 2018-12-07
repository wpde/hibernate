package demo1;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.junit.Test;

/**  
* @Description: TODO(这里用一句话描述这个类的作用)  
* @author cofe  
* @date 2018年12月6日  
*    
*/
public class HibernateDemo1 {
	
	@Test
	public void demo01() {
		//1.加载hiebrnate核心配置文件
		Configuration configuration = new Configuration().configure();
//		configuration.addResource("demo1/Customer.hbm.xml");
		//2.创建sessionFactory对象，类似JDBC中连接池
		SessionFactory sessionFactory = configuration.buildSessionFactory();
		//3.通过sessionFactory对象获取session，类似于JDBC中的Connection
		Session session = sessionFactory.openSession();
		//4.手动开启事务
		Transaction ts = session.beginTransaction();
		//5.编写代码
		Customer customer=new Customer();
		customer.setCust_name("hello hibrenate");
		session.save(customer);
		//6.提交
		ts.commit();
		//7.关闭连接
		session.close();
	}
	
	/**
	 * get方法与load方法区别
	 */
	@Test
	public void demo02() {
		Session session = HibernateUtil.openSession();
//		Customer customer = session.get(Customer.class,1);
		Customer customer = session.get(Customer.class,new Long(1));
		Customer customer2 = session.load(Customer.class,new Long(2));
		System.out.println(customer);
//		System.out.println(customer2);
	}
	
	/**
	 * 修改或者保存
	 */
	@Test
	public void demo03() {
		Session session = HibernateUtil.openSession();
		Transaction ts = session.beginTransaction();
//		Customer customer=session.get(Customer.class,new Long(1));
		Customer customer=new Customer();
		customer.setCust_name("hello git");
		customer.setCust_mobile("123456");
		customer.setCust_level("1");
		session.saveOrUpdate(customer);
		ts.commit();
	}
	
	/**
	 * 删除
	 */
	@Test
	public void demo04() {
		Session session = HibernateUtil.openSession();
		Transaction ts = session.beginTransaction();
//		Customer customer=session.get(Customer.class,new Long(2));
		Customer customer=new Customer();
		customer.setCust_id(new Long(3));
		session.delete(customer);
		ts.commit();
	}
	
	/**
	 * Hql
	 */
	@Test
	public void demo05() {
		Session session = HibernateUtil.openSession();
		Query query = session.createQuery("from Customer");
		List<Customer> list = query.list();
		for (Customer customer : list) {
			System.out.println(customer);
		}
		
		
	}
}
