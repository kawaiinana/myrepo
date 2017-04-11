package com.opm.shop.producers;

import java.util.*;

import javax.annotation.PostConstruct;
import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.event.Observes;
import javax.enterprise.inject.Produces;
import javax.inject.Inject;
import javax.inject.Named;

import com.opm.shop.entity.Currency;
import com.opm.shop.repo.CurrencyRepo;

@ApplicationScoped
public class CurrencyProducer {

    public CurrencyProducer() {
    }
    
    @Named
    @Produces
    private List<Currency> currencies;
    
    @Inject
    private CurrencyRepo repo;

    @PostConstruct
    private void init() {
        load(null);
    }
    
    private void load(@Observes Currency data){
    	Map<String, Object> params = new HashMap<>();
    	params.put("del", false);
    	currencies = repo.find("t.deleteFlag = :del", params);
    }

}