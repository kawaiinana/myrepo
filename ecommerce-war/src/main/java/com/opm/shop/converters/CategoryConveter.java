package com.opm.shop.converters;

import java.util.List;

import javax.enterprise.context.RequestScoped;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.inject.Inject;
import javax.inject.Named;

import com.opm.shop.entity.Category;

@Named
@RequestScoped
public class CategoryConveter implements Converter{
	@Named
	@Inject
	private List<Category> categories;
	@Override
	public Object getAsObject(FacesContext context, UIComponent component, String value) {
		if(null != value && !value.isEmpty()){
			 categories.stream()
			 	.flatMap(c -> c.getChildren().stream())
			 	.flatMap(c -> c.getChildren().stream())
			 	.distinct()
			 	.filter(c -> c.getName().equals(value))
			 	.findAny()
			 	.orElse(null);
		}
		return null;
	}

	@Override
	public String getAsString(FacesContext context, UIComponent component, Object value) {
		if(null != value){
			Category c = (Category) value;
			return c.getName();
		}
		return null;
	}

}
