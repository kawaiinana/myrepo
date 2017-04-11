package com.opm.shop.repo;

import com.opm.shop.entity.Brand;

public class BrandRepo extends AbstractRepository<Brand> {

	public BrandRepo() {
		super(Brand.class);
	}

}