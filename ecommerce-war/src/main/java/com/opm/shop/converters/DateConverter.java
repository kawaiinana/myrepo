package com.opm.shop.converters;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.inject.Named;

@Named
@RequestScoped
public class DateConverter implements Converter{

	private DateFormat df;
	
	@PostConstruct
	private void postConstruct() {
		df = new SimpleDateFormat("yyyy/MM/dd");
	}
	
	@Override
	public Object getAsObject(FacesContext context, UIComponent component, String value) {
		try {
			if (null != value && !value.isEmpty()) {
				return df.parse(value);
			}
		} catch (ParseException e) {
			System.err.println(e.getMessage());
		}
		postConstruct();
		return null;
	}

	@Override
	public String getAsString(FacesContext context, UIComponent component, Object value) {
		if(value != null){
			Date d = (Date) value;
			return df.format(d);
		}
		return null;
	}

}
