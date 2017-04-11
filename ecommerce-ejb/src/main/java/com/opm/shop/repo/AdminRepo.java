package com.opm.shop.repo;

import com.opm.shop.entity.Admin;

public class AdminRepo extends AbstractRepository<Admin> {

	public AdminRepo() {
		super(Admin.class);
	}

}