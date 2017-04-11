package com.opm.shop.service;

import java.util.List;

import javax.ejb.Local;

import com.opm.shop.entity.City;
import com.opm.shop.entity.State;

@Local
public interface CityServiceLocal {

	public void save(City city);

	public City findById(int id);

	public List<City> findByState(State state);

}