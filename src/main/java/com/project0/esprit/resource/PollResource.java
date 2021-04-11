/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.project0.esprit.resource;

import com.project0.esprit.datentity.*;
import com.project0.esprit.service.*;
import java.security.Principal;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;

/*
 * 
 *  poll2.setIpAdresses(Arrays.asList("192.1.2.164"));
 */
@RestController
@RequestMapping("/api1/polls")
@CrossOrigin("*")
public class PollResource {

    @Autowired
    private PollService pollService;

    @GetMapping()
    public List<Poll> list() {
        return pollService.getAll();
    }

    @GetMapping("/user/{username}")
    @Secured("ROLE_USER")
    public List<Poll> getUserPolls(@PathVariable String username, Principal p) {
        
        if (username.equals(p.getName())) {
            return pollService.getAllForUser(username);
        } else {
            return pollService.getAllVisibleForUser(username);
        }
    }

    @GetMapping("/{id}")
    public Poll get(@PathVariable String id) {
        return pollService.getPollById(Long.parseLong(id));
    }

    @PutMapping("/{id}")
    @Secured("ROLE_USER")
    public ResponseEntity<?> put(@PathVariable Long id, @RequestBody Poll poll) {
        poll.setId(id);
        Poll updatePoll = pollService.updatePoll(poll);
        return ResponseEntity.ok(updatePoll);

    }

    @PostMapping
    @Secured("ROLE_USER")
    public ResponseEntity<?> post(@RequestBody Poll poll, Principal p) {
        Poll savedPoll = pollService.savePoll(poll, p.getName());
        return ResponseEntity.status(201).body(savedPoll);
    }

    @Secured("ROLE_USER")
    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id, Principal p) {
        pollService.deletePollById(id);
        return ResponseEntity.status(204).build();

    }

    @PostMapping("{id}/vote/{optionId}")
    public ResponseEntity<?> post(@PathVariable Long id, @PathVariable Long optionId, HttpServletRequest request) throws Exception {
        pollService.vote(id, optionId, request.getRemoteAddr());
        return ResponseEntity.ok().build();
    }
}
