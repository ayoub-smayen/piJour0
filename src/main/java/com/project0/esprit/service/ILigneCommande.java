package com.project0.esprit.service;

import java.util.List;

import com.project0.esprit.entity.LigneCommande;
import com.project0.esprit.entity.Lignecommandeproduit;





public interface ILigneCommande {
	public LigneCommande findOne(Long id);
	
	public List<	LigneCommande> panierParIdclient( long id);
	
	public List<LigneCommande> findAll();
	
	public LigneCommande findLigneCommande(Long idProduit,Long idClient,Long idCommande);
	
	public List<LigneCommande> AjouterAuPanier(long idprod, long iduser,LigneCommande lc );
	
	public LigneCommande save(LigneCommande lc);
	
	public void updateLigne(long idL,int quantity);
	
	public void updateLignecomande(LigneCommande lc);
	
	public void deleteLigne(long idLigneCommande);
}