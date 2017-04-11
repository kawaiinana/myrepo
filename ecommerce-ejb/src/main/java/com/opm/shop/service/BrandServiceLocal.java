package com.opm.shop.service;

import java.util.List;

import javax.ejb.Local;

import com.opm.shop.entity.Brand;

@Local
public interface BrandServiceLocal {

	void create(Brand brand);
	
	List<Brand> findAllUndeleted();
	
	void delete(Brand brand);
	
	List<Brand> search(String brandName);
}
