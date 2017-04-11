package com.opm.shop.producers;

import java.util.*;

import javax.annotation.PostConstruct;
import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.event.Observes;
import javax.enterprise.inject.Produces;
import javax.inject.Inject;
import javax.inject.Named;

import com.opm.shop.entity.Language;
import com.opm.shop.repo.LanguageRepo;

@ApplicationScoped
public class LanguageProducer {

	public LanguageProducer() {
	}

	@Named
	@Produces
	private List<Language> languages;

	@Inject
	private LanguageRepo repo;

	@PostConstruct
	private void init() {
		load(null);
	}

	private void load(@Observes Language data) {
		Map<String, Object> params = new HashMap<>();
		params.put("del", false);
		languages = repo.find(null, null);
	}

}