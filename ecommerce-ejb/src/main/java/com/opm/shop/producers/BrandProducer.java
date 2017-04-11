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

import com.opm.shop.entity.Brand;
import com.opm.shop.entity.Category;
import com.opm.shop.repo.BrandRepo;

@ApplicationScoped
public class BrandProducer {

    public BrandProducer() {
    }

    @Named
    @Produces
    private List<Brand> brands;
    
    @Inject
    private BrandRepo repo;
    
    @PostConstruct
	private void init() {
		load(null);
	}

    private void load(@Observes Brand data) {
    	Map<String, Object> params = new HashMap<>();
    	params.put("del", false);
    	brands = repo.find("t.deleteFlag = :del", params);
    }
 }