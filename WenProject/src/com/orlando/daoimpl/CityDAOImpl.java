package com.orlando.daoimpl;

import java.util.List;

import javax.persistence.TypedQuery;

import org.hibernate.Session;

import com.orlando.dao.CityDAO;
import com.orlando.dao.HibernateSession;
import com.orlando.model.City;

public class CityDAOImpl implements CityDAO {
	
private static final String FIND_BY_STATE = "FROM City WHERE Id_State = :stateId";
	
	@Override
	public List<City> findAllByStateId(int stateId) {
		Session session = HibernateSession.getSession();
		session.beginTransaction();
		TypedQuery<City> query = session.createQuery(FIND_BY_STATE);
		query.setParameter("stateId", stateId);
		List<City> list = query.getResultList();
		session.close();
		return list;
	}

}
