package com.project0.esprit.controller;



import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.project0.esprit.entity.Delivery_Man;
import com.project0.esprit.util.AffectationImpl;




@RestController
@CrossOrigin("*")
@RequestMapping("/api")
public class AffectationController {
	@Autowired
	private AffectationImpl affec;
	
	
	@RequestMapping(value = "/findDelivery/{Product_id}", method = RequestMethod.GET)
	@ResponseBody
	public List<Delivery_Man> findDeliveryMan (@PathVariable Long Product_id){
		
		return affec.moyenDeTransport(Product_id);
	}
	
	
}
