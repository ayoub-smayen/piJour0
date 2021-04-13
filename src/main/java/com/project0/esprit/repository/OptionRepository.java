/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.project0.esprit.repository;

import com.project0.esprit.datentity.*;
import org.springframework.data.repository.CrudRepository;

 public interface OptionRepository extends CrudRepository<Option, Long> {
    
    void deleteByPollId(Long id);
    
}
