package com.project0.esprit.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.project0.esprit.service.IOrdersService;
import com.project0.esprit.entity.Orders0;

@RestController
@RequestMapping(path="/api")
public class OrdersRestControllerImpl{
@Autowired
IOrdersService orderServ;


@GetMapping("/retreve_all_Order")
@ResponseBody
public List<Orders0> getOrder(){
	List<Orders0> ordersList = orderServ.retriveAllOrders();
	return ordersList;	
			}

@PostMapping("/add_Order")
@ResponseBody
public Orders0 addOrder(@RequestBody Orders0 o){
	Orders0 order = orderServ.addOrders(o);
	return order;
}

@DeleteMapping("/delete_Order/{id}")
public void deleteCartItem(@PathVariable("id") Long id){
	orderServ.deleteOrders(id);
}

@PutMapping("/update_Order")
@ResponseBody
public Orders0 updateCart(@RequestBody Orders0 c){
	Orders0 order = orderServ.updateOrders(c);
	return order;
}

}