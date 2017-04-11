package com.opm.shop.converters;

import javax.enterprise.context.RequestScoped;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.inject.Inject;
import javax.inject.Named;

import com.opm.shop.entity.Currency;

import com.opm.shop.service.CurrencyServiceLocal;

@Named
@RequestScoped
public class CurrencyConverter implements Converter{
	
	@Inject
	private CurrencyServiceLocal service;

	@Override
	public Object getAsObject(FacesContext context, UIComponent component, String value) {
		if(null != value && !value.isEmpty()){
			//Currency s = service.findById();
			
			//return s;
		}
		return null;
	}

	@Override
	public String getAsString(FacesContext context, UIComponent component, Object value) {
		if(null != value){
			Currency c = (Currency) value;
			return c.getName();
		}
		return null;
	}

}
