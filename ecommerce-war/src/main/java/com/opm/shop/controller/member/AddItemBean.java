package com.opm.shop.controller.member;

import java.io.Serializable;

import javax.annotation.PostConstruct;

import com.opm.shop.entity.Account;
import com.opm.shop.entity.Item;


@SuppressWarnings("serial")
public class AddItemBean implements Serializable{

    public AddItemBean() {
    }

    private Account loginUser;
    private Item Item;

    @PostConstruct
    public void init() {
    }
  
    public String save() {
        return "";
    }

	public Account getLoginUser() {
		return loginUser;
	}

	public void setLoginUser(Account loginUser) {
		this.loginUser = loginUser;
	}

	public Item getItem() {
		return Item;
	}

	public void setItem(Item item) {
		Item = item;
	}
    
}