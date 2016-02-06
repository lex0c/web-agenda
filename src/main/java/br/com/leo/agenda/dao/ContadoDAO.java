package br.com.leo.agenda.dao;

import org.hibernate.Session;
import org.hibernate.Transaction;

import br.com.leo.agenda.connection.DBConnection;
import br.com.leo.agenda.entity.Contato;

public class ContadoDAO {

	public boolean save(Contato c){
		Session session = DBConnection.getSessionFactory().openSession();
		Transaction transaction = null;
		try{
			transaction = session.beginTransaction();
			session.save(c);
			transaction.commit();
			return true;
		}catch(RuntimeException e){
			if(transaction != null){
				transaction.rollback();
				return false;
			}
			throw e;
		}finally{
			session.close();
		}
	}

	
	
}