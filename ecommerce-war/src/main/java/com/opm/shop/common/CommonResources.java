package com.opm.shop.common;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.inject.Produces;
import javax.inject.Named;

import com.opm.shop.entity.Order.Status;

@ApplicationScoped
public class CommonResources {
	@Named
	@Produces
	public Status[] getStatus() {

		return Status.values();
	}
}
