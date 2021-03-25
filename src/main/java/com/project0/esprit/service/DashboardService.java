package com.project0.esprit.service;

import java.util.List;

import com.project0.esprit.datentity.User;
import com.project0.esprit.entity.Dashboard;

import com.project0.esprit.entity.Product1;





public interface DashboardService {

	 Dashboard addDashboard(Dashboard d);
	   Dashboard updateDashboard(Dashboard d);
	   void deleteDashboard(Long id);
	   Dashboard retrieveDashboard(Long id);
	   
	   
	   List<Product1> getBesProducts();
	   
	   List<User> getAllUser();
	   
	   User deleteUserPermit(User u);
	   
	   
	   
	   
	    
	   
}
