package com.orlando.dao;

import java.util.List;

import com.orlando.model.Person;

public interface PersonDAO {

	public void insert(Person person);

	public List<Person> getAllPersons();

	public Person findById(int id);

	public Person findByEmail(String email);

	public void deletePerson(Person person);

	public void updatePerson(Person person);

}
