package com.opm.shop.service;

import java.util.Date;
import java.util.List;

import javax.ejb.Local;

import com.opm.shop.entity.CommissionRate;
import com.opm.shop.entity.CommissionRate.RateType;

@Local
public interface CommissionRateLocal {

	void save(CommissionRate comRate);

	CommissionRate findById(int id);
	
	List<CommissionRate> findAll();
	
	void delete(CommissionRate c);
	
	List<CommissionRate> find(RateType type, Date refDate);

}
