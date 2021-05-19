package com.project0.esprit.service;

import java.time.LocalDate;
import java.time.ZoneId;
import java.util.List;

import javax.persistence.Transient;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project0.esprit.datentity.User;
import com.project0.esprit.entity.Commande;
import com.project0.esprit.entity.LigneCommande;
import com.project0.esprit.entity.Lignecommandeproduit;
import com.project0.esprit.entity.Product1;
import com.project0.esprit.repository.CommandeRepository;
import com.project0.esprit.repository.LigneCommandeRepository;
import com.project0.esprit.repository.ProductRepository;
import com.project0.esprit.repository.UserRepository;


@Service
public class LigneCommandeImpl implements ILigneCommande {
	
	@Autowired
	LigneCommandeRepository ligneCommandeRepository;
	
	@Autowired
	ProductRepository produitRepository;
	
	@Autowired
	CommandeRepository commandeRepository;
	
	@Autowired
	UserRepository userRepository;
	
	@Override
	public List<LigneCommande> panierParIdclient(long id) {
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
		
	
	@Override
		public List<LigneCommande> AjouterAuPanier(long idprod, long iduser,LigneCommande lc )
		{
			List<LigneCommande>List=ligneCommandeRepository.panierParIdclient(iduser);
			//System.out.println(List);
			 Product1 p = produitRepository.getOne(idprod);
			Commande c=commandeRepository.CommandeencoursparClient(iduser);
			LigneCommande l=ligneCommandeRepository.findLigneCommande(idprod, iduser);
			 User cl= userRepository.getOne(iduser);
			System.out.println(cl.getEmail());
			 if(List.isEmpty())
			 {
				 float total=0; 
			Commande  c1= new Commande(); 
			c1.setIdUser(cl);
			ZoneId zid = ZoneId.of("Africa/Tunis");
			c1.setDate(LocalDate.now(zid));
			c1.setStatus("en cours");
			c1.setTypedePayment("en cours");
			c1.setRemise("non");
			lc.setPrice(p.getPrice());
			c1.setMontant(total);
			 lc.setStatus("en cours");
			 lc.setProductName(p.getProductname());
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
					lc.setProductName(p.getProductname());
					 lc.setStatus("en cours");
					 lc.setProductName(p.getProductname());
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
	        List<LigneCommande>List=ligneCommandeRepository.panierParIdclient(iduser);
	        for (LigneCommande l : List) {
	            sum += l.getQuantity() * l.getProduit().getPrice();
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
					c.setPourcentageDeRemise((float) (Pourcentage(c.getMontant())));
					lc.setQuantity(quantity);
					commandeRepository.save(c);
				}
				ligneCommandeRepository.save(lc);
		 }
		 
		 public void updateLignecomande(LigneCommande lc){
			 long idL= lc.getId();
			 LigneCommande ld = ligneCommandeRepository.getOne(idL);
			 int quantity=ld.getQuantity();
			 Commande c = commandeRepository.getOne(lc.getCommande().getId());
			 c.setMontant((float) (c.getMontant()+((lc.getQuantity()-ld.getQuantity())*lc.getPrice())));
			 c.setPourcentageDeRemise((float) Pourcentage(c.getMontant()));
			 ligneCommandeRepository.save(lc);
		 }
		 
		 @Override
		 public void deleteLigne(long idLigneCommande) {
			 
				LigneCommande lc = ligneCommandeRepository.getOne(idLigneCommande);
				Commande c=commandeRepository.findById(lc.getCommande().getId()).get();
				c.setMontant((float) (c.getMontant()-(lc.getQuantity()*lc.getPrice())));
				c.setPourcentageDeRemise((float) Pourcentage(c.getMontant()));
				commandeRepository.save(c);
				System.out.print(c.getMontant());
				if (c.getMontant()==0){
					commandeRepository.delete(c);
				}
				ligneCommandeRepository.deleteCommande(idLigneCommande);		
			}
		 
		 @Transient
		 public int Pourcentage (float a){
			 int b=0;
			 if(a>=500 && a<1000)
				{
					 b=5;
					
			    }
				else if(a>=1000 && a<5000){
					b=7;
					
				}
				else if(a>5000){
					b=10;	
					
				}
			 return b;
		 }	 

}
	