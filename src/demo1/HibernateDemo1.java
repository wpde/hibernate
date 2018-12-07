package demo1;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.junit.Test;

/**  
* @Description: TODO(������һ�仰��������������)  
* @author cofe  
* @date 2018��12��6��  
*    
*/
public class HibernateDemo1 {
	
	@Test
	public void demo01() {
		//1.����hiebrnate���������ļ�
		Configuration configuration = new Configuration().configure();
//		configuration.addResource("demo1/Customer.hbm.xml");
		//2.����sessionFactory��������JDBC�����ӳ�
		SessionFactory sessionFactory = configuration.buildSessionFactory();
		//3.ͨ��sessionFactory�����ȡsession��������JDBC�е�Connection
		Session session = sessionFactory.openSession();
		//4.�ֶ���������
		Transaction ts = session.beginTransaction();
		//5.��д����
		Customer customer=new Customer();
		customer.setCust_name("hello hibrenate");
		session.save(customer);
		//6.�ύ
		ts.commit();
		//7.�ر�����
		session.close();
	}
	
	/**
	 * get������load��������
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
	 * �޸Ļ��߱���
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
	 * ɾ��
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
