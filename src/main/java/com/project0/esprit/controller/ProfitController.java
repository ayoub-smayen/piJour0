package com.project0.esprit.controller;

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

import com.project0.esprit.entity.Profit;
import com.project0.esprit.service.ProfitService;




@RequestMapping(path="api")
@RestController
@CrossOrigin("*")

public class ProfitController {

	@Autowired
	private ProfitService profitservice;
	
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

	
	@GetMapping("/profit/{income}/{outcome}/{salary}")
	  
	@ResponseBody public ResponseEntity<?>  getGain(@PathVariable("income") double income,@PathVariable("outcome") double outcome, @PathVariable("salary") double salary ){
		
		Double k = profitservice.getAllGain(income, outcome, salary);
	  return  ResponseEntity.status(HttpStatus.ACCEPTED).body(k);	
	}
	
	
	
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
  
	
}
