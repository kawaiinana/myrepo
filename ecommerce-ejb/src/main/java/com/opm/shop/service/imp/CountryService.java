package com.opm.shop.service.imp;

import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Inject;

import com.opm.shop.entity.Country;
import com.opm.shop.repo.CountryRepo;
import com.opm.shop.service.CountryServiceLocal;

@Stateless
public class CountryService implements CountryServiceLocal{

	@Inject
	private CountryRepo repo;
	
	@Override
	public void save(Country data) {
		if(data.getId() == 0) {
			repo.persit(data);
		} else {
			repo.update(data);
		}
	}

	@Override
	public Country findById(int id) {
		return repo.findById(id);
	}

	@Override
	public List<Country> getAll() {
		return repo.find(null, null);
	}

}
