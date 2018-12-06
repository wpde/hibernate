package demo1;

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
		configuration.addResource("demo1/Customer.hbm.xml");
		//2.创建sessionFactory对象，类似JDBC中连接池
		SessionFactory sessionFactory = configuration.buildSessionFactory();
		//3.通过sessionFactory对象获取session，类似于JDBC中的Connection
		Session session = sessionFactory.openSession();
		//4.手动开启事无
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
}
