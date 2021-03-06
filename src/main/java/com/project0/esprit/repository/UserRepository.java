/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.project0.esprit.repository;

import com.project0.esprit.datentity.*;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;



@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    User findOneByUsername(String username);

    @Query("SELECT u FROM User u JOIN FETCH u.roles WHERE u.username = (:username)")
    User findByUsernameAndFetchRoles(@Param("username") String username);
    
    
    
    @Query("SELECT u FROM User u  WHERE u.roles =?1")
    User findAdmin(@Param("role") String role);
    
    
    @Query("SELECT u FROM User u  WHERE u.username = (:username)")
    User findByUsername(@Param("username") String username);
}
