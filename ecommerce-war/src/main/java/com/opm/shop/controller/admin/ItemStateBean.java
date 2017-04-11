package com.opm.shop.controller.admin;

import java.util.List;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

import com.opm.shop.entity.ItemState;
import com.opm.shop.service.ItemStateServiceLocal;

@Named
@RequestScoped
public class ItemStateBean {

	@Inject
	private List<ItemState> itemStates;


	private ItemStateServiceLocal service;

	public String delete(ItemState itemState) {
		itemState.setDeleteFlag(true);
		service.save(itemState);
		return "";
	}

	public List<ItemState> getItemStates() {
		return itemStates;
	}

	public void setItemStates(List<ItemState> itemStates) {
		this.itemStates = itemStates;
	}
	
	
}