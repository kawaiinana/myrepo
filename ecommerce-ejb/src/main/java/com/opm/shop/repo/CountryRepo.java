package com.opm.shop.repo;

import com.opm.shop.entity.Country;

public class CountryRepo extends AbstractRepository<Country> {

	public CountryRepo() {
		super(Country.class);
	}
}