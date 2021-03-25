/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.project0.esprit.repository;

import com.project0.esprit.datentity.*;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;


public interface PollRepository extends JpaRepository<Poll, Long> {

    List<Poll> findAllByUser(User user);

    public List<Poll> findAllByUserAndVisible(User user, boolean b);

}
