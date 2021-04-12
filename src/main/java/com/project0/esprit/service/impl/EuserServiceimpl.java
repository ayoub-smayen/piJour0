package com.project0.esprit.service.impl;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.project0.esprit.entity.Euser;
import com.project0.esprit.exception.EuserNotFoundException;
import com.project0.esprit.repository.EuserRepository;
import com.project0.esprit.service.EuserService;

@Service
public class EuserServiceimpl implements EuserService {
    @Autowired
	EuserRepository userRepository;
    @Autowired
    EuserService euserservice;
	private static final Logger L=LogManager.getLogger(EuserServiceimpl.class);
	
	
	@Override
	public Euser addUser(Euser u) {
		return userRepository.save(u);
		
	}

	@Override
	public Euser updateUser(Euser u) {
		return userRepository.save(u);
		
	}

	@Override
	public void deleteUser(Long id) {
		userRepository.deleteById(id);
		
	}

	@Override
	public Euser retrieveUser(Long id) {
		Euser u =userRepository.findById(id).get();
		L.info("user returned :" + u);
			return u;
	}

	@Override
	public List<Euser> retrieveAllUsers() {
		
		return  (List<Euser>)  userRepository.findAll() ;
	}
	

	@Override
	public Euser findByIdd(Long user_id) throws EuserNotFoundException
	{
	Euser user = euserservice.findByIdd(user_id);
    	if (user != null)
			return user;
		else
			throw new EuserNotFoundException();
	}

	
}

