package com.icoundoul.icostore.sime.dao.spring.hibernate;

import java.util.List;


import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.stereotype.Repository;

import com.icoundoul.icostore.sime.dao.ICategoryDao;
import com.icoundoul.icostore.sime.model.Category;

@Repository("hibernateNonIntrusiveCategoryDao")
public class HibernateNonIntrusiveCategoryDao implements ICategoryDao{

	private SessionFactory sessionFactory;

	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	public void saveCategory(Category category) {
		
		// Ouverture Session
		Session session =  sessionFactory.openSession();
		
		// Ouverture de la tarnsaction
		Transaction tx = session.beginTransaction();
		
		//session.saveOrUpdate(category);
		session.save(category);
		
		// Fermeture de la transaction
		tx.commit();
		
		// Fermeture de la session
		session.close();
	}

	public Category getCaretgoryById(int id) {
		Session session = sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		
		List<Category> results = session.createQuery("from Category where id =" +id).list();
		
		tx.commit();
		
		return (results!=null) ? results.get(0): null;
	}

	public Category getCaretgoryByName(String name) {
		Session session = sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		
		List<Category> results = session.createQuery("from Category where name LIKE '%" + name + "%'").list();
		
		tx.commit();
		
		return (results!=null) ? results.get(0): null;
	}

	public List<Category> getAllCategories() {

		Session session = sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		
		List<Category> results = session.createQuery("from Category").list();
		
		tx.commit();
		
		return results;
	}
	
	
	
}
