package com.opm.shop.service;

import java.util.Date;
import java.util.List;

import javax.ejb.Local;

import com.opm.shop.entity.Order;
import com.opm.shop.entity.Order.Status;

@Local
public interface OrderServiceLocal {
	
	void save(Order order);
	
	void update(Order order);

	Order findById(long l);

	List<Order> search(Date DateFrom, Date DateTo);
	
	List<Order> getAll();
	
	List<Order> findByStatus(Status status);

}