package com.opm.shop.service.imp;

import javax.ejb.Stateless;
import javax.inject.Inject;

import com.opm.shop.entity.Account;
import com.opm.shop.entity.Member;
import com.opm.shop.repo.AccountRepo;
import com.opm.shop.repo.MembereRepo;
import com.opm.shop.service.AccountServiceLocal;

@Stateless
public class AccountService implements AccountServiceLocal {

	public AccountService() {
	}

	@Inject
	private AccountRepo acRepo;
	@Inject
	private MembereRepo memRepo;

	public void create(Member account) {
		memRepo.persit(account);
	}

	public void update(Member account) {
		memRepo.update(account);
	}

	public int getAllCount() {
		return (int) memRepo.findCount(null, null);
	}

	public Account findById(int id) {
		return acRepo.findById(id);
	}

}