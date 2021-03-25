/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.project0.esprit.service;

import com.project0.esprit.datentity.*;

import com.project0.esprit.repository.*;

import java.security.Principal;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;


@Service
public class UserService {

	
    private final UserRepository userRepository;
    private final RoleRepository roleRepository;
    @Autowired
    private PasswordEncoder bcryptEncoder;

    @Autowired
    public UserService(UserRepository userRepository, RoleRepository roleRepository) {
        this.userRepository = userRepository;
        this.roleRepository = roleRepository;
    }

    public User saveUser(User user) {

        User existingUser = userRepository.findOneByUsername(user.getUsername());

        Role userRole = new Role(RoleEnum.ROLE_USER.toString());
        roleRepository.save(userRole);

        String password = bcryptEncoder.encode(user.getPassword());
        user.setPassword(password);
        user.setRoles(Arrays.asList(userRole));
        if (existingUser != null) {
            throw new IllegalArgumentException("Username already exists exception");
        }
        return userRepository.save(user);
    }

    public List<User> getAllUsers(boolean includeAdmins) {
        if (includeAdmins) {
            return userRepository.findAll();
        } else {
            return userRepository.findAll().stream()
                .filter(
                    u -> u.getRoles().stream()
                        .noneMatch(role -> role.getRole().equals(RoleEnum.ROLE_ADMIN.name()))
                ).collect(Collectors.toList());
        }
    }
   
     public  User  editProfile (Principal user, Lprofile l) {
    	 
         User u  = userRepository.findOneByUsername(user.getName());
         
        /// l.setEdited(true);
         u.setId(u.getId());
         u.setLprofile(l);
         
         return userRepository.save(u);
         
           
         
         
        
    	 
    	 
    	  //return null;
     }
    public void deleteUserById(Long id) {
        userRepository.deleteById(id);
    }

}
