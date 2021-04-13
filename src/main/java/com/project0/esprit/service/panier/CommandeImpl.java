package com.project0.esprit.service.panier;

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

import com.project0.esprit.entity.Euser;
import com.project0.esprit.entity.User1;
import com.project0.esprit.entity.panier.Commande;
import com.project0.esprit.repository.EuserRepository;
import com.project0.esprit.repository.UserRepository1;
import com.project0.esprit.repository.panier.CommandeRepository;
import com.project0.esprit.repository.panier.LigneCommandeRepository;




@Service
public class CommandeImpl implements ICommande {
	
	@Autowired
	CommandeRepository commandeRepository;
	
	@Autowired
	LigneCommandeRepository ligneCommandeRepository;

	@Autowired
	EuserRepository userRepository;

	@Autowired
	LigneCommandeImpl ligneImpl;
	
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
		Euser u =userRepository.findById((long) iduser).get();
		 u.setPointFidelite(Math.round((int) c.getMontant()/ 10));
		 userRepository.save(u);
			commandeRepository.PayerEnLigne(idCommande);
			commandeRepository.remise(iduser);
		
	}
	
	
	public void PayerPorteaPorte(long idCommande,int iduser)
	{
		Commande c = commandeRepository.getOne((long) idCommande);
		Euser u =userRepository.findById((long) iduser).get();
		 u.setPointFidelite(Math.round((int) c.getPourcentageDeRemise()/ 10));
		 userRepository.save(u);
			commandeRepository.PayerPorteaPorte(idCommande);
			if(ligneImpl.PrixTotalCommande(iduser)>5000) 
			
			commandeRepository.remise(iduser);
		
	}
}
	
