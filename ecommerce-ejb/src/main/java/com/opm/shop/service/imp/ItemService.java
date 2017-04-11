package com.opm.shop.service.imp;

import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Inject;

import com.opm.shop.entity.Category;
import com.opm.shop.entity.Item;
import com.opm.shop.repo.ItemRepo;
import com.opm.shop.service.ItemServiceLocal;

@Stateless
public class ItemService implements ItemServiceLocal {

	@Inject
	private ItemRepo repo;

	public void save(Item item) {
		repo.persit(item);
	}

	public void update(Item item) {
		repo.update(item);
	}

	@Override
	public List<Item> search(String keyword) {
		return repo.findBy(null, keyword);
	}

	@Override
	public List<Item> getAll() {
		return repo.find(null, null);
	}

	@Override
	public List<Item> findByCategory(Category category) {
		return null;
	}

	@Override
	public Item findById(long id) {
		return repo.findById(id);
	}

}