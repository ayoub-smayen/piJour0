package com.project0.esprit.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.annotation.Secured;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.project0.esprit.datentity.User;
import com.project0.esprit.entity.Dashboard;
import com.project0.esprit.entity.Product1;
import com.project0.esprit.repository.ProductRepository;
import com.project0.esprit.service.DashboardService;

@RestController
@CrossOrigin("*")
@RequestMapping("api")
public class DashboardController {

	
	@Autowired
	private DashboardService dashboardservice;
	
	
	@Autowired 
	private ProductRepository c;
	
	
	
	@GetMapping("/dashboard2/get/{dashboard_id}")
	//@Secured("ROLE_ADMIN")
	@ResponseBody
	public Dashboard retrieveDashboard(@PathVariable("dashboard_id") Long id) {
	return dashboardservice.retrieveDashboard(id);
	}
	
	
	
	@PostMapping("/dashboard2/add")
	//@Secured("ROLE_ADMIN")
	@ResponseBody
	public Dashboard addDashboard(@RequestBody Dashboard d) {
		Dashboard dashboard = dashboardservice.addDashboard(d);
	return dashboard;
	}
	
	
	/*@PostMapping("/add")
    public @ResponseBody ResponseEntity<Dashboard> addDashboard( Dashboard d)
	
	{
		
		return new ResponseEntity<Dashboard>(dashboardservice.addDashboard(d),HttpStatus.CREATED);
	}*/
	
	
	@PutMapping("/dashboard2/update")
	//@Secured("ROLE_ADMIN")
	@ResponseBody
	public Dashboard modifyDashboard(@RequestBody Dashboard dashboard) {
	return dashboardservice.updateDashboard(dashboard);
	}
	
	/*@PutMapping("/update")
    public @ResponseBody ResponseEntity<Dashboard> updateDashboard( Dashboard d)

    {
	147852369Az@
	return new ResponseEntity<Dashboard>(dashboardservice.updateDashboard(d),HttpStatus.ACCEPTED);
    }*/
	
    
	@DeleteMapping("/dashboard2/delete/{dashboard_id}")
	//@Secured("ROLE_ADMIN")
	@ResponseBody
	public void removeDashboard(@PathVariable("dashboard_id") Long id) 
	{
		dashboardservice.deleteDashboard(id);
	}
  
	@GetMapping("/dashboard2/produitbest")
	//@Secured("ROLE_ADMIN")
	private List<Product1>  getBestprod(){
		List<Product1>  bestproduct =new ArrayList<>();
		List<Product1> p1 = c.findAll();
		
		for (Product1  x: p1 ) {
			
			if(x.getQuantity() <20) {
				bestproduct.add(x);
			}
			
		}
		
		 return bestproduct;
	
	}
	/*
	@GetMapping("/userview")
	@Secured("ROLE_ADMIN")
	
	private  List<User> getAllUser(){
		
		 List<User> lu = dashboardservice.getAllUser();
		
		 
		 return  lu;
		
		//ResponseEntity.status(201).body(lu);ResponseEntity<?>
	}
	*/
	/*
	@GetMapping("/produitbest")
	//@Secured("ROLE_ADMIN")
	private List<Product1>  getBestprod(){
		
		List<Product1> lp1 = dashboardservice.getBesProducts();
		 return  lp1;
				 //ResponseEntity.status(201).body(lp1);
	}*/
	
}


