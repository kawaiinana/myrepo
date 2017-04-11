package com.opm.shop.repo;

import com.opm.shop.entity.Price;

public class PriceRepo extends AbstractRepository<Price> {

	public PriceRepo() {
		super(Price.class);
	}

}