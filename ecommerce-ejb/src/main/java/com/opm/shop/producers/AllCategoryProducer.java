package com.opm.shop.producers;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.PostConstruct;
import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.event.Observes;
import javax.enterprise.inject.Produces;
import javax.inject.Inject;
import javax.inject.Named;

import com.opm.shop.entity.Category;
import com.opm.shop.repo.CategoryRepo;

@ApplicationScoped
public class AllCategoryProducer {
	
	@Named
	@Produces
	private List<Category> allCategories;
	
	@Inject
	private CategoryRepo repo;
	    
	@PostConstruct
	private void init() {
		load(null);
	}

	private void load(@Observes Category data) {
		Map<String, Object> params = new HashMap<>();
		params.put("del", false);
		allCategories = repo.find("t.deleteFlag = :del", params);
    	
	}
		
}
