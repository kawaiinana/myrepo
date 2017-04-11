package com.opm.shop.service;

import java.util.List;

import javax.ejb.Local;

import com.opm.shop.entity.Currency;

@Local
public interface CurrencyServiceLocal {

	public void save(Currency currency);

	public Currency findById(int id);

	public List<Currency> getAll();

}