package com.project0.esprit.service.impl;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project0.esprit.entity.Profit;
import com.project0.esprit.repository.ProfitRepository;
import com.project0.esprit.service.ProfitService;
import  java.math.*;

@Service
public class ProfitServiceImpl implements ProfitService {
    @Autowired
	ProfitRepository profitRepository;
	private static final Logger L=LogManager.getLogger(ProfitServiceImpl.class);
	
	@Override
	public Profit addProfit(Profit p) {
		return profitRepository.save(p);
	}
	@Override
	public Profit updateProfit(Profit p) {
		return profitRepository.save(p);
	}
	@Override
	public void deleteProfit(Long id) {
		profitRepository.deleteById(id);
		
	}
	@Override
	public Profit retrieveProfit(Long id) {
		Profit p =profitRepository.findById(id).get();
		L.info("profit returned :" + p);
			return p;
	}
	@Override
	public double getAllGain(double income, double outcome, double salary) {
		 double res = 0.0;
		  List<Profit> p = (List<Profit> )  profitRepository.findAll();
		  
		  
		for ( Profit s : p) {
			
			
			 Double max_income =  (double) (s.getIncome()  < income ?   income : s.getIncome()) ;
			 
			 Double max_outcome =  (double) (s.getOutcome()  < outcome ?   outcome : s.getOutcome()) ;
			 
			 
			 Double max_salary =    (double) (s.getSalary()  < salary ?   salary : s.getSalary()) ;
			 
			 res = (res +       ( max_income -max_outcome)  /     (max_income ))   *1  ;
			 System.out.println(  ( max_income -max_outcome )  /     (max_income));
			 System.out.println(res);
			 
			
		}
		
		return res ;
	}
}