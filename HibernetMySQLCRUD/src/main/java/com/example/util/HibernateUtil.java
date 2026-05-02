package com.example.util;
import org.hibernate.*;
import org.hibernate.cfg.*;

public class HibernateUtil {

	private static final SessionFactory sessionFactory=buildSessionFactory();
	private static SessionFactory buildSessionFactory()
	{
		try {
		return new Configuration().configure("hibernate.cfg.xml").buildSessionFactory();		}
		catch(Exception ex)
		{
			System.out.println(ex.getMessage());
			throw new ExceptionInInitializerError();
		}
		
	}
	public static SessionFactory getSessionFactory() {
		return sessionFactory;
	}
	public static void shutdown()
	{
		getSessionFactory().close();
	}
}
