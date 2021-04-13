package com.project0.esprit.service.panier;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.List;

import javax.persistence.Transient;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project0.esprit.entity.Euser;
import com.project0.esprit.entity.Product1;
import com.project0.esprit.entity.User1;
import com.project0.esprit.entity.panier.Commande;
import com.project0.esprit.entity.panier.LigneCommande;
import com.project0.esprit.entity.panier.lignecommandeproduit;
import com.project0.esprit.repository.EuserRepository;
import com.project0.esprit.repository.ProductRepository;
import com.project0.esprit.repository.UserRepository1;
import com.project0.esprit.repository.panier.CommandeRepository;
import com.project0.esprit.repository.panier.LigneCommandeRepository;



@Service
public class LigneCommandeImpl implements ILigneCommande {
	
	@Autowired
	LigneCommandeRepository ligneCommandeRepository;
	
	@Autowired
	ProductRepository produitRepository;
	
	@Autowired
	CommandeRepository commandeRepository;
	
	@Autowired
	EuserRepository userRepository;
	
	@Override
	public List<lignecommandeproduit> panierParIdclient(long id) {
		return ligneCommandeRepository.panierParIdclient(id);
	}

	@Override
	public LigneCommande findOne(Long id) {
		return ligneCommandeRepository.getOne(id);
	}

	@Override
	public List<LigneCommande> findAll() {
		return ligneCommandeRepository.findAll();
	}

	@Override
	public LigneCommande findLigneCommande(Long idProduit, Long idClient, Long idCommande) {
		return ligneCommandeRepository.findLigneCommande(idProduit, idClient,idCommande);
		
	}


	@Override
	public LigneCommande save(LigneCommande lc) {
		return ligneCommandeRepository.save(lc);
	
	}
	
	public void deleteLigne(long idLigneCommande) {
		LigneCommande lc = ligneCommandeRepository.getOne(idLigneCommande);
		Commande c=commandeRepository.findById(lc.getCommande().getId()).get();
		if(c.getPourcentageDeRemise()==0)	
		{
		c.setMontant((float) (c.getMontant()-(lc.getQuantity()*lc.getPrice())));
	commandeRepository.save(c);
	if(c.getMontant()<=1)
	{
		commandeRepository.delete(c);
	}
		}
		else
		{
			c.setMontant((float) (c.getMontant()-(lc.getQuantity()*lc.getPrice())));
			c.setPourcentageDeRemise((float) (c.getPourcentageDeRemise()-(lc.getQuantity()*lc.getPrice())));
			commandeRepository.save(c);
			if(c.getPourcentageDeRemise()<=1)
			{
				commandeRepository.delete(c);
			}
		}
		ligneCommandeRepository.delete(lc);
	}
	
	
	@Override
		public List<lignecommandeproduit> AjouterAuPanier(long idprod, long iduser,LigneCommande lc )
		{
			List<lignecommandeproduit>List=ligneCommandeRepository.panierParIdclient(iduser);
			//System.out.println(List);
			 Product1 p = produitRepository.getOne(idprod);
			Commande c=commandeRepository.CommandeencoursparClient(iduser);
			LigneCommande l=ligneCommandeRepository.findLigneCommande(idprod, iduser);
			  Euser cl= userRepository.getOne(iduser);
			
			 if(List.isEmpty())
			 {
				 float total=0; 
			Commande  c1= new Commande(); 
			ZoneId zid = ZoneId.of("Africa/Tunis");
			c1.setDate(LocalDate.now(zid));
			c1.setStatus("en cours");
			c1.setTypedePayment("en cours");
			c1.setRemise("non");
			lc.setPrice(p.getPrice());
			c1.setMontant(total);
			 lc.setStatus("en cours");
			 lc.setCommande(c1);
			 lc.setProduit(p);
			 ligneCommandeRepository.save(lc);
			 total=(float) (lc.getPrice()*lc.getQuantity());
			c1.setMontant(total);
			 commandeRepository.save(c1);
	
		
			 }
			else if ((c!=null))
			 {
				
					if(l!=null){
						l.setQuantity(l.getQuantity()+1);
						ligneCommandeRepository.save(l);
				 }
					else
					{
				 lc.setCommande(c);
					lc.setPrice(p.getPrice());
					 lc.setStatus("en cours");
					 lc.setProduit(p);
					 ligneCommandeRepository.save(lc);
					}
						double a= PrixTotalCommande(iduser);
						if(a>=500 && a<1000)
						{
							c.setMontant((float)a);
						//c.setMontant((float) ((float) a-(c.getPourcentageDeRemise()*a)));
							c.setPourcentageDeRemise(5);
						ZoneId zid = ZoneId.of("Africa/Tunis");
						c.setDate(LocalDate.now(zid));
						commandeRepository.save(c);
					}
						else if(a>=1000 && a<5000){
							c.setMontant((float)a);
							//c.setMontant((float) ((float) a-(c.getPourcentageDeRemise()*a)));
								c.setPourcentageDeRemise(7);
							ZoneId zid = ZoneId.of("Africa/Tunis");
							c.setDate(LocalDate.now(zid));
							commandeRepository.save(c);
							
						}
						else if(a>5000){
							c.setMontant((float)a);
							//c.setMontant((float) ((float) a-(c.getPourcentageDeRemise()*a)));
								c.setPourcentageDeRemise(10);
							ZoneId zid = ZoneId.of("Africa/Tunis");
							c.setDate(LocalDate.now(zid));
							commandeRepository.save(c);
							
						}
						else
						{
							c.setMontant((float) a);
							ZoneId zid = ZoneId.of("Africa/Tunis");
							c.setDate(LocalDate.now(zid));
							commandeRepository.save(c);
						}
					}
					
				return ligneCommandeRepository.panierParIdclient(iduser) ;
		}
		
		@Transient
		public Double PrixTotalCommande(long iduser) {
	        double sum = 0D;
	        List<lignecommandeproduit>List=ligneCommandeRepository.panierParIdclient(iduser);
	        for (lignecommandeproduit l : List) {
	            sum += l.getTotal();
	        }
	        return sum;
	    }
		
		
		 public void updateLigne(long idL,int quantity)
		 {
				LigneCommande lc = ligneCommandeRepository.getOne(idL);
				Commande c = commandeRepository.getOne(lc.getCommande().getId());
				if(c.getPourcentageDeRemise()==0)
				{
				c.setMontant((float) (c.getMontant()+((quantity-lc.getQuantity())*lc.getPrice())));
				lc.setQuantity(quantity);
				commandeRepository.save(c);
				}
				else
				{
					c.setMontant((float) (c.getMontant()+((quantity-lc.getQuantity())*lc.getPrice())));
					c.setPourcentageDeRemise((float) (c.getPourcentageDeRemise()+((quantity-lc.getQuantity())*lc.getPrice())));
					lc.setQuantity(quantity);
					commandeRepository.save(c);
				}
				ligneCommandeRepository.save(lc);
		 }
		 
		 
		 
		 
		 
		 
		 
		 
		 

}
	
