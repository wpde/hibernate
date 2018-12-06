package demo1;

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
		configuration.addResource("demo1/Customer.hbm.xml");
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
}
