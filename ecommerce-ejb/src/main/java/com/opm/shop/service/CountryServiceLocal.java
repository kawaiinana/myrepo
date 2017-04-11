package com.opm.shop.service;

import java.util.List;

import javax.ejb.Local;

import com.opm.shop.entity.Country;

@Local
public interface CountryServiceLocal {

	public void save(Country country);

	public Country findById(int id);

	public List<Country> getAll();

}