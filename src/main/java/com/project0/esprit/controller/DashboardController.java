package com.project0.esprit.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;
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
import org.springframework.web.client.RestTemplate;

import com.project0.esprit.entity.Dashboard;
import com.project0.esprit.entity.Euser;
import com.project0.esprit.entity.Product1;
import com.project0.esprit.entity.Profit;
import com.project0.esprit.repository.EuserRepository;
import com.project0.esprit.repository.ProductRepository;
import com.project0.esprit.repository.ProfitRepository;
import com.project0.esprit.service.DashboardService;
import com.project0.esprit.service.ProfitService;

@RestController
@CrossOrigin("*")
@RequestMapping("api")
public class DashboardController {

	
	@Autowired
	private DashboardService dashboardservice;
	@Autowired
	private EuserRepository euserrep;
	@Autowired
	private ProfitRepository profitRepository;
	@Autowired
	private ProductRepository productRepository;
	@Autowired
	private ProfitService profitService;
	@Autowired
    private RestTemplate restTemplate;
	
	
	
	//http://localhost:8091/api/dashboard/bestproductwithlikes
	@GetMapping("/dashboard/bestproductwithlikes")
	public List<Product1>  getProductsByLiks(){
		
		return productRepository.findBylikes();
	}
	
	
	//http://localhost:8091/api/dashboard/bestproductlikedeslike
	@GetMapping("/dashboard/bestproductlikedeslike")
	public List<Product1>  getProductsByLiksdeslike(){
		
		return productRepository.findBylikesanddeslikes();
	}
	
	
	//http://localhost:8091/api/dashboard/get/{dashboard_id}
	@GetMapping("/dashboard/get/{dashboard_id}")
	//@Secured("ROLE_ADMIN")
	@ResponseBody
	public Dashboard retrieveDashboard(@PathVariable("dashboard_id") Long id) {
	return dashboardservice.retrieveDashboard(id);
	}
	
	
	//http://localhost:8091/api/dashboard/add
	/*@PostMapping("/dashboard/add")
	//@Secured("ROLE_ADMIN")
	@ResponseBody
	public Dashboard addDashboard(@RequestBody Dashboard d) {
		Dashboard dashboard = dashboardservice.addDashboard(d);
	return dashboard;
	}*/
	
	
	//http://localhost:8091/api/dashboard/add
	@PostMapping("/dashboard/add")
    public @ResponseBody ResponseEntity<Dashboard> addDashboard( Dashboard d)
	
	{
		
		return new ResponseEntity<Dashboard>(dashboardservice.addDashboard(d),HttpStatus.CREATED);
	}
	
	
	//http://localhost:8091/api/dashboard/update/{dashboard_id}
/*	@PutMapping("/dashboard/update/{dashboard_id}")
	//@Secured("ROLE_ADMIN")
	@ResponseBody
	public Dashboard modifyDashboard(@RequestBody Dashboard dashboard) {
	return dashboardservice.updateDashboard(dashboard);
	}*/
	
	
	//http://localhost:8091/api/dashboard/update/{dashboard_id}
	@PutMapping("/dashboard/update/{dashboard_id}")
    public @ResponseBody ResponseEntity<Dashboard> updateDashboard( Dashboard d)

    {
	return new ResponseEntity<Dashboard>(dashboardservice.updateDashboard(d),HttpStatus.ACCEPTED);
    }
	
	//http://localhost:8091/api/dashboard/delete/{dashboard_id}
	@DeleteMapping("/dashboard/delete/{dashboard_id}")
	//@Secured("ROLE_ADMIN")
	@ResponseBody
	public void removeDashboard(@PathVariable("dashboard_id") Long id) 
	{
		dashboardservice.deleteDashboard(id);
	}
  


//les vues selon l'age,le sexe et city
//http://localhost:8091/api/agesexecity
@GetMapping("/agesexecity")
public ResponseEntity<Map<String, Integer>> getPieChart() {
    Map<String, Integer> graphData = new TreeMap<>();
    for(Euser e :euserrep.findAll() ) {
    	graphData.put(e.getCity(),   euserrep.getCityCount(e.getCity())  );
    	graphData.put(e.getSexe(),   euserrep.getSexeCount(e.getSexe())  );
    	graphData.put(e.getAge(),   euserrep.getAgeCount(e.getAge())  );
    }
    
    return new ResponseEntity<>(graphData, HttpStatus.OK);
}

//http://localhost:8091/api/profit/profitpermonth
	@GetMapping("/profitpermonth")
	  
	@ResponseBody public ResponseEntity<?>  getGainmonthly( ){
		
		List<Map<String, Double>> k = profitService.getgainmaithly();
	  return  ResponseEntity.status(HttpStatus.ACCEPTED).body(k);	
	}
/*//profit
//http://localhost:8091/api/gain
 @GetMapping("/gain")
public ResponseEntity<?> getPieChart1() {
    Map<String, Double> graphData = new TreeMap<>();
    for(Profit p :profitRepository.findAll() ) {
    	graphData.put(p.getMonth(),profitService.getAllGain(p.getIncome(), p.getOutcome()));
    }
    return new ResponseEntity<>(graphData, HttpStatus.OK);
}*/



 //bestproductselonlaquantite
 //http://localhost:8091/api/bestproductquantity
    @GetMapping("/bestproductquantity")
	//@Secured("ROLE_ADMIN")
	private List<Product1>  getBestprod(){
		List<Product1>  bestproduct =new ArrayList<>();
		List<Product1> p1 = productRepository.findAll();
		
		for (Product1  x: p1 ) {
			if(x.getQuantity() <20) {
				bestproduct.add(x);
			}
			
		}
		 return bestproduct;
	
	}

 //outcome,income,marge ,total income,total outcome,total marge
 //http://localhost:8091/api/getTodayRevenueDash
 @GetMapping("/getTodayRevenueDash")
 
	@ResponseBody public ResponseEntity<?> getGain1()
	{
		
		HashMap<String, Object> k = profitService.getTodayRevenueDash();
	  return  ResponseEntity.status(HttpStatus.ACCEPTED).body(k);	
	}
 
 
 private static int r =0;
 
 @RequestMapping("/random")
 public int getRandomNumber(){
     return new   Random().nextInt() % 50;
 }
 
 
//http://localhost:8091/api/visited
    @RequestMapping("/visited")
 public int  getvisiteder() {
 	this.r++;
 	return  r;
 }
 
 @RequestMapping("lvisit")
 //@HystrixCommand(fallbackMethod = "defaultSpinResult")
 public String visited(){
 	 return String.format("%s",getVisitor());
 	
 }
private String getVisitor(){
 	
 	
     int randomNumber = restTemplate.getForObject("http://localhost:8091/api/visited", Integer.class);
    
   
      
     return    Integer.toString(randomNumber);
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


