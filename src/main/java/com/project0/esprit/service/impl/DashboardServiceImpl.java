package com.project0.esprit.service.impl;


import java.util.List;

import javax.transaction.Transactional;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project0.esprit.datentity.Role;
import com.project0.esprit.datentity.User;
import com.project0.esprit.entity.Dashboard;

import com.project0.esprit.repository.DashboardRepository;

import com.project0.esprit.service.DashboardService;
import com.project0.esprit.service.UserService;

@Service
public class DashboardServiceImpl implements DashboardService {
	
	
	
	 private final UserService userService;
	
	
	private final DashboardRepository dashBoardRepo;
	@Autowired
	DashboardServiceImpl( UserService userService,DashboardRepository dashBoardRepo){
		this.dashBoardRepo = dashBoardRepo;
		this.userService = userService;
		
	}
	
	private static final Logger L=LogManager.getLogger(DashboardServiceImpl.class);

	@Transactional
	@Override
	public Dashboard addDashboard(Dashboard d) {
		return dashBoardRepo.save(d);
	}

	@Transactional
	@Override
	public Dashboard updateDashboard(Dashboard d) {
		return dashBoardRepo.save(d);
	}

	@Transactional
	@Override
	public void deleteDashboard(Long id) {
		dashBoardRepo.deleteById(id);
		
	}

	@Transactional
	@Override
	public Dashboard retrieveDashboard(Long id) {
		Dashboard d =dashBoardRepo.findById(id).get();
		L.info("dashboard returned :" + d);
			return d;
	}
	
	
	/////////////?????????,
	
	@Transactional
	@Override
	public List<User> getAllUser() {
	return userService.getAllUsers(false);
	}

	@Transactional
	@Override
	public User deleteUserPermit(User u) {
		
		 for(Role r : u.getRoles()) {
			  if(r.getRole() =="ROLE_ADMIN") {
				  L.error("you  can t  delete  a admin");
				  return null;
			  }
			  
			  userService.deleteUserById(u.getId());
				 
			  
		 }
		 return u;
	}



	

}
