package com.opm.shop.producers;

import javax.annotation.PostConstruct;
import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.inject.Produces;
import javax.inject.Named;

import com.opm.shop.entity.CommissionRate.RateType;

@ApplicationScoped
public class CommissionRateProducer {

    @Named
    @Produces
    private RateType[] rates;

    @PostConstruct
    private void init() {
    	rates = RateType.values();
    }

}