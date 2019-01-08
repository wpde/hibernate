package demo5;

import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.junit.Test;

/**  
* @Description: ����
* @author cofe  
* @date 2018��1��8��  
*    
*/
public class HibernateDemo5 {
	
	
	/**
	 * 
	 * subclass :
	 * 		������������ͬһ�ű��У����е�role�ֶ��Ǳ�����У�
	 * 		���ڱ��������¼�Ǹ��໹������
	 * join-subclass :
	 * 		�����洢�����ֶΣ������洢�����ֶΣ���Ȼû����
	 * 		������У����Ƕ���������һ��person_id����ʾ���ߵĹ�ϵ
	 * 
	 * union-subclass 
	 * 		�����洢�����ֶΣ���������Ҫ�洢�����ֶΣ�ҲҪ�洢�����ֶ� 
	 * 
	 */
	@Test
	public void Test1() {
		Session session = new Configuration().configure()
				.buildSessionFactory().openSession();
		Transaction ts = session.beginTransaction();
		for(int i=0;i<2;i++) {
			Person p=new Person();
			p.setName("��ͨ��"+i);
			p.setAge(i+1);
			session.save(p);
			Worker w=new Worker();
			w.setAge(30);
			w.setName("����"+i);
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