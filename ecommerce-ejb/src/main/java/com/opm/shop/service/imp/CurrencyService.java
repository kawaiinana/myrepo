package com.opm.shop.service.imp;

import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Inject;

import com.opm.shop.entity.Currency;
import com.opm.shop.repo.CurrencyRepo;
import com.opm.shop.service.CurrencyServiceLocal;

@Stateless
public class CurrencyService implements CurrencyServiceLocal{

	@Inject
	private CurrencyRepo repo;

	@Override
	public void save(Currency data) {
		if(data.getId() == 0) {
			repo.persit(data);
		} else {
			repo.update(data);
		}
		
	}

	@Override
	public Currency findById(int id) {
		return repo.findById(id);
	}

	@Override
	public List<Currency> getAll() {
		return repo.find(null, null);
	}
	
	

}
