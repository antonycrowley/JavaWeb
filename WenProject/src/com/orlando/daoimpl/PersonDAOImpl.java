package com.orlando.daoimpl;

import java.util.List;

import javax.persistence.TypedQuery;

import org.hibernate.Session;

import com.orlando.dao.HibernateSession;
import com.orlando.dao.PersonDAO;
import com.orlando.model.Person;

public class PersonDAOImpl implements PersonDAO{
	
private static final String GET_ALL_PERSONS = "FROM Person"; //HQL(Hibernate Query Language)
	
	private static final String FIND_BY_EMAIL = "FROM Person WHERE Email = :email";
	
	
	@Override
	public void insert(Person person) {
		// TODO Auto-generated method stub
		HibernateSession.saveObject(person);
	}

	@Override
	public List<Person> getAllPersons() {
		Session session = HibernateSession.getSession();
		session.beginTransaction();
		TypedQuery<Person> query = session.createQuery(GET_ALL_PERSONS);
		List<Person> list = query.getResultList();
		session.close();
		return list;
	}

	@Override
	public Person findById(int id) {
		Person person = (Person)HibernateSession.getObjectByPrimaryKey(Person.class, id);
		return person;
	}

	@Override
	public Person findByEmail(String email) {
		Session session = HibernateSession.getSession();
		session.beginTransaction();
		TypedQuery<Person> query = session.createQuery(FIND_BY_EMAIL);
		query.setParameter("email", email);
		Person person = (Person)query.getResultList().get(0);
		session.close();
		return person;
	}

	@Override
	public void deletePerson(Person person) {
		HibernateSession.deleteObject(person);
	}

	@Override
	public void updatePerson(Person person) {
		// TODO Auto-generated method stub
		HibernateSession.updateObject(person);
	}

}
