package com.project0.esprit.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

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

import com.project0.esprit.entity.Product1;
import com.project0.esprit.entity.Profit;
import com.project0.esprit.repository.ProductRepository;
import com.project0.esprit.service.ProfitService;


@RequestMapping(path="api")
@RestController
@CrossOrigin("*")

public class ProfitController {

	@Autowired
	private ProfitService profitservice;
	@Autowired 
	private ProductRepository productservice;
	
	
	@GetMapping("/profit/get/{profit_id}")
	@ResponseBody
	public Profit retrieveProfit(@PathVariable("profit_id") Long id) {
	return profitservice.retrieveProfit(id);
	}
	
	
	@PostMapping("/profit/add")
	@ResponseBody
	public Profit addProfit(@RequestBody Profit p) {
	  Profit profit = profitservice.addProfit(p);
	return profit;
	}
	/*@PostMapping("/add")
    public @ResponseBody ResponseEntity<Profit> addProfit( Profit p)
	
	{
		
		return new ResponseEntity<Profit>(profitservice.addProfit(p),HttpStatus.CREATED);
	}*/


	
	@PutMapping("/profit/update")
	@ResponseBody
	public Profit modifyProfit(@RequestBody Profit profit) {
	return profitservice.updateProfit(profit);
	}
	/*@PutMapping("/update")
    public @ResponseBody ResponseEntity<Profit> updateProfit( Profit p)

    {
	
	return new ResponseEntity<Profit>(profitservice.updateProfit(p),HttpStatus.ACCEPTED);
    }*/
	
    
	@DeleteMapping("/profit/delete/{user_id}")
	@ResponseBody
	public void removeProfit(@PathVariable("user_id") Long id) 
	{
	profitservice.deleteProfit(id);
	}
	
	@GetMapping("/profitmonth")
	  
	@ResponseBody public ResponseEntity<?>  getGainmonthly( ){
		
		List<Map<String, Double>> k = profitservice.getgainmaithly();
	  return  ResponseEntity.status(HttpStatus.ACCEPTED).body(k);	
	}
  

	@GetMapping("/profit/{income}/{outcome}")
	  
	@ResponseBody public ResponseEntity<?>  getGain(@PathVariable("income") Double income,@PathVariable("outcome") Double outcome ){
		
		Double k = profitservice.getAllGain(income, outcome);
	  return  ResponseEntity.status(HttpStatus.ACCEPTED).body(k);	
	}


	/*@GetMapping("/profit2")
	  
	@ResponseBody public ResponseEntity<?> getGain2()
	{
		
		HashMap<String, Object> k =  profitservice.getBestProduct();
	  return  ResponseEntity.status(HttpStatus.ACCEPTED).body(k);	
	}*/
	
/*	@GetMapping("/dashboard2")
	//@Secured("ROLE_ADMIN")
	private List<Product1>  getBestprod(){
		List<Product1>  bestproduct =new ArrayList<>();
		List<Product1> p1 = productservice.findAll();
		
		for (Product1  x: p1 ) {
			
			if(x.getQuantity() <20) {
				bestproduct.add(x);
			}
			
		}
		
		 return bestproduct;
	
	}*/
	
	


	}

