package com.project0.esprit.service.impl;

import java.security.Principal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project0.esprit.datentity.Publication;
import com.project0.esprit.datentity.User;
import com.project0.esprit.repository.PublicationRepository;
import com.project0.esprit.repository.UserRepository;
import com.project0.esprit.service.IPublicationInterface;
@Service
public class PublicationService implements IPublicationInterface {
	
	
	
	
	PublicationRepository publicationRep;
	
	
	private  UserRepository userRepository;
	
	@Autowired
	PublicationService(PublicationRepository publicationRep,UserRepository userRepository )
	{
		this.publicationRep = publicationRep;
		this.userRepository = userRepository;
	}
	

	@Override
	public Publication AddPublication(Publication c, Principal p) {
		User user = userRepository.findOneByUsername(p.getName());
	      c.setUser(user);
	      
	      Publication pub = publicationRep.save(c);
	      return pub;
	      
		//return null;
	}

	@Override
	public List<Publication> RetrievePublication() {
		
		
		return this.publicationRep.findAll();
	}

	@Override
	public void UpdatePublicationById(Publication pub, Long id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void DeletePublication(Long id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Publication GetPubById(Long pubId) {
		// TODO Auto-generated method stub
		return null;
	}

}
