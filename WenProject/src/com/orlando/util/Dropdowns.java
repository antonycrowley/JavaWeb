package com.orlando.util;

import java.util.List;

import com.orlando.dao.CityDAO;
import com.orlando.dao.PersonDAO;
import com.orlando.dao.StateDAO;
import com.orlando.daoimpl.CityDAOImpl;
import com.orlando.daoimpl.PersonDAOImpl;
import com.orlando.daoimpl.StateDAOImpl;
import com.orlando.model.City;
import com.orlando.model.Person;
import com.orlando.model.State;

public class Dropdowns {
	
private List<State> stateDrop;
	
	private List<City> cityDrop;
	
	private List<Person> personList;

	public List<State> getStateDrop() {
		StateDAO stateDao = new StateDAOImpl();
		stateDrop = stateDao.getAllStates();
		return stateDrop;
	}

	public void setStateDrop(List<State> stateDrop) {
		this.stateDrop = stateDrop;
	}

	public List<City> getCityDrop(int stateId) {
		CityDAO cityDao = new CityDAOImpl();
		cityDrop = cityDao.findAllByStateId(stateId);
		return cityDrop;
	}

	public void setCityDrop(List<City> cityDrop) {
		this.cityDrop = cityDrop;
	}

	public List<Person> getPersonList() {
		PersonDAO personDao = new PersonDAOImpl();
		personList = personDao.getAllPersons();
		return personList;
	}

	public void setPersonList(List<Person> personList) {
		this.personList = personList;
	}

	
}
