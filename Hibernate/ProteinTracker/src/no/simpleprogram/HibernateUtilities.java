package no.simpleprogram;

import org.hibernate.HibernateException;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

import no.interceptors.AuditInterceptor;

public class HibernateUtilities {

	private static SessionFactory sessionFactory;
	private static ServiceRegistry serviceRegistry;
	
	static {
	    try {
	        Configuration cfg = new Configuration();
	        sessionFactory = cfg.configure("hibernate.cfg.xml")
	        		.setInterceptor(new AuditInterceptor())
	        		.buildSessionFactory();
	    } catch (Throwable ex) {
	    	System.out.println("Problem create session factory");
	    	throw new ExceptionInInitializerError(ex);
	    }
	}

	public static SessionFactory getSessionFactory() {
	    return sessionFactory;
	}
	
	
}
