package com.opm.shop.controller.member;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import com.opm.shop.entity.Account;
import com.opm.shop.entity.Order;
import com.opm.shop.entity.Order.Status;
import com.opm.shop.service.OrderServiceLocal;

@Named
@ViewScoped
@SuppressWarnings("serial")
public class MyOrderBean implements Serializable {

	public MyOrderBean() {
	}

	@Inject
	private OrderServiceLocal service;
	private Account loginUser;
	private List<Order> orders;
	private Status status;
	private Date df;
	private Date dt;

	@PostConstruct
	public void init() {
		orders = service.getAll();
	}

	public List<Order> search(Date df, Date dt) {
		return null;
	}

	public void searchByStatus() {

		orders = service.findByStatus(status);
	}

	public Account getLoginUser() {
		return loginUser;
	}

	public void setLoginUser(Account loginUser) {
		this.loginUser = loginUser;
	}

	public List<Order> getOrders() {
		return orders;
	}

	public void setOrders(List<Order> orders) {
		this.orders = orders;
	}

	public Status getStatus() {
		return status;
	}

	public void setStatus(Status status) {
		this.status = status;
	}

	public Date getDf() {
		return df;
	}

	public void setDf(Date df) {
		this.df = df;
	}

	public Date getDt() {
		return dt;
	}

	public void setDt(Date dt) {
		this.dt = dt;
	}

}