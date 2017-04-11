package com.opm.shop.service.imp;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.ejb.Stateless;
import javax.inject.Inject;

import com.opm.shop.entity.Country;
import com.opm.shop.entity.State;
import com.opm.shop.repo.StateRepo;
import com.opm.shop.service.StateServiceLocal;

@Stateless
public class StateService implements StateServiceLocal {
	
	@Inject
	private StateRepo repo;
	
	@Override
	public void save(State data) {
		if(data.getId() == 0) {
			repo.persit(data);
		} else {
			repo.update(data);
		}
	}
	
	

	@Override
	public State findById(int id) {
		return repo.findById(id);
	}

	@Override
	public List<State> findByCountry(Country country) {
		String where = "t.country.id = :country";
		Map<String, Object> params = new HashMap<>();
		params.put("country", country.getId());
		return repo.find(where, params);
	}

	@Override
	public State findByName(String name) {
		Map<String, Object> params = new HashMap<>();
		String where = ("t.name = :name");
		params.put("name", name.concat("%"));
		List<State> list = repo.find(where, params);
		if (!list.isEmpty()) {
			return list.get(0);
		}
		return null;
	}

}
