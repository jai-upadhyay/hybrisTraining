/**
 * 
 */
package org.nagarro.hibernate.service;

	


import org.hibernate.*;
import org.hibernate.cfg.Configuration;
import org.nagarro.hibernate.entity.Images;
import org.nagarro.hibernate.entity.Users;

/**
 * @author jaiupadhyay
 *
 */
public class DatabaseService {

	
	private SessionFactory factory;
	private Session session = null;
	
	public DatabaseService() {
		
		try{
			factory = new Configuration()
						.configure("hibernate.cfg.xml")
						.addAnnotatedClass(Images.class)
						.addAnnotatedClass(Users.class)
						.buildSessionFactory();
			
		}catch(Exception e) {
			e.printStackTrace();
		}
	}	
	
	public Session getSession() {
		return factory.openSession();
	}
	public void close() {
		session.close();
	}	
}
