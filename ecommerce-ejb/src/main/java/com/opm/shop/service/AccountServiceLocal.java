package com.opm.shop.service;

import javax.ejb.Local;

import com.opm.shop.entity.Account;
import com.opm.shop.entity.Member;

@Local
public interface AccountServiceLocal {

	void create(Member account);

	void update(Member account);

	int getAllCount();

	Account findById(int id);

}