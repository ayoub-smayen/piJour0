package com.project0.esprit.controller;

import java.util.Date;
import java.util.ArrayList;
import java.util.List;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.project0.esprit.entity.Commande;
import com.project0.esprit.repository.CommandeRepository;
import com.project0.esprit.service.CommandeImpl;





@RestController
@CrossOrigin("*")
@RequestMapping("/Commande")
public class RestControllerCommande {
	
	@Autowired
	CommandeImpl commandeDao;
	
	@Autowired
	CommandeRepository commandeRepository;

	
	//http://localhost:8081/Commande/ajouter
	@PostMapping("/ajouter")
	public Commande AjouterCommande( @RequestBody Commande c)
	{
		return commandeDao.save(c);
	}
	
	
	//http://localhost:8081/Commande/afficher
	@GetMapping("/afficher")
	//@ResponseBody
	public List<Commande> getAllCommande() {
		return commandeDao.findAll();
	}
	
	
	//http://localhost:8081/Commande/delete/{id}
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<Commande> DeleteCommande(@PathVariable(value = "id") Long idCommande) {
		Commande c =commandeDao.findOne(idCommande);
		if ( c == null) {
			return ResponseEntity.notFound().build();
		}
		commandeDao.Delete(c);
		return ResponseEntity.ok().build();
	}
	
	


	//http://localhost:8081/Commande/rechercheparcode/{type}
	@GetMapping("/recherchetype/{type}")
	public List<Commande> CommandeparType(@PathVariable(value = "type") String type) {
		return commandeDao.CommandeparType(type);
	}
	
	
	//http://localhost:8081/Commande/rechercheparclient/{idClient}
	@GetMapping("/rechercheparclient/{idClient}")
	public List<Commande> CommandeparClient(@PathVariable(value = "idClient") int id) {
		return commandeDao.CommandeparClient(id);
	}
	//http://localhost:8081/Commande/payerenligne/{idCommande}/{idClient}
	@PutMapping("/payerenligne/{idCommande}/{idClient}")
	public void PayerEnLigne(@PathVariable(value = "idCommande")long idCommande,@PathVariable(value = "idClient") int id)
	{
		commandeDao.PayerEnLigne( idCommande,id);
	}
	
	//http://localhost:8081/Commande/payerporteaporte/{idCommande}/{idClient}
	@PutMapping("/payerporteaporte/{idCommande}/{idClient}")
	public void PayerPorteaPorte(@PathVariable(value = "idCommande")long idCommande,@PathVariable(value = "idClient") int id)
	
		{
			commandeDao.PayerPorteaPorte( idCommande,id);
		}
	
   @GetMapping("/rechercheparclientencours/{idClient}")
   public Commande getCommandeBystatusEncours(@PathVariable(value = "idClient")long idClient)
   {
	   return commandeRepository.CommandeencoursparClient(idClient);
   }
   
   @PutMapping("/statusEnligne/{idCommande}")
	public void EnligneState(@PathVariable(value = "idCommande")long idCommande)
	
		{
			commandeRepository.enlignepayment(idCommande);
		}
   @PutMapping("/statusDelivery/{idCommande}")
	public void deliveryState(@PathVariable(value = "idCommande")long idCommande)
	
		{
			commandeRepository.deliverypayment(idCommande);
		}
}
	
	
