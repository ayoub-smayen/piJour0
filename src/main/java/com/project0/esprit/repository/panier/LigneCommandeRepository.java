package com.project0.esprit.repository.panier;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.project0.esprit.entity.panier.LigneCommande;
import com.project0.esprit.entity.panier.lignecommandeproduit;










@Repository

public interface LigneCommandeRepository extends JpaRepository<LigneCommande, Long> {
	
	@Query(value = "SELECT  NEW tn.esprit.spring.entity.lignecommandeproduit(l.id,p.id,p.nomProduit,l.quantity,p.prix,l.quantity*p.prix,c.montant) FROM LigneCommande l join l.commande c  join l.produit p   WHERE c.idUser.id=:idc and c.status='en cours'")
	public List<lignecommandeproduit> panierParIdclient(@Param("idc")long i);
	
	@Query(value = "SELECT * FROM ligne_commande l JOIN commande c on l.commande_id=c.id  WHERE l.produit_id=?1 AND c.id_user=?2 AND l.status='en cours' and c.id !=?3 ", nativeQuery = true)
	public LigneCommande findLigneCommande(Long idProduit,Long idClient,Long idCommande);
	
	@Query(value = "SELECT * FROM ligne_commande l JOIN commande c on l.commande_id=c.id  WHERE l.produit_id=?1 AND c.id_user=?2 AND c.status='en cours'", nativeQuery = true)
	public LigneCommande findLigneCommande(Long idProduit,Long idClient);
	
	@Query(value = "SELECT  NEW tn.esprit.spring.entity.lignecommandeproduit(l.id,p.id,p.nomProduit,l.quantity,p.prix,l.quantity*p.prix,c.montant) FROM LigneCommande l join l.commande c  join l.produit p   WHERE c.idUser.id=:idc  and c.id=:idf")
	public List<lignecommandeproduit> factureParIdclient(@Param("idc")long i,@Param("idf")long idf);
	
	@Query(value = "SELECT  NEW tn.esprit.spring.entity.lignecommandeproduit(l.id,p.id,p.nomProduit,l.quantity,p.prix,l.quantity*p.prix,c.montant) FROM LigneCommande l join l.commande c  join l.produit p   WHERE c.id.id=:idc")
	public List<lignecommandeproduit> panierParIdCommande(@Param("idc")long i);
}

