package com.project0.esprit.controller;

import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.project0.esprit.entity.Claim;
import com.project0.esprit.repository.ClaimRepository;
import com.project0.esprit.service.ClaimServiceImpl;
import com.project0.esprit.util.AffectationClaimImp;


@RestController
@CrossOrigin("*")
@RequestMapping("/apiyessmone")

public class ClaimController {

	@Autowired
	private ClaimRepository claimRepository;
	@Autowired
	private AffectationClaimImp claimservice;

	@Autowired
	private ClaimServiceImpl clService;
	
	
	@PostMapping("/add")
	public void add(@RequestBody Claim claim){
		this.claimRepository.save(claim);
		}
	 
	@GetMapping("/get")
	public List<Claim> getAll(){
		return this.claimRepository.findAll();
	}
	
	@RequestMapping(value = "/findcat/{subject}", method = RequestMethod.GET)
	@ResponseBody
	public List<Claim> findClaim(@PathVariable ("subject")String subject) {
		List<Claim> claim = (List<Claim>) claimRepository.getClaimBySubject(subject);
		return claim;
	}
	
	@RequestMapping(value = "/find/{id}", method = RequestMethod.GET)
	@ResponseBody
	public Claim findClaim(@PathVariable("id") Long id) {
		Claim claim =  claimRepository.getClaimById(id);
		return claim;
	}


	@PutMapping("/updateclaim/{idclaim}")
	@ResponseBody
	public Claim updateclaim(@PathVariable("idclaim") Long idclaim, @RequestBody Claim cl) {
		Claim c = claimRepository.getClaimById(idclaim);
		c.setDesc(cl.getDesc());
		c.setSubject(cl.getSubject());

		
	    claimRepository.save(c);
		return c ;
	}


	
		
	
	@DeleteMapping("/deleteclaim/{idclaim}")
	public List<Claim> deleteClaim(@PathVariable("idclaim") Long idclaim) {
		Claim claim = claimRepository.findById(idclaim)
	      .orElseThrow(() -> new IllegalArgumentException("Invalid claim Id:" +idclaim));
		claimRepository.delete(claim);
		
		List<Claim> cl = (List<Claim>) claimRepository.findAll();
		return cl;
	    }
	
	
	@GetMapping("/getdeliverymanClaims")
	public String getdeliverymanClaims(){
		return this.claimservice.AffectClaim();
	}
	
}
