package com.project0.esprit.service;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.project0.esprit.entity.Profit;
public interface ProfitService {

	Profit addProfit(Profit d);
	   Profit updateProfit(Profit d);
	   void deleteProfit(Long id);
	   Profit retrieveProfit(Long id);
	   HashMap<String, Object> getTodayRevenueDash();
	   Double getAllGain(Double income , Double outcome );
	 //  HashMap<String, Object> getBestProduct();
		
	List<Map<String , Double>>  getgainmaithly();
	   
}
