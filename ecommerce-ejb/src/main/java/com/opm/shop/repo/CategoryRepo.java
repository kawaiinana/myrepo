package com.opm.shop.repo;

import com.opm.shop.entity.Category;

public class CategoryRepo extends AbstractRepository<Category> {

	public CategoryRepo() {
		super(Category.class);
	}

}