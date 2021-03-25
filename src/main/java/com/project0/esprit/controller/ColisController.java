package com.project0.esprit.controller;

import java.util.ArrayList;
import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.project0.esprit.entity.Colis;
import com.project0.esprit.entity.Etat;
import com.project0.esprit.repository.ColisRepository;
import com.project0.esprit.service.ColisService1;

@RestController
@RequestMapping("api")
@CrossOrigin("*")
public class ColisController {
	
	
	
	@Autowired
	ColisRepository colisrepo;
	
	
	@Autowired
    ColisService1 service;
 
    @GetMapping("/pagColis")
    public ResponseEntity<List<Colis>> getAllEmployees(
                        @RequestParam(defaultValue = "0") Integer pageNo, 
                        @RequestParam(defaultValue = "10") Integer pageSize,
                        @RequestParam(defaultValue = "prenom") String sortBy) 
    {
        List<Colis> list = service.getAllEmployees(pageNo, pageSize, sortBy);
 
        return new ResponseEntity<List<Colis>>(list, new HttpHeaders(), HttpStatus.OK); 
    }
	
	
	@PostMapping("/addcolis")
	//@Secured("ROLE_ADMIN")
	private @ResponseBody ResponseEntity<?> savecolis(@RequestBody Colis coli) throws Exception {
		coli.setAffected(true);
		
		coli.setEtatcolis(Etat.EnAttent);
		
		Colis xc =colisrepo.save(coli);
		
		getAllAttentColis();
		
		return ResponseEntity.status(201).body(xc);
		
	}
	
	
	@PutMapping("/putcolis")
	//@Secured("ROLE_ADMIN")@RequestBody Colis coli
	private @ResponseBody ResponseEntity<?> savecolisEtat() throws Exception {
		//coli.setAffected(true);
		
		//coli.setEtatcolis(Etat.EnAttent);
		List<Colis> colismodif = colisrepo.findAll();
		for (Colis xc : colismodif) {
			colisrepo.findById(xc.getColi_id()).map(etr->{
				 etr.setColi_id( etr.getColi_id());
				 if(etr.getEtatcolis()==Etat.EnAttent)
				etr.setEtatcolis(Etat.enCours);
				 
				return colisrepo.save(etr);
			});
		}
		
		colisrepo.saveAll(colismodif);
		
		
		
		
		
		//Colis xc =colisrepo.save(coli);
		
		return ResponseEntity.status(201).body(colismodif);
		
	}
	
	
	@GetMapping("/colis")
	//@Secured("ROLE_ADMIN")
	private List<Colis> getAllColis(){
		return colisrepo.findAll();
	}
	

	 @GetMapping("/colisEnattent")
	 
	 
	 
	 private @ResponseBody ResponseEntity<?> getAllAttentColis(){
		 
		  List<Colis> enatt = new ArrayList<Colis>();
		  
		  
		  for(Colis l : colisrepo.findAll()) {
			  if(l.getEtatcolis().equals(Etat.EnAttent)) {
				  enatt.add(l);
			  }
		  }
		  
		  
		  
		  
		  
		  
		  return  ResponseEntity.status(201).body(enatt);
		 
		 
	 }
	
}
