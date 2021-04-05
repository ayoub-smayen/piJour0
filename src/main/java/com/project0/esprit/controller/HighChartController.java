package com.project0.esprit.controller;

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
import com.project0.esprit.entity.Profit;
import com.project0.esprit.repository.EuserRepository;
import com.project0.esprit.repository.ProfitRepository;
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
    
  /*  @GetMapping("/get-data1")
    public ResponseEntity<Map<String, Integer>> getPieChart1() {
        Map<String, Integer> graphData = new TreeMap<>();
        List<Profit> p = (List<Profit> ) ;

        	graphData.put(p.getGain() );
        	
        	
        }
        return new ResponseEntity<>(graphData, HttpStatus.OK);
    }*/
    
    
  /*  @RequestMapping(value = "/dashboardearnings", method = RequestMethod.GET)
	public DashboardEarnings dashboardEarnings() {
		DashboardEarnings dashboardEarnings = new DashboardEarnings();
		dashboardEarnings.setInstanceCount("10");
		dashboardEarnings.setMonth("Dec 2017");
		dashboardEarnings.setTotal("$735");
		List<String> instancesList = new ArrayList<>();
		instancesList.add("cloud-asia-instance-active");
		instancesList.add("pacific-flex-cloud");
		instancesList.add("randy-iron-man-cloud");
		instancesList.add("fierce-river-71956");
		instancesList.add("container-fluid-45566");
		instancesList.add("engine-heroku-8906");
		instancesList.add("mike-543-cloud-repo");
		instancesList.add("james-fire-flex-1232");
		instancesList.add("cloud-pacific-repo");
		instancesList.add("sandy-us-ea-asia-cloud");
		dashboardEarnings.setInstances(instancesList);
		List<Integer> instancesAmount = new ArrayList<>();
		instancesAmount.add(89);
		instancesAmount.add(67);
		instancesAmount.add(100);
		instancesAmount.add(45);
		instancesAmount.add(35);
		instancesAmount.add(90);
		instancesAmount.add(55);
		instancesAmount.add(71);
		instancesAmount.add(95);
		instancesAmount.add(88);
		dashboardEarnings.setInstancesAmount(instancesAmount);
		return dashboardEarnings;
	}*/
    
    

 
    ///////////////////////
   /* @RequestMapping(value = "/profit", method = RequestMethod.GET)
  	public Profit profit() {
  		Profit profit = new Profit();
  		profit.setIncome("10");
  		profit.setOutcome("2017");
  		profit.setSalary("$735");
  	    List<String> instancesList = new ArrayList<>();
		instancesList.add("cloud-asia-instance-active");
		instancesList.add("pacific-flex-cloud");
		instancesList.add("randy-iron-man-cloud");
		instancesList.add("fierce-river-71956");
		instancesList.add("container-fluid-45566");
		instancesList.add("engine-heroku-8906");
		instancesList.add("mike-543-cloud-repo");
		instancesList.add("james-fire-flex-1232");
		instancesList.add("cloud-pacific-repo");
		instancesList.add("sandy-us-ea-asia-cloud");
		profit.setInstances(instancesList);
		List<Integer> instancesAmount = new ArrayList<>();
		instancesAmount.add(89);
		instancesAmount.add(67);
		instancesAmount.add(100);
		instancesAmount.add(45);
		instancesAmount.add(35);
		instancesAmount.add(90);
		instancesAmount.add(55);
		instancesAmount.add(71);
		instancesAmount.add(95);
		instancesAmount.add(88);
		profit.setInstancesAmount(instancesAmount);
		return profit;
	}*/
    
       
       /* @GetMapping("/get-data1")
        public ResponseEntity<Map<Integer, Integer>> getPieChart1() {
            Map<Integer, Integer> graphData = new TreeMap<>();
            for(Euser e :euserrep.findAll() ) {
            	graphData.put(e.getAge(),   euserrep.getAgeCount(e.getAge())  );
            }
      //  graphData.put("2016", 147);
        //graphData.put("2017", 1256);
        //graphData.put("2018", 3856);
        //graphData.put("2019", 19807);
        return new ResponseEntity<>(graphData, HttpStatus.OK);
    }*/
   /* @GetMapping("/get-data")
    public ResponseEntity<Map<Integer, Integer>> getPieChart() {
        Map<String, Integer> graphData = new TreeMap<>();
        Map<Integer, Integer> graphData1=new TreeMap<>();
        for(Euser e :euserrep.findAll() ) {
        	graphData.put(e.getCity(),   euserrep.getCityCount(e.getCity())  );
        	graphData.put(e.getSexe(),   euserrep.getSexeCount(e.getSexe())  );
        	graphData1.put(e.getAge(),   euserrep.getAgeCount(e.getAge())  );
        	
        }
        return new ResponseEntity<>(graphData1, HttpStatus.OK);
    }*/
}