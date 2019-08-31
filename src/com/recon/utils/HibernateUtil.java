package com.recon.utils;


import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;


public class HibernateUtil {

	private static SessionFactory sessionFactory = null;

	static {
		try {
			// Create the SessionFactory from hibernate.cfg.xml
			sessionFactory = new Configuration().configure().buildSessionFactory();
			System.out.println("sessionFactory...in .ProjectReportingHibernateUtil................"+sessionFactory);
		} catch (Throwable ex) {
			// Make sure you log the exception, as it might be swallowed
			System.err.println("Initial SessionFactory creation failed." + ex);

		}
	}

	public static SessionFactory getSessionFactory() {
		return sessionFactory;
	}
	
	public Session getSession() {
		try{
		return getSessionFactory().openSession();
		}
		catch (Exception e) {
			System.err.println("Initial SessionFactory creation failed." + e.getMessage());
		}
		return null;
	}
	
	/*public static void main(String args[]) {
		String queryString = "from TblBankChannelMapping";
		Query queryObject = new HibernateUtil().getSession().createQuery(queryString);
		System.out.println("query object----->"+queryObject.list());
	}*/

}
