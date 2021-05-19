package com.project0.esprit.repository;


import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;


import com.project0.esprit.entity.LigneCommande;
import com.project0.esprit.entity.Lignecommandeproduit;










@Repository

public interface LigneCommandeRepository extends JpaRepository<LigneCommande, Long> {
	
	@Query(value = "SELECT  l  FROM LigneCommande l join l.commande c  join l.produit p WHERE c.user.id =:idc and c.status='en cours'")
	public List<LigneCommande> panierParIdclient(@Param("idc")Long i);
	
	@Query(value = "SELECT l FROM LigneCommande l JOIN Commande c on l.commande.id=c.id  WHERE l.produit.product_id=?1 AND c.user.id=?2 AND l.status='en cours' and c.id !=?3 ")
	public LigneCommande findLigneCommande(Long idProduit,Long idClient,Long idCommande);
	
	@Query(value = "SELECT l FROM LigneCommande l JOIN Commande c on l.commande.id=c.id  WHERE l.produit.product_id=?1 AND c.user.id=?2 AND c.status='en cours'")
	public LigneCommande findLigneCommande(Long idProduit,Long idClient);
	
	@Query(value = "SELECT  l.id,p.product_id,p.productname,l.quantity,p.price,l.quantity*p.price,c.montant FROM LigneCommande l join l.commande c  join l.produit p   WHERE c.user.id=:idc  and c.id=:idf")
	public List<Lignecommandeproduit> factureParIdclient(@Param("idc")long i,@Param("idf")long idf);
	
	@Query(value = "SELECT l.id,p.product_id,p.productname,l.quantity,p.price,l.quantity*p.price,c.montant FROM LigneCommande l join l.commande c  join l.produit p   WHERE c.id=:idc")
	public List<Lignecommandeproduit> panierParIdCommande(@Param("idc")long i);
	
	@Query(value = "SELECT l  FROM LigneCommande l  WHERE l.id=?1")
	public List<LigneCommande> ligneCommandeparCommande(long id);
	
	@Transactional
	@Modifying
	@Query(value = "delete from LigneCommande  l  where l.id=:id ")
	public void deleteCommande(@Param("id")Long id);
	
}
