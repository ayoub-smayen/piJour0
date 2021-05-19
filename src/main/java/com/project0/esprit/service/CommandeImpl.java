package com.project0.esprit.service;



import java.beans.Transient;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.servlet.server.Session;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.project0.esprit.datentity.User;
import com.project0.esprit.entity.Commande;
import com.project0.esprit.entity.LigneCommande;
import com.project0.esprit.entity.Product1;
import com.project0.esprit.repository.CommandeRepository;
import com.project0.esprit.repository.LigneCommandeRepository;
import com.project0.esprit.repository.ProductRepository;
import com.project0.esprit.repository.UserRepository;




@Service
public class CommandeImpl implements ICommande {
	
	@Autowired
	CommandeRepository commandeRepository;
	
	@Autowired
	LigneCommandeRepository ligneCommandeRepository;

	@Autowired
	UserRepository userRepository;

	@Autowired
	LigneCommandeImpl ligneImpl;
	
	@Autowired
	ProductRepository produitRep;
	
	   @PostConstruct
	    public void init() {
		 
	       
	    }

	public Commande save (Commande c)
	{
	    
	ZoneId zid = ZoneId.of("Africa/Tunis");
	c.setDate(LocalDate.now(zid));
	return commandeRepository.save(c);
	}
	
    
	public List<Commande> CommandeparType(String type) {
		return commandeRepository.CommandeparType(type);

	}
	
	
	public List<Commande> CommandeparClient(int id) {
		return commandeRepository.CommandeparClient(id);

	}
	
	
	@Transactional
	public List<Commande> findAll() {
		return commandeRepository.findAll();
	}
	
	
	public void Delete(Commande c) {
		commandeRepository.delete(c);
	}

	public Commande findOne(Long id) {
		return commandeRepository.getOne(id);
	}
	
	public void PayerEnLigne(Long idCommande,int iduser)
	{
		Commande c = commandeRepository.getOne((long) idCommande);
		User u =userRepository.findById((long) iduser).get();
		List<LigneCommande> listligneCommande = ligneCommandeRepository.ligneCommandeparCommande(c.getId());
		for (LigneCommande a : listligneCommande){
			Product1 p = produitRep.getOne(a.getProduit().getProduct_id());
			p.setNbreVente(p.getNbreVente()+a.getQuantity());
		}
		// u.setPointFidelite(Math.round((int) c.getMontant()/ 10));
		 u.setCoins(     u.getCoins()  +   (long) c.getMontant());
		 userRepository.save(u);
		 commandeRepository.PayerEnLigne(idCommande);
		 commandeRepository.remise(iduser);
		
	}
	
	
	public void PayerPorteaPorte(long idCommande,int iduser)
	{
		Commande c = commandeRepository.getOne((long) idCommande);
		User u =userRepository.findById((long) iduser).get();
		List<LigneCommande> listligneCommande = ligneCommandeRepository.ligneCommandeparCommande(c.getId());
		for (LigneCommande a : listligneCommande){
			Product1 p = produitRep.getOne(a.getProduit().getProduct_id());
			p.setNbreVente(p.getNbreVente()+a.getQuantity());
		}
		// u.setPointFidelite(Math.round((int) c.getPourcentageDeRemise()/ 10));
		 u.setCoins(     u.getCoins()  +   (long) c.getMontant());
		 userRepository.save(u);
			commandeRepository.PayerPorteaPorte(idCommande);
			if(ligneImpl.PrixTotalCommande(iduser)>5000) 
			commandeRepository.remise(iduser);
	}
}
	