package com.opm.shop.service;

import java.util.List;

import javax.ejb.Local;

import com.opm.shop.entity.Country;
import com.opm.shop.entity.State;

@Local
public interface StateServiceLocal {

	public void save(State state);

	public State findById(int id);

	public List<State> findByCountry(Country country);
	
	public State findByName(String name);

}