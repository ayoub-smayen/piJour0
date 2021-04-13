package com.project0.esprit.service.panier;

import java.util.List;

import com.project0.esprit.entity.panier.Commande;





public interface ICommande {
	
	public Commande save (Commande c);
	
	public List<Commande> CommandeparType(String type);
	
	public List<Commande> CommandeparClient(int id);
	
	public List<Commande> findAll();
	
	public void Delete(Commande c);
	
	public Commande findOne(Long id);
	
	public void PayerEnLigne(Long idCommande,int iduser);
	
	
	public void PayerPorteaPorte(long idCommande,int iduser);
	
}
