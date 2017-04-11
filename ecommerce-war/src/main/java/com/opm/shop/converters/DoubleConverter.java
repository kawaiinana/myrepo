package com.opm.shop.converters;

import javax.enterprise.context.RequestScoped;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.inject.Named;

@Named
@RequestScoped
public class DoubleConverter implements Converter {
	public Object getAsObject(FacesContext context, UIComponent component, String value) {
		Double decimal = null;
		if (value != null) {
			if (value.equals("")) {
				decimal = null;
			} else {
				decimal = Double.valueOf(value);
			}
		}
		return decimal;
	}

	public String getAsString(FacesContext context, UIComponent component, Object value) {
		String decimal = "";
		if (value != null) {
			decimal = ((Double) value).doubleValue() == 0d ? "" : value.toString();
		} else {
			decimal = "";
		}
		return decimal;
	}
}
