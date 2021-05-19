package com.project0.esprit.controller;

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
import org.springframework.web.bind.annotation.RestController;

import com.project0.esprit.entity.Commande;
import com.project0.esprit.entity.LigneCommande;
import com.project0.esprit.entity.Lignecommandeproduit;
import com.project0.esprit.entity.Product1;
import com.project0.esprit.repository.CommandeRepository;
import com.project0.esprit.repository.LigneCommandeRepository;
import com.project0.esprit.repository.ProductRepository;
import com.project0.esprit.service.LigneCommandeImpl;






@RestController
@CrossOrigin("*")
@RequestMapping("/Panier")
public class RestLigneCommandeController {
	
	@Autowired
	LigneCommandeImpl ligneCommandeDao;
	@Autowired
	LigneCommandeRepository lignecommanderepo;
	@Autowired
	ProductRepository produitRepository;
	@Autowired
	CommandeRepository commandeRep;
	
	
	@GetMapping("pani/{idUser}")
	public Commande panier(@PathVariable(value = "idUser") Long id) {
	
		return commandeRep.CommandeencoursparClient(id);
	}

	
	//http://localhost:8081/Panier/panier/1
	@GetMapping("panier/{idUser}")
	public List<LigneCommande> panierParIdclient(@PathVariable(value = "idUser") Long id) {
	
		return ligneCommandeDao.panierParIdclient(id);
	}
	
	
	//http://localhost:8081/Panier/ajouter/1/1
	@PostMapping("/ajouter/{idprod}/{iduser}")
	public List<LigneCommande> AjouterLigne (@PathVariable(value = "idprod") Long idprod,@PathVariable(value = "iduser") Long iduser,
			 @RequestBody LigneCommande lc) {
	
		
		
		
			ligneCommandeDao.AjouterAuPanier(idprod, iduser, lc);
		
		return ligneCommandeDao.panierParIdclient(iduser);
	}
	
	@DeleteMapping("DeleteLigne/{idLigne}")
	public void DeleteLigne(@PathVariable(value = "idLigne") Long idLigneCommande)
	{
		ligneCommandeDao.deleteLigne(idLigneCommande);
	}
	
	
	
	//http://localhost:8081/Panier/update/8/6
	@PutMapping("update/{idLigne}/{qty}")
	 public void updateLigne(@PathVariable(value = "idLigne")long idL,@PathVariable(value = "qty")int quantity)
	 {
		 ligneCommandeDao.updateLigne(idL, quantity); 
	 }
	
	
	@PutMapping("/update2")
	 public void updateLigneCommande(@RequestBody LigneCommande lc)
	 {    
		 
		 ligneCommandeDao.updateLignecomande(lc);
	 }
	
}

	