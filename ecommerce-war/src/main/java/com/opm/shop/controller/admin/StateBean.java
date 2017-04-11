package com.opm.shop.controller.admin;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

import com.opm.shop.entity.Country;
import com.opm.shop.entity.State;
import com.opm.shop.service.StateServiceLocal;

@Named
@RequestScoped
public class StateBean {

	private List<State> states;

	@Inject
	private List<Country> countries;
	
	private Country country;

	@Inject
	private StateServiceLocal service;

	@PostConstruct
	private void init() {
		country = countries.get(0);
		states = service.findByCountry(country);
	}

	public String search() {
		states = service.findByCountry(country);
		return "";
	}

	public String delete(int id) {
		return "";
	}

	public List<State> getStates() {
		return states;
	}

	public void setStates(List<State> states) {
		this.states = states;
	}

}