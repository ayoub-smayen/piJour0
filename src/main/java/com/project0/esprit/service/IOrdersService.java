package com.project0.esprit.service;

import java.util.List;

import com.project0.esprit.entity.Orders0;

public interface IOrdersService {


	List<Orders0> retriveAllOrders();
	Orders0 addOrders(Orders0 order);
	Orders0 updateOrders(Orders0 order);
	void deleteOrders(Long Id);
}
