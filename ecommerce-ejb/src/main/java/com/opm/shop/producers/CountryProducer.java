package com.opm.shop.producers;

import java.util.*;

import javax.annotation.PostConstruct;
import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.event.Observes;
import javax.enterprise.inject.Produces;
import javax.inject.Inject;
import javax.inject.Named;

import com.opm.shop.entity.Country;
import com.opm.shop.repo.CountryRepo;

@ApplicationScoped
public class CountryProducer {

    public CountryProducer() {
    }
    
    @Named
    @Produces
    private List<Country> countries;

    @Inject
    private CountryRepo repo;
    
    @PostConstruct
    private void init() {
        load(null);
    }
    
    private void load(@Observes Country data){
    	Map<String, Object> params = new HashMap<>();
    	params.put("del", false);
    	countries = repo.find("t.deleteFlag = :del", params);
    }

}