package com.opm.shop.producers;

import java.util.*;

import javax.annotation.PostConstruct;
import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.event.Observes;
import javax.enterprise.inject.Produces;
import javax.inject.Inject;
import javax.inject.Named;

import com.opm.shop.entity.ItemState;
import com.opm.shop.repo.ItemStateRepo;

@ApplicationScoped
public class ItemStateProducer {

    public ItemStateProducer() {
    }

    @Named
    @Produces
    private List<ItemState> itemStates;

    @Inject
    private ItemStateRepo repo;

    @PostConstruct
    private void init() {
        load(null);
    }

    private void load(@Observes ItemState data) {
    	Map<String, Object> params = new HashMap<>();
    	params.put("del", false);
    	itemStates = repo.find("t.deleteFlag = :del", params);
    }

}