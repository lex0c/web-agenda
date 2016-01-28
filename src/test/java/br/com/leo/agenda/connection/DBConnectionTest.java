package br.com.leo.agenda.connection;

import org.hibernate.Session;
import org.junit.Test;

public class DBConnectionTest {

	@Test
	public void testConnection(){
		Session session = DBConnection.getSessionFactory().openSession();
		session.close();
		DBConnection.getSessionFactory().close();
	}
	
}