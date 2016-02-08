package br.com.leo.agenda.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;

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

	public boolean delete(Integer id){
		Session session = DBConnection.getSessionFactory().openSession();
		Transaction transaction = null;
		try{
			transaction = session.beginTransaction();
			session.delete(findById(id));
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
	
	public boolean update(Contato c){
		Session session = DBConnection.getSessionFactory().openSession();
		Transaction transaction = null;
		try{
			transaction = session.beginTransaction();
			session.update(c);
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
	
	@SuppressWarnings("unchecked")
	public List<Contato> listAll(){
		Session session = DBConnection.getSessionFactory().openSession();
		try{
			Criteria result = session.createCriteria(Contato.class);
			return result.list();
		}catch(RuntimeException e){
			throw e;
		}finally{
			session.close();
		}
	}
	
	public Contato findById(Integer id){
		Session session = DBConnection.getSessionFactory().openSession();
		try{
			Criteria result = session.createCriteria(Contato.class);
			result.add(Restrictions.idEq(id));
			return (Contato) result.uniqueResult();
		}catch(RuntimeException e){
			throw e;
		}finally{
			session.close();
		}
	}
	
	public boolean merge(Contato c){
		Session session = DBConnection.getSessionFactory().openSession();
		Transaction transaction = null;
		try{
			transaction = session.beginTransaction();
			session.merge(c);
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