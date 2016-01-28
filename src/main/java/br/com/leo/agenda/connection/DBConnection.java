package br.com.leo.agenda.connection;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class DBConnection {

	private static SessionFactory sessionFactory = buildSessionFactory();

	private static SessionFactory buildSessionFactory(){
		try{
			return new Configuration().configure("hibernate.cfg.xml").buildSessionFactory();
		}catch(Throwable e){
			throw new ExceptionInInitializerError(e);
		}
	}

	public static SessionFactory getSessionFactory(){
		return sessionFactory;
	}
	
}