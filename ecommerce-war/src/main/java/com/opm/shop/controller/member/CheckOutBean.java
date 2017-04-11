package com.opm.shop.controller.member;

import java.io.Serializable;

import javax.annotation.PostConstruct;

import com.opm.shop.entity.Account;
import com.opm.shop.entity.Address;


@SuppressWarnings("serial")
public class CheckOutBean implements Serializable{
    
    public CheckOutBean() {
    }

    private Address address;
    //private Payment payment;
    private Account loginUser;

    @PostConstruct
    public void init() {
    }

    public void save() {
    }

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	public Account getLoginUser() {
		return loginUser;
	}

	public void setLoginUser(Account loginUser) {
		this.loginUser = loginUser;
	}

    
}