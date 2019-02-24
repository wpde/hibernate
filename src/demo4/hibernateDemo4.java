package demo4;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.criterion.Restrictions;
import org.junit.Test;

import demo3.Customer;
import demo3.LinkMan;

/**  
* @Description: TODO(������һ�仰��������������)  
* @author cofe  
* @date 2018��12��16��  
*    
*/
public class hibernateDemo4 {
	
//	���󵼺�����
	@Test
	public void test1() {
		Session session = new Configuration().configure().buildSessionFactory().openSession();
		Customer customer = session.get(Customer.class, 1l);
		System.out.println(customer.getLinkMans());
		session.close();
	}
	
	@Test
	public void test2() {
		Session session = new Configuration().configure().buildSessionFactory().openSession();
		Transaction ts = session.beginTransaction();
		Customer customer=new Customer();
		customer.setCust_name("HQL");
		for(int i=0;i<10;i++) {
			LinkMan linkMan = new LinkMan();
			linkMan.setLkm_name("HQL"+i);
			customer.getLinkMans().add(linkMan);
		}
		session.save(customer);
		ts.commit();
	}
	
//	HQL:��ҳ��ѯlist
	@Test
	public void test3() {
		Session session = new Configuration().configure().buildSessionFactory().openSession();
		Transaction ts = session.beginTransaction();
		Query query = session.createQuery("from LinkMan");
		query.setMaxResults(10);
		query.setFetchSize(10);
		List<LinkMan> list = query.list();
		for (LinkMan linkMan : list) {
			System.out.println(linkMan);
		}
	}
	
//	QBC:Criteria����
	@Test
	public void test4() {
		Session session = new Configuration().configure().buildSessionFactory().openSession();
		Criteria criteria = session.createCriteria(Customer.class);
		criteria.add(Restrictions.like("cust_name", "many%"));
		List<Customer> list = criteria.list();
		for (Customer cus : list) {
			System.out.println(cus.getCust_id());
		}
	}
}
