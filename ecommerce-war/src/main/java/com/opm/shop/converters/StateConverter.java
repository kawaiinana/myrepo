package com.opm.shop.converters;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.inject.Inject;

import com.opm.shop.entity.State;
import com.opm.shop.service.StateServiceLocal;

public class StateConverter implements Converter{

	@Inject
	private StateServiceLocal service;
	
	@Override
	public Object getAsObject(FacesContext context, UIComponent component, String value) {
		if(null != value && !value.isEmpty()){
			State s = service.findByName(value);
			return s;
		}
		return null;
	}

	@Override
	public String getAsString(FacesContext context, UIComponent component, Object value) {
		// TODO Auto-generated method stub
		if(null != value){
			State s = (State) value;
			return s.getName();
		}
		return null;
	}

}
