package com.opm.shop.service;

import java.util.List;

import javax.ejb.Local;

import com.opm.shop.entity.Category;
import com.opm.shop.entity.Item;

@Local
public interface ItemServiceLocal {

	void save(Item item);

	void update(Item item);

	Item findById(long id);

	List<Item> search(String keyword);

	List<Item> findByCategory(Category category);

	List<Item> getAll();
}