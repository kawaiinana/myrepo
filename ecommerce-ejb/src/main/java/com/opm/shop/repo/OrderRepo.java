package com.opm.shop.repo;

import com.opm.shop.entity.Order;

public class OrderRepo extends AbstractRepository<Order> {

	public OrderRepo() {
		super(Order.class);
	}
}