package com.project0.esprit.repository.panier;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.project0.esprit.entity.panier.Commande;




@Repository
public interface CommandeRepository extends JpaRepository<Commande, Long> {
	
	@Query(value = "SELECT * FROM commande WHERE typede_payment=?1", nativeQuery = true)
	public List<Commande> CommandeparType(String string);
	
	
	@Query(value = "SELECT * FROM commande WHERE id_user=?1", nativeQuery = true)
	public List<Commande> CommandeparClient(int id);
	
	//determiner les commande en cours
	@Query(value = "SELECT * FROM commande WHERE id_user=?1 and status='en cours'", nativeQuery = true)
	public Commande CommandeencoursparClient(long id);
	
	//determiner le nombre de Commande par user
	@Query(value = "SELECT SUM(c.montant) FROM commande c WHERE c.id_user=?1 and MONTH(c.date)=MONTH(NOW())and YEAR(c.date)=YEAR(NOW())and c.remise='non'", nativeQuery = true)
	public double NombreDeCommandeParUser(long id);
	
    //chnagement la status de En cours vers payer
	@Query(value ="UPDATE commande c set c.status='payee',c.typede_payment='en ligne'where c.id=?1",nativeQuery = true)
	@Modifying
	@Transactional
	public void PayerEnLigne( @Param("id")long idCommande);
	
	@Query(value ="UPDATE commande c set c.remise='oui'where c.id_user=?1 ",nativeQuery = true)
	@Modifying
	@Transactional
	  public void remise( @Param("id_user")long iduser);
	
	

	@Query(value ="UPDATE commande c set c.status='en livraison',c.typede_payment='porteaporte'where c.id=?1",nativeQuery = true)
	   @Modifying
	  @Transactional
	public void PayerPorteaPorte( @Param("id")long idCommande);
}
