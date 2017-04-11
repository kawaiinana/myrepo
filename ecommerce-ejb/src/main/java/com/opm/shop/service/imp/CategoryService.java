package com.opm.shop.service.imp;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.ejb.Stateless;
import javax.inject.Inject;

import com.opm.shop.entity.Category;
import com.opm.shop.repo.CategoryRepo;
import com.opm.shop.service.CategoryServiceLocal;
@Stateless
public class CategoryService implements CategoryServiceLocal {
	@Inject
    private CategoryRepo repo;

    @Override
	public void save(Category data) {
		if(data.getId() == 0) {
			repo.persit(data);
		} else {
			repo.update(data);
		}
	}

	@Override
	public Category findById(int id) {
		return repo.findById(id);
	}

	@Override
    public int findCategoryLevelByCategory(Category data) {
        // TODO implement here
        return 0;
    }

	/*@Override
    public List<Category> findByParent(Category parent) {
		String where = "t.parent.id = :parent";
		Map<String, Object> params = new HashMap<>();
		params.put("parent", parent.getId());
		return repo.find(where, params);
       
    }*/
}