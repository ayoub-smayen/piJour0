package com.project0.esprit.controller;

import java.util.Map;
import java.util.TreeMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.project0.esprit.entity.Euser;
import com.project0.esprit.repository.EuserRepository;
 
@RestController
@RequestMapping("api")
@CrossOrigin("*")
public class HighChartController {
	
	@Autowired
	
	private EuserRepository euserrep;
	
 
	
	
    @GetMapping("/get-data")
    public ResponseEntity<Map<String, Integer>> getPieChart() {
        Map<String, Integer> graphData = new TreeMap<>();
        
          
        
        
        for(Euser e :euserrep.findAll() ) {
        	
        	
        	graphData.put(e.getCity(),   euserrep.getCityCount(e.getCity())  );
        }
      //  graphData.put("2016", 147);
        //graphData.put("2017", 1256);
        //graphData.put("2018", 3856);
        //graphData.put("2019", 19807);
        return new ResponseEntity<>(graphData, HttpStatus.OK);
    }
}