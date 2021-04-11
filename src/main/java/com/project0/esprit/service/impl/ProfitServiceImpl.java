package com.project0.esprit.service.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;



import com.project0.esprit.entity.Profit;
import com.project0.esprit.repository.ProductRepository;
import com.project0.esprit.repository.ProfitRepository;
import com.project0.esprit.service.ProfitService;
import java.text.NumberFormat;

@Service
public  class ProfitServiceImpl implements ProfitService {
    @Autowired
	ProfitRepository profitRepository;
    @Autowired
    ProductRepository productRepository;
    
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
	public Double getAllGain(Double income, Double outcome) {
		Double res = 0.0;
		  List<Profit> p = (List<Profit> )  profitRepository.findAll();
		  
		  
		for ( Profit s : p) {
			
			
			 Double max_income =  (Double) (s.getIncome()  < income ?   income : s.getIncome()) ;
			 
			 Double max_outcome =  (Double) (s.getOutcome()  < outcome ?   outcome : s.getOutcome()) ;
			 res = (res +( max_income-max_outcome)/(max_income ));
			 System.out.println(  ( max_income-max_outcome )/(max_income));
			 System.out.println(res);
			 
			
		}
		
		return res ;
	}
	
	
	
	
    @Override
    public HashMap<String, Object> getTodayRevenueDash() {
        HashMap<String, Object> companyRevenueMap = new HashMap<>();

        List<Profit> profitList = (List<Profit>) profitRepository.findAll();

        List<String> month = new ArrayList<>();
        List<String> income = new ArrayList<>();
        List<String> outcome = new ArrayList<>();
        List<String> margin = new ArrayList<>();
 
        double totalMargin = 0;
        double totalExpense = 0;
        double totalRevenue = 0;

        Locale locale = new Locale("ar", "TN");
        NumberFormat CurrencyFormatter = NumberFormat.getCurrencyInstance(locale);

        for (Profit profit : profitList) {
            month.add(profit.getMonth());
            income.add(String.valueOf(profit.getIncome()));
            outcome.add(String.valueOf(profit.getOutcome()));
            margin.add(String.valueOf(profit.getMargins()));
            totalExpense += profit.getOutcome();
            totalMargin += profit.getMargins();
            totalRevenue += profit.getIncome();
        }

        companyRevenueMap.put("Month", month.toString());
        companyRevenueMap.put("Income", income.toString());
        companyRevenueMap.put("Outcome", outcome.toString());
        companyRevenueMap.put("Margin", margin.toString());
        companyRevenueMap.put("totalMargin", CurrencyFormatter.format(totalMargin));
        companyRevenueMap.put("totalOutcome", CurrencyFormatter.format(totalExpense));
        companyRevenueMap.put("totalIncome", CurrencyFormatter.format(totalRevenue));
        return companyRevenueMap;
    }
	@Override
	public 	List<Map<String , Double>> getgainmaithly() {
		
		
		List<Map<String , Double>> ml =new ArrayList<>();
		
		
		
		
		  List<Profit> p = (List<Profit> )  profitRepository.findAll();
		  
		  Double k = 0.0;
		for ( Profit s : p) {
			Map<String , Double>  hj    =new HashMap<>();
			
			
			if(s.getIncome().equals(k))
			        hj.put(s.getMonth(),( s.getOutcome() - s.getIncome() ));
			 hj.put(s.getMonth(),( s.getOutcome() - s.getIncome() )/s.getIncome());      
			ml.add(hj);
			/*
			 Double max_income =  (Double) (s.getIncome()  < income ?   income : s.getIncome()) ;
			 
			 Double max_outcome =  (Double) (s.getOutcome()  < outcome ?   outcome : s.getOutcome()) ;
			 res = (res +( max_income-max_outcome)/(max_income ));
			 System.out.println(  ( max_income-max_outcome )/(max_income));
			 System.out.println(res);*/
			 
			
		}
		
		return ml ;
		//return null;
	}

   
}

