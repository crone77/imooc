package entity;


import java.util.Date;


import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;
import org.hibernate.tool.hbm2ddl.SchemaExport;
import org.junit.Test;


public class TestStudents {
	@Test
	public void testSchemaExport() {
		//�������ö���
		Configuration config=new Configuration().configure();
		//��������ע�����
		ServiceRegistry serviceRegistry = new ServiceRegistryBuilder()  
        .applySettings(config.getProperties())  
        .buildServiceRegistry(); 
		//����sessionFactory
		SessionFactory sessionFactory=config.buildSessionFactory(serviceRegistry);
		//����session����
		Session session=sessionFactory.getCurrentSession();
		//����SchemaExport
		SchemaExport export=new SchemaExport(config);
		
		export.create(true, true);
	}
	
	//��Ӳ�������
	@Test
	
	public void testSaveStudents(){
		//�������ö���
		Configuration config=new Configuration().configure();
		//��������ע�����
		ServiceRegistry serviceRegistry = new ServiceRegistryBuilder()  
        .applySettings(config.getProperties())  
        .buildServiceRegistry(); 
		//����sessionFactory
		SessionFactory sessionFactory=config.buildSessionFactory(serviceRegistry);
		//����session����
		Session session=sessionFactory.getCurrentSession();
		//�����������
		Transaction tx=session.beginTransaction();
		Students s1=new Students("S0000001", "��è", "male", new Date(), "�人");
		Students s2=new Students("S0000002", "ɽè", "male", new Date(), "����");
		
		session.save(s1);
		session.save(s2);
		tx.commit();
		sessionFactory.close();
	}
	
	
	
	
	
	
	
	
	
	
	
	
}
