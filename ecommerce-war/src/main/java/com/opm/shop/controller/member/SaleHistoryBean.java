package com.opm.shop.controller.member;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.annotation.PostConstruct;

import com.opm.shop.entity.Account;
import com.opm.shop.entity.Order;
import com.opm.shop.entity.Order.Status;


@SuppressWarnings("serial")
public class SaleHistoryBean implements Serializable{

    
    public SaleHistoryBean() {
    }
    
    private Account loginUser;
    private List<Order> orders;
    private Status status;
    private Date df;
    private Date dt;

    @PostConstruct
    public void init() {
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