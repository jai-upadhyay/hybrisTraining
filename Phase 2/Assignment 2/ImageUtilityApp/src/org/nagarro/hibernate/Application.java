package org.nagarro.hibernate;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;
import org.nagarro.hibernate.entity.Users;

public class Application {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SessionFactory factory;
		Session session = null;
		try {
		//sessionfactory
		
		factory = new Configuration()
									.configure("hibernate.cfg.xml")
									.addAnnotatedClass(Users.class)
									.buildSessionFactory();
		//session
		
		session = factory.getCurrentSession();
		}catch (Exception e) {
			// TODO: handle exception
			e.getStackTrace();
		}
		Transaction tx = null;
		try {
			tx = session.beginTransaction();
			String hql = "FROM Users";
			Query q = session.createQuery(hql);
			List<Users> results  = q.list();
			for(Users user : results) {
				System.out.println(user);
			}
			   tx.commit();
	      } catch (HibernateException e) {
	         if (tx!=null) tx.rollback();
	         e.printStackTrace(); 
	      } finally {
	         session.close(); 
	      }
		
	}

}
