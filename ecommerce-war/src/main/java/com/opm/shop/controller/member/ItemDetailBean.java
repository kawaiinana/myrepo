package com.opm.shop.controller.member;

import java.io.Serializable;

import javax.annotation.PostConstruct;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;

import com.opm.shop.entity.Account;
import com.opm.shop.entity.Item;
import com.opm.shop.entity.Member;
import com.opm.shop.service.ItemServiceLocal;


@SuppressWarnings("serial")
@Named
@RequestScoped
public class ItemDetailBean implements Serializable{

    
    public ItemDetailBean() {
    }
    
    @Inject
    private ItemServiceLocal service;
    private Account loginUser;
    private Member owner;
    private Item item;
    
    @PostConstruct
    public void init() {
    	item=new Item();
    	String str=FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap().get("id");
    	item= service.findById(Long.parseLong(str));
    }
    
    public String buy() {
        return "";
    }

	public Account getLoginUser() {
		return loginUser;
	}

	public void setLoginUser(Account loginUser) {
		this.loginUser = loginUser;
	}

	public Item getItem() {
		return item;
	}

	public void setItem(Item item) {
		this.item = item;
	}

	public Member getOwner() {
		return owner;
	}

	public void setOwner(Member owner) {
		this.owner = owner;
	}
	
}