package com.opm.shop.service;

import java.util.List;

import javax.ejb.Local;


import com.opm.shop.entity.ItemState;

@Local
public interface ItemStateServiceLocal {
	
	public void save(ItemState itemstate);

	public ItemState findById(int id);

	public List<ItemState> getAll();
}