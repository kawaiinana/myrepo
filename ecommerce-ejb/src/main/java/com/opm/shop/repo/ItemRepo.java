package com.opm.shop.repo;

import com.opm.shop.entity.Item;

public class ItemRepo extends AbstractRepository<Item> {

	public ItemRepo() {
		super(Item.class);
	}

}