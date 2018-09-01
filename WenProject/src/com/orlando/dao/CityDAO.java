package com.orlando.dao;

import java.util.List;
import com.orlando.model.City;

//DAO (Data Access Object) Patron de diseño
public interface CityDAO {
	public List<City> findAllByStateId(int stateId);
}
