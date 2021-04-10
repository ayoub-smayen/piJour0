/*package com.project0.esprit.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.project0.esprit.entity.Euser;
import com.project0.esprit.entity.Product1;
import com.project0.esprit.entity.Profit;
import com.project0.esprit.repository.EuserRepository;
import com.project0.esprit.repository.ProductRepository;
import com.project0.esprit.repository.ProfitRepository;
import com.project0.esprit.service.ProductService;
import com.project0.esprit.service.ProfitService;
 
@RestController
@RequestMapping("api")
@CrossOrigin("*")
public class HighChartController {
	
	@Autowired
	private EuserRepository euserrep;
	@Autowired
	private ProfitRepository profitRepository;
	@Autowired
	private ProfitService profitService;
	
	 @Autowired
	 ProductService productservice;

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
    
     @GetMapping("/get-data1")
    public ResponseEntity<?> getPieChart1() {
        Map<String, Double> graphData = new TreeMap<>();
        for(Profit p :profitRepository.findAll() ) {
        	graphData.put(p.getMonth(),profitService.getAllGain(p.getIncome(), p.getOutcome()));
        }
        return new ResponseEntity<>(graphData, HttpStatus.OK);
    
    
    }
    
     
}*/