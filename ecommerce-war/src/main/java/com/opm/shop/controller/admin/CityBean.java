package com.opm.shop.controller.admin;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import com.opm.shop.entity.City;
import com.opm.shop.entity.Country;
import com.opm.shop.entity.State;
import com.opm.shop.service.CityServiceLocal;
import com.opm.shop.service.StateServiceLocal;

@SuppressWarnings("serial")
@Named
@ViewScoped
public class CityBean implements Serializable{

	private List<City> cities;
	private List<State> states;
	@Inject
	private List<Country> countries;
	
	private Country country;

	private State state;

	@Inject
	private CityServiceLocal service;
	@Inject
	private StateServiceLocal stateService;

	@PostConstruct
	private void init() {
		country = countries.get(0);
		states = stateService.findByCountry(country);
		state = states.get(0);
		cities = service.findByState(state);
	}

	public void loadStates() {
		states = stateService.findByCountry(country);
	}

	public void search() {
		cities = service.findByState(state);
	}

	public String delete(City city) {
		city.setDeleteFlag(true);
		service.save(city);
		return "";
	}

	public List<City> getCities() {
		return cities;
	}

	public void setCities(List<City> cities) {
		this.cities = cities;
	}

	public Country getCountry() {
		return country;
	}

	public void setCountry(Country country) {
		this.country = country;
	}

	public State getState() {
		return state;
	}

	public void setState(State state) {
		this.state = state;
	}

	public CityServiceLocal getService() {
		return service;
	}

	public void setService(CityServiceLocal service) {
		this.service = service;
	}

}