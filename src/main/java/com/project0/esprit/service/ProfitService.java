package com.project0.esprit.service;
import com.project0.esprit.entity.Profit;
public interface ProfitService {

	Profit addProfit(Profit d);
	   Profit updateProfit(Profit d);
	   void deleteProfit(Long id);
	   Profit retrieveProfit(Long id);
	   
	   
	   
	   double getAllGain(double income , double outcome , double salary);
	   
}
