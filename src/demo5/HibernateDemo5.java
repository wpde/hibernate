package demo5;

import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.junit.Test;

/**  
* @Description: 测试
* @author cofe  
* @date 2018年1月8日  
*    
*/
public class HibernateDemo5 {
	
	
	/**
	 * 
	 * subclass :
	 * 		父类和子类存在同一张表中，其中的role字段是辨别者列，
	 * 		用于辨别这条记录是父类还是子类
	 * join-subclass :
	 * 		父类表存储父类字段，子类表存储子类字段，虽然没有了
	 * 		辨别者列，但是额外增加了一个person_id来表示二者的关系
	 * 
	 * union-subclass 
	 * 		父类表存储父类字段，而子类表既要存储父类字段，也要存储子类字段 
	 * 
	 */
	@Test
	public void Test1() {
		Session session = new Configuration().configure()
				.buildSessionFactory().openSession();
		Transaction ts = session.beginTransaction();
		for(int i=0;i<2;i++) {
			Person p=new Person();
			p.setName("普通人"+i);
			p.setAge(i+1);
			session.save(p);
			Worker w=new Worker();
			w.setAge(30);
			w.setName("工人"+i);
			w.setJob("java");
			w.setUnit(""+i);
			session.save(w);
		}
		ts.commit();
		session.close();
	}
	
	@Test
	public void Test2() {
		Session session = new Configuration().configure()
				.buildSessionFactory().openSession();
		Transaction ts = session.beginTransaction();
		Query query = session.createQuery("from Person");
		List<Person> list = query.list();
		for (Person object : list) {
			System.out.println(object.getId()+object.getName());
		}
	}
}