package com.opm.shop.controller.member;

import java.io.Serializable;

import javax.annotation.PostConstruct;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;

import com.opm.shop.entity.Account;
import com.opm.shop.entity.Order;
import com.opm.shop.service.OrderServiceLocal;

@Named
@RequestScoped
@SuppressWarnings("serial")
public class OrderDetailBean implements Serializable {

	public OrderDetailBean() {
	}

	@Inject
	private OrderServiceLocal service;
	private Order order;
	private Account loginUser;

	@PostConstruct
	public void init() {

		order = new Order();
		String str = FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap().get("id");
		order = service.findById(Long.parseLong(str));

	}

	public String edit() {
		return "";
	}

	public String delete() {
		return "";
	}

	public Order getOrder() {
		return order;
	}

	public void setOrder(Order order) {
		this.order = order;
	}

	public Account getLoginUser() {
		return loginUser;
	}

	public void setLoginUser(Account loginUser) {
		this.loginUser = loginUser;
	}

}