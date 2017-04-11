package com.opm.shop.repo;

import com.opm.shop.entity.Currency;

public class CurrencyRepo extends AbstractRepository<Currency> {

	public CurrencyRepo() {
		super(Currency.class);
	}

}