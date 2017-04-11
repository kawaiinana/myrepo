package com.opm.shop.repo;

import com.opm.shop.entity.CommissionRate;

public class CommissionRateRepo extends AbstractRepository<CommissionRate> {

	public CommissionRateRepo() {
		super(CommissionRate.class);
	}

}