package com.opm.shop.converters;

import java.util.List;

import javax.enterprise.context.RequestScoped;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.inject.Inject;
import javax.inject.Named;

import com.opm.shop.entity.Country;

@Named
@RequestScoped
public class CountryConverter implements Converter{
	@Named
	@Inject
	private List<Country> countries;
	@Override
	public Object getAsObject(FacesContext context, UIComponent component, String value) {
		if(null != value && !value.isEmpty()){
			return countries.stream().filter(x-> x.getName().equals(value)).findAny().orElse(null);
		}
		return null;
	}

	@Override
	public String getAsString(FacesContext context, UIComponent component, Object value) {

		if(null != value){
			Country c = (Country) value;
			return c.getName();
		}
		return null;
	}

}
