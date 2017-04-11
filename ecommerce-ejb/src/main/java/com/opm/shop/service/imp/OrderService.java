package com.opm.shop.service.imp;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.ejb.Stateless;
import javax.inject.Inject;

import com.opm.shop.entity.Order;
import com.opm.shop.entity.Order.Status;
import com.opm.shop.repo.OrderRepo;
import com.opm.shop.service.OrderServiceLocal;

@Stateless
public class OrderService implements OrderServiceLocal {

	@Inject
	private OrderRepo repo;

	public void save(Order order) {
		repo.persit(order);
	}

	public void update(Order order) {
		repo.update(order);
	}

	public Order findById(long id) {
		return repo.findById(id);
	}

	public List<Order> search(Date DateFrom, Date DateTo) {
		return null;
	}

	@Override
	public List<Order> getAll() {
		return repo.find(null, null);
	}

	@Override
	public List<Order> findByStatus(Status status) {
		String where = "t.status= :status";
		Map<String, Object> params = new HashMap<>();
		params.put("status", status);
		return repo.find(where, params);
	}

}