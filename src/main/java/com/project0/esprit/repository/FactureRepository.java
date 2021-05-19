package com.project0.esprit.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.project0.esprit.entity.Commande;
import com.project0.esprit.entity.Facture;
import com.project0.esprit.entity.Lignecommandeproduit;





public interface FactureRepository extends JpaRepository<Facture, Long> {
	
	@Query(value = "SELECT  f.date,p.productname,l.quantity,p.price,l.quantity*p.price,u.username,c.montant  from   com.project0.esprit.entity.Lignecommandeproduit  l join l.commande c  join l.produit p join c.factureid f join c.user u  WHERE u.id=:idc ")
	public List<Lignecommandeproduit> FactureParIdUser(@Param("idc")long i);
	
	@Query("SELECT u FROM Facture u WHERE u.commande= :commande")
	public Facture FactureParCommander(@Param("commande")Commande i);
	
}