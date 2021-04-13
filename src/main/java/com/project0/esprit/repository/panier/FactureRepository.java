package com.project0.esprit.repository.panier;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.project0.esprit.entity.panier.Commande;
import com.project0.esprit.entity.panier.Facture;
import com.project0.esprit.entity.panier.lignecommandeproduit;




public interface FactureRepository extends JpaRepository<Facture, Long> {
	
	@Query(value = "SELECT  NEW tn.esprit.spring.entity.lignecommandeproduit(f.date,p.nomProduit,l.quantity,p.prix,l.quantity*p.prix,u.firstName,c.montant) FROM LigneCommande l join l.commande c  join l.produit p join c.factureid f join c.idUser u  WHERE c.idUser.id=:idc ")
	public List<lignecommandeproduit> FactureParIdUser(@Param("idc")long i);
	
	@Query("SELECT u FROM Facture u WHERE u.commande= :commande")
	public Facture FactureParCommander(@Param("commande")Commande i);
	
}