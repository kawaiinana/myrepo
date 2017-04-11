package com.opm.shop.controller.admin;

import java.util.List;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

import com.opm.shop.entity.Currency;
import com.opm.shop.service.CurrencyServiceLocal;

@Named
@RequestScoped
public class CurrencyBean {

	@Inject
	private List<Currency> currencies;

	@Inject
	private CurrencyServiceLocal service;

	public String delete(Currency currency) {
		currency.setDeleteFlag(true);
		service.save(currency);
		return "";
	}

	public List<Currency> getCurrencies() {
		return currencies;
	}

	public void setCurrencies(List<Currency> currencies) {
		this.currencies = currencies;
	}

	
}