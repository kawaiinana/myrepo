package com.opm.shop.service.imp;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.ejb.Stateless;
import javax.inject.Inject;

import com.opm.shop.entity.City;
import com.opm.shop.entity.State;
import com.opm.shop.repo.CityRepo;
import com.opm.shop.service.CityServiceLocal;

@Stateless
public class CityService implements CityServiceLocal {
	
	@Inject
	private CityRepo repo;

	@Override
	public void save(City data) {
		if(data.getId() == 0) {
			repo.persit(data);
		} else {
			repo.update(data);
		}
	}

	@Override
	public City findById(int id) {
		return repo.findById(id);
	}

	@Override
	public List<City> findByState(State state) {
		String where = "t.state.id = :state";
		Map<String, Object> params = new HashMap<>();
		params.put("state", state.getId());
		return repo.find(where, params);
	}

}
