package org.nagarro.hibernate.service;
import java.io.InputStream;
import java.sql.Blob;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.nagarro.hibernate.entity.Images;

public class ProcessImage {
	DatabaseService dbs = null;
	Transaction tx = null;
	Session session = null;
	public ProcessImage() {
		dbs = new DatabaseService();
	}

	public boolean InsertImage(Images image) {		
		try {
			session = dbs.getSession();
			tx = session.beginTransaction();
			session.save(image);
			tx.commit();
			return true;
		} catch (HibernateException e) {
			// TODO: handle exception
			if(tx!=null) tx.rollback();
			e.printStackTrace();
		}
		return false;
	}
	
	public List<Images> GetImages() {
		List<Images> imagesList = null;
		try {
			
			session = dbs.getSession();
			tx = session.beginTransaction();
			String hql = "FROM Images";		 
			List<Images> images = session.createQuery(hql).getResultList();
			imagesList = new ArrayList<Images>();
			tx.commit();
			return images;
		} catch (Exception e) {
			// TODO: handle exception
			if(tx!=null)tx.rollback();
			e.printStackTrace();
			System.out.println(e.getStackTrace());
		}
		return null;
	}
}
