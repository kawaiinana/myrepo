package com.opm.shop.service.imp;

import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.persistence.EntityManager;

import com.opm.shop.entity.Brand;
import com.opm.shop.repo.BrandRepo;
import com.opm.shop.service.BrandServiceLocal;

@Stateless
public class BrandService implements BrandServiceLocal {

	@Inject
	private BrandRepo brandRepo;

	@Inject
	private EntityManager em;

	@Override
	public void create(Brand brand) {
		if (brand.getId() == 0)
			brandRepo.persit(brand);
		else
			brandRepo.update(brand);
	}

	@Override
	public List<Brand> findAllUndeleted() {
		return brandRepo.findAllUndeleted();
	}

	@Override
	public void delete(Brand brand) {
		brandRepo.update(brand);
	}

	@Override
	public List<Brand> search(String brandName) {
		return em
				.createQuery("select b from Brand b where b.name like :brandName and b.deleteFlag = false", Brand.class)
				.setParameter("brandName", brandName).getResultList();
	}

}
