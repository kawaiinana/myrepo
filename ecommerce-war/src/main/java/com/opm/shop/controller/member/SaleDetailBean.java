package com.opm.shop.controller.member;

import java.io.Serializable;

import javax.annotation.PostConstruct;

import com.opm.shop.entity.Account;
import com.opm.shop.entity.Order;


@SuppressWarnings("serial")
public class SaleDetailBean implements Serializable {

    public SaleDetailBean() {
    }
   
    private Order order;
    private Account loginUser;
    
    @PostConstruct
    public void init() {
    }

    public String save() {
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