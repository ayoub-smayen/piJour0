package com.project0.esprit.service.panier;
import java.util.List;

import com.project0.esprit.entity.panier.LigneCommande;
import com.project0.esprit.entity.panier.lignecommandeproduit;




public interface ILigneCommande {
	public LigneCommande findOne(Long id);
	
	public List<lignecommandeproduit> panierParIdclient( long id);
	
	public List<LigneCommande> findAll();
	
	public LigneCommande findLigneCommande(Long idProduit,Long idClient,Long idCommande);
	
	public List<lignecommandeproduit> AjouterAuPanier(long idprod, long iduser,LigneCommande lc );
	
	public LigneCommande save(LigneCommande lc);
	
	public void deleteLigne(long idLigneCommande);
}