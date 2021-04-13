package com.project0.esprit.service;

import java.util.List;

import com.project0.esprit.entity.Euser;
import com.project0.esprit.exception.EuserNotFoundException;


public interface EuserService {
   Euser addUser(Euser u);
   Euser updateUser(Euser u);
   void deleteUser(Long id);
   Euser retrieveUser(Long id);
   List< Euser> retrieveAllUsers();
   Euser findByIdd( Long user_id) throws EuserNotFoundException;
}

