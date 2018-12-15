package com.scp.java.config;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SeesionFactoryUtil {
public static SessionFactory sessionFactory=null; 
public static ApplicationContext context=new ClassPathXmlApplicationContext("mysql.xml"); 
public static SessionFactory getSessionFactory(){
	if(sessionFactory == null){
		System.out.println("Creating new Sessionfactory....!");
		
		sessionFactory = (SessionFactory)context.getBean("sessionFactory");
	}
	System.out.println(sessionFactory);
	return sessionFactory;
}
	public static void resourceCleanUp(Session session, Transaction tr) {
		if(session!=null){
			session.flush();
			if(tr!=null)
				tr.commit();
			session.close();
		}
			
	}
	
	
	
}

