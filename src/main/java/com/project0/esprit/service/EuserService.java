package com.project0.esprit.service;

import java.util.List;

import com.project0.esprit.entity.Euser;

public interface EuserService {

	
   Euser addUser(Euser u);
   Euser updateUser(Euser u);
   void deleteUser(Long id);
   Euser retrieveUser(Long id);
   List< Euser> retrieveAllUsers();
   void updateUserByFirstName(String membre_name ,Long id);
 //  Euser findByUsername(String membre_name ); 
}

