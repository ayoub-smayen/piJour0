package com.project0.esprit.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project0.esprit.repository.IOredersRepository;

import com.project0.esprit.entity.Orders0;
import com.project0.esprit.service.IOrdersService;

@Service
public class OrdersService implements IOrdersService{

	@Autowired
	IOredersRepository orderRep;
	@Override
	public List<Orders0> retriveAllOrders() {
		List<Orders0> list_orders = (List<Orders0>) orderRep.findAll();
		return list_orders;
	}

	@Override
	public Orders0 addOrders(Orders0 order) {
		Orders0 o = orderRep.save(order);
		return o;
	}

	@Override
	public Orders0 updateOrders(Orders0 order) {
		Orders0 o = orderRep.save(order);
		return o;
	}

	@Override
	public void deleteOrders(Long Id) {
	    orderRep.deleteById(Id);
		
	}

}
