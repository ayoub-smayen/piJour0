package com.project0.esprit.service;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project0.esprit.entity.Commande;
import com.project0.esprit.entity.Facture;
import com.project0.esprit.entity.Lignecommandeproduit;
import com.project0.esprit.repository.CommandeRepository;
import com.project0.esprit.repository.FactureRepository;
import com.project0.esprit.repository.LigneCommandeRepository;
import com.project0.esprit.repository.UserRepository;


@Service
public class FactureImpl implements IFacture {

@Autowired
FactureRepository factureRepository;

@Autowired
CommandeRepository commandeRepository;

@Autowired
LigneCommandeRepository ligneCommandeRepository;

@Autowired
UserRepository userRepository;


public Facture  Ajouter (long idCommande)
{
	Commande c =commandeRepository.getOne(idCommande);
	Facture f = new Facture();
	f.setDate(LocalDate.now());
	f.setType("non");
	f.setCommande(c);
	return factureRepository.save(f);
}

public Facture findOne(Long id) {
	return factureRepository.getOne(id);
}


public List<Facture> findAll() {
	return factureRepository.findAll();
}


public Facture  save ( Facture f)
{
	f.setDate(LocalDate.now());
	return factureRepository.save(f);
}

public Facture  FactureByCommande ( Commande c)
{
	return factureRepository.FactureParCommander(c);
}


public void Delete(Facture f) {
	factureRepository.delete(f);
}


public List<Lignecommandeproduit> FactureParIdUser( long id) {
	return factureRepository.FactureParIdUser(id);

}

public void ajouterUneFacture (long Commande_id){
	List<Facture> lf = factureRepository.findAll();
	Commande c = commandeRepository.getOne(Commande_id);
	System.out.print(c);
	  
	  boolean verif = false;
	    for (Facture z : lf)
	    {
	    	if(z.getCommande().getId() == Commande_id)
	    	{
	    		verif = true;
	    	}
		}
	    if(verif == false){
	    Facture f = new Facture();
		f.setType(c.getTypedePayment());
		ZoneId zid = ZoneId.of("Africa/Tunis");
		f.setDate(LocalDate.now(zid));
		f.setCommande(c);
		factureRepository.save(f);
	    }
        }
 
public List<Lignecommandeproduit> CreePDF (long id){
	List<Lignecommandeproduit> l = ligneCommandeRepository.panierParIdCommande(id);
	return l;
}
}

