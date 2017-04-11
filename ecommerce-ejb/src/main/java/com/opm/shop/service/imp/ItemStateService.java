package com.opm.shop.service.imp;

import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Inject;

import com.opm.shop.entity.ItemState;
import com.opm.shop.repo.ItemStateRepo;
import com.opm.shop.service.ItemStateServiceLocal;

@Stateless
public class ItemStateService implements ItemStateServiceLocal {

	@Inject
	private ItemStateRepo repo;

	@Override
	public void save(ItemState itemstate) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public ItemState findById(int id) {
		return repo.findById(id);
	}

	@Override
	public List<ItemState> getAll() {
		return repo.find(null, null);
	}

	





}