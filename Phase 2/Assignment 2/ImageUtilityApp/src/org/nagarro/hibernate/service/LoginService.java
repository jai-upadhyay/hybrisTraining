package org.nagarro.hibernate.service;

import java.util.List;

import org.hibernate.*;
import org.hibernate.query.Query;
import org.nagarro.hibernate.entity.Users;

public class LoginService {
	private DatabaseService dbservice = null;
	private Transaction tx = null;
	private Session session = null;
	
	public LoginService() {
		dbservice = new DatabaseService();
		session = dbservice.getSession();
	}
	
	private List<Users> GetAllUsers(){
		try {
			tx = session.beginTransaction();
			String hql = "FROM Users";
			Query q = session.createQuery(hql,Users.class);
			List<Users> results  = q.list();
			tx.commit();
			return results;
	      } catch (HibernateException e) {
	         if (tx!=null) tx.rollback();
	         e.printStackTrace(); 
	      } finally {
//	         dbservice.close(); 
	      }
		return null;
	}
	

	public Users authenticate(String username, String password) {
		if(password == null|| password.trim() == "") {
			return null;
		}
		Users foundUser = null;
		System.out.println("passowrd: "+ password);
		for(Users user : GetAllUsers()) {
			if(user.getUsername().equalsIgnoreCase(username) && user.getPassword().equals(password)) {
				foundUser = user;
				System.out.println("User is authenticated");
				break;
			}
		}
		
		return foundUser;
	}
}
