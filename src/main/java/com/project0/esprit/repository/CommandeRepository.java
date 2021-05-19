package com.project0.esprit.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.project0.esprit.entity.Commande;




@Repository
public interface CommandeRepository extends JpaRepository<Commande, Long> {
	
	@Query(value = "SELECT c FROM Commande c WHERE c.typedePayment=?1")
	public List<Commande> CommandeparType(String string);
	
	
	@Query(value = "SELECT c FROM Commande c WHERE c.user.id=?1")
	public List<Commande> CommandeparClient(int id);
	
	@Query(value = "SELECT c FROM Commande c WHERE c.user.id=?1 and c.status='en payee'")
	public List<Commande> CommandeparClientpayee(int id);
	
	@Query(value = "SELECT c FROM Commande c WHERE c.user.id=?1 and c.status='en Cours'")
	public Commande CommandeparClientencours(int id);
	
	//determiner les commande en cours
	@Query(value = "SELECT c FROM Commande c WHERE c.user.id=?1 and c.status='en cours'")
	public Commande CommandeencoursparClient(long id);
	
	//determiner le nombre de Commande par user
	@Query(value = "SELECT SUM(c.montant) FROM Commande c WHERE c.user.id=?1 and MONTH(c.date)=MONTH(NOW())and YEAR(c.date)=YEAR(NOW())and c.remise='non'")
	public double NombreDeCommandeParUser(long id);
	
    //chnagement la status de En cours vers payer
	@Query(value ="UPDATE Commande c set c.status='payee',c.typedePayment='en ligne'where c.id=?1")
	@Modifying
	@Transactional
	public void PayerEnLigne( @Param("id")long idCommande);
	
	@Query(value ="UPDATE Commande c set c.remise='oui'where c.user.id=?1 ")
	@Modifying
	@Transactional
	  public void remise( @Param("id_user")long iduser);
	

	@Query(value ="UPDATE Commande c set c.status='payee',c.typedePayment='a la livraison'where c.id=?1")
	   @Modifying
	  @Transactional
	public void PayerPorteaPorte( @Param("id")long idCommande);
	
	@Query(value ="UPDATE Commande c set c.status='en Cours',c.typedePayment='en ligne'where c.id=?1")
	   @Modifying
	  @Transactional
	public void enlignepayment( @Param("id")long idCommande);
	
	@Query(value ="UPDATE Commande c set c.status='en Cours',c.typedePayment='a la livraison'where c.id=?1")
	   @Modifying
	  @Transactional
	public void deliverypayment( @Param("id")long idCommande);
	
	
}
