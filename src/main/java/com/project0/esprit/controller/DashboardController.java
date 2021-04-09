package com.project0.esprit.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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


import com.project0.esprit.entity.Dashboard;
import com.project0.esprit.entity.Euser;
import com.project0.esprit.entity.Product1;
import com.project0.esprit.entity.Profit;
import com.project0.esprit.repository.EuserRepository;
import com.project0.esprit.repository.ProductRepository;
import com.project0.esprit.repository.ProfitRepository;
import com.project0.esprit.service.DashboardService;
import com.project0.esprit.service.ProductService;
import com.project0.esprit.service.ProfitService;

@RestController
@CrossOrigin("*")
@RequestMapping("api")
public class DashboardController {

	
	@Autowired
	private DashboardService dashboardservice;
	@Autowired 
	private ProductService productservice ;
	@Autowired
	private EuserRepository euserrep;
	@Autowired
	private ProfitRepository profitRepository;
	@Autowired
	private ProductRepository productRepository;
	@Autowired
	private ProfitService profitService;
	
	
	
	
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
  


//les vues selon l'age,le sexe et city
//http://localhost:8091/api/get-data
@GetMapping("/get-data")
public ResponseEntity<Map<String, Integer>> getPieChart() {
    Map<String, Integer> graphData = new TreeMap<>();
    for(Euser e :euserrep.findAll() ) {
    	graphData.put(e.getCity(),   euserrep.getCityCount(e.getCity())  );
    	graphData.put(e.getSexe(),   euserrep.getSexeCount(e.getSexe())  );
    	graphData.put(e.getAge(),   euserrep.getAgeCount(e.getAge())  );
    }
    
    return new ResponseEntity<>(graphData, HttpStatus.OK);
}

//profit
//http://localhost:8091/api/get-data1
 @GetMapping("/get-data1")
public ResponseEntity<?> getPieChart1() {
    Map<String, Double> graphData = new TreeMap<>();
    for(Profit p :profitRepository.findAll() ) {
    	graphData.put(p.getMonth(),profitService.getAllGain(p.getIncome(), p.getOutcome()));
    }
    return new ResponseEntity<>(graphData, HttpStatus.OK);
}

 //bestproduct
 //http://localhost:8091/api/dashboard2
    @GetMapping("/dashboard2")
	//@Secured("ROLE_ADMIN")
	private List<Product1>  getBestprod(){
		List<Product1>  bestproduct =new ArrayList<>();
		//List<Product1> p1 =  productservice.findAll();
		List<Product1> p1 = productRepository.findAll();
		
		for (Product1  x: p1 ) {
			
			if(x.getQuantity() <20) {
				bestproduct.add(x);
			}
			
		}
		 return bestproduct;
	
	}

 //outcome,income,marge ,total income,total outcome,total marge
 //http://localhost:8091/api/profit1
 @GetMapping("/profit1")
 
	@ResponseBody public ResponseEntity<?> getGain1()
	{
		
		HashMap<String, Object> k = profitService.getTodayRevenueDash();
	  return  ResponseEntity.status(HttpStatus.ACCEPTED).body(k);	
	}

	////////////////////////////////
	
	
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


