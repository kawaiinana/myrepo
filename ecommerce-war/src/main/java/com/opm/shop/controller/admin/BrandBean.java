package com.opm.shop.controller.admin;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import com.opm.shop.entity.Brand;
import com.opm.shop.service.BrandServiceLocal;

@SuppressWarnings("serial")
@Named
@ViewScoped
public class BrandBean implements Serializable {

	@Inject
	private BrandServiceLocal service;

	
	private List<Brand> brandsList;
	private Brand brand;

	@PostConstruct
	private void init() {

		System.out.println("init was called");
		brandsList = service.findAllUndeleted();
		brand = new Brand();
	}

	public String save() {
		service.create(brand);

		return "/admin/brand.xhtml?faces-redirect=true";
	}

	public String delete(Brand b) {

		b.setDeleteFlag(true);
		service.delete(b);

		return "/admin/brand.xhtml?faces-redirect=true";
	}

	public String edit(Brand b) {

		brand = b;

		return "/admin/brand.xhtml?faces-redirect=true";
	}

	public void search(String brandName) {

		if (brandName != null && !brandName.isEmpty()) {
			brandsList = service.search(brandName);
		}

	}

	


	public List<Brand> getBrandsList() {
		return brandsList;
	}

	public void setBrandsList(List<Brand> brandsList) {
		this.brandsList = brandsList;
	}

	public Brand getBrand() {
		return brand;
	}

	public void setBrand(Brand brand) {
		this.brand = brand;
	}
}
