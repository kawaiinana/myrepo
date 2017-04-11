package com.opm.shop.controller.member;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import com.opm.shop.entity.Account;
import com.opm.shop.entity.Brand;
import com.opm.shop.entity.Category;
import com.opm.shop.entity.Item;
import com.opm.shop.entity.ItemState;
import com.opm.shop.service.ItemServiceLocal;

@Named
@ViewScoped
@SuppressWarnings("serial")
public class ItemListBean implements Serializable {

	private List<Item> items;

	@Inject
	private ItemServiceLocal service;

	private Account loginUser;
	private Category category;
	private String keyword;
	private Brand brand;
	private ItemState itemState;

	@PostConstruct
	public void init() {

		items = service.getAll();
	}

	public List<Item> getItems() {
		return items;
	}

	public void setItems(List<Item> items) {
		this.items = items;
	}

	public List<Item> search(Category category, String keyword) {
		return null;
	}

	public Account getLoginUser() {
		return loginUser;
	}

	public void setLoginUser(Account loginUser) {
		this.loginUser = loginUser;
	}

	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}

	public String getKeyword() {
		return keyword;
	}

	public void setKeyword(String keyword) {
		this.keyword = keyword;
	}

	public Brand getBrand() {
		return brand;
	}

	public void setBrand(Brand brand) {
		this.brand = brand;
	}

	public ItemState getItemState() {
		return itemState;
	}

	public void setItemState(ItemState itemState) {
		this.itemState = itemState;
	}

}