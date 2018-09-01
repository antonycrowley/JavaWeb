package com.orlando.dao;

import java.util.List;

import com.orlando.model.State;

public interface StateDAO {
	public List<State> getAllStates();

	public State findById(int id);

}
