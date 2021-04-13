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
	
	//http://localhost:8091/api/profit/get/{profit_id}
	@GetMapping("/profit/get/{profit_id}")
	@ResponseBody
	public Profit retrieveProfit(@PathVariable("profit_id") Long id) {
	return profitservice.retrieveProfit(id);
	}
	
	
	//http://localhost:8091/api/profit/add
	@PostMapping("/profit/add")
    public @ResponseBody ResponseEntity<Profit> addProfit( Profit p)
	
	{
		
		return new ResponseEntity<Profit>(profitservice.addProfit(p),HttpStatus.CREATED);
	}


	
	//http://localhost:8091/api/profit/update/{profit_id}
	@PutMapping("/profit/update/{profit_id}")
    public @ResponseBody ResponseEntity<Profit> updateProfit( Profit p)

    {
	
	return new ResponseEntity<Profit>(profitservice.updateProfit(p),HttpStatus.ACCEPTED);
    }
	
	
	//http://localhost:8091/api/profit/delete/{profit_id}
	@DeleteMapping("/profit/delete/{profit_id}")
	@ResponseBody
	public void removeProfit(@PathVariable("profit_id") Long id) 
	{
	profitservice.deleteProfit(id);
	}
	
	


	}

