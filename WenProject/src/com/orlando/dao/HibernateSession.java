package com.orlando.dao;

import java.io.Serializable;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateSession {
	
	private static final SessionFactory SESSION_FACTORY;
	
	private static Session session;
	
	static{
		SESSION_FACTORY = new Configuration().configure().buildSessionFactory();
	}
	
	public static void saveObject(Object object){
		session = SESSION_FACTORY.openSession();
		session.beginTransaction();
		session.save(object);
		session.getTransaction().commit();
		session.close();
	}
	
	public static <T> Object getObjectByPrimaryKey(Class <T> objectClass, Serializable pk){
		session = SESSION_FACTORY.openSession();
		session.beginTransaction();
		Object obj = session.get(objectClass, pk);
		session.close();
		return obj;
	}
	
	public static void deleteObject(Object object){
		session = SESSION_FACTORY.openSession();
		session.beginTransaction();
		session.delete(object);
		session.getTransaction().commit();
		session.close();
	}
	
	public static void updateObject(Object object){
		session = SESSION_FACTORY.openSession();
		session.beginTransaction();
		session.update(object);
		session.getTransaction().commit();
		session.close();
	}
	
	public static Session getSession(){
		session = SESSION_FACTORY.openSession();
		return session;
	}
	
	
	
	
	
}
