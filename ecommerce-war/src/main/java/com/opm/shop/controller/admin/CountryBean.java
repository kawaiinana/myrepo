package com.opm.shop.controller.admin;

import java.util.List;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

import com.opm.shop.entity.Country;
import com.opm.shop.service.CountryServiceLocal;

@Named
@RequestScoped
public class CountryBean {

	@Inject
	private List<Country> countries;

	@Inject
	private CountryServiceLocal service;

	public String delete(Country country) {
		country.setDeleteFlag(true);
		service.save(country);
		return "";
	}

	public List<Country> getCountries() {
		return countries;
	}

	public void setCountries(List<Country> countries) {
		this.countries = countries;
	}

}