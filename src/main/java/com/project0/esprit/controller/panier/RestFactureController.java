package com.project0.esprit.controller.panier;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.net.MalformedURLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.FileSystemResource;
import org.springframework.core.io.InputStreamResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.project0.esprit.entity.Euser;
import com.project0.esprit.entity.panier.Commande;
import com.project0.esprit.entity.panier.Facture;
import com.project0.esprit.entity.panier.lignecommandeproduit;
import com.project0.esprit.repository.EuserRepository;
import com.project0.esprit.repository.UserRepository;
import com.project0.esprit.service.panier.CommandeImpl;
import com.project0.esprit.service.panier.FactureImpl;

import net.minidev.json.annotate.JsonIgnore;




@RestController
@RequestMapping("/Facture")
public class RestFactureController {
	
	@Autowired
	FactureImpl factureDAO;
	
	@Autowired
	CommandeImpl commandeDao;
	
	
	@Autowired
	ServletContext context;
	

	@Autowired
	EuserRepository userRepository;
	
	
	//http://localhost:8081/Facture/ajouter/{idCommande}
	@PostMapping("/ajouter/{idCommande}")
	public ResponseEntity <Facture> AjouterFacture(@PathVariable(value = "idCommande") Long idCommande, @RequestBody Facture f) 
			
	{
		Commande c =  commandeDao.findOne( idCommande);
		f.setCommande(c);
		factureDAO.save(f);
		return ResponseEntity.ok().build();
	
	}
	
	
	//http://localhost:8081/Facture/afficher
	@GetMapping("/afficher")
	public List<Facture > getAllFacture(){
		
		return factureDAO.findAll();
		
	}
	
	
	//http://localhost:8081/Facture/delete/{id}
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<Facture> DeleteProduit(@PathVariable(value = "id") Long idFacture) {
		Facture f = factureDAO.findOne(idFacture);
		if (f == null) {
			return ResponseEntity.notFound().build();
		}
		factureDAO.Delete(f);
		return ResponseEntity.ok().build();
	}
	
	
	//http://localhost:8081/Facture/{idUser}
	@GetMapping("/{idUser}")
	public List<lignecommandeproduit>FactureParIdUser(@PathVariable(value = "idUser") long id) {
	
		return factureDAO.FactureParIdUser(id);
	}
	
	//http://localhost:8081/Facture/afficherPDF/{idUser}
		@GetMapping("/afficherPDF/{idCommande}")
		public ResponseEntity<InputStreamResource> citiesReport(@PathVariable(value = "idCommande") long id_commande) {

		    factureDAO.ajouterUneFacture(id_commande);
		    List<lignecommandeproduit> lign =  factureDAO.CreePDF(id_commande);
		    Commande c = commandeDao.findOne(id_commande);
		    Facture f = factureDAO.FactureByCommande(c);
             
	        ByteArrayInputStream bis = GeneratePdfFacture.citiesReport(lign,f);
	        
	        DateFormat dateFormatter = new SimpleDateFormat("yyyy-MM-dd_HH:mm:ss");
	        String currentDateTime = dateFormatter.format(new Date());
	        HttpHeaders headers = new HttpHeaders();
	        String headerKey = "Content-Disposition";
	        String headerValue = "attachment; filename="+c.getIdUser().getMembre_username()+c.getId() + ".pdf";  // inline: online attachment :download
	        
	        headers.add(headerKey,headerValue);
	        return ResponseEntity
	                .ok()
	                .headers(headers)
	                .contentType(MediaType.APPLICATION_PDF)
	                .body(new InputStreamResource(bis));
	    }
	
		 @Autowired
		    private JavaMailSender mailSender;
		     
		    @PostMapping("/sendMail/{idClient}/{idCommande}") 
		    	public void sendEmail(@PathVariable(value = "idClient") long id_Client,@PathVariable(value = "idCommande") long id_Commande) throws MessagingException {
		            
		            MimeMessage msg = mailSender.createMimeMessage();
		            MimeMessageHelper helper = new MimeMessageHelper(msg, true);
		            
		            
		            

		        
		            
		             String mailSubject = "Facture from ConsomiTounsi";
		            String mailContent = " ";
		            Euser u = userRepository.getOne(id_Client);
		            
		            helper.setFrom("azizcharfeddine1997@gmail.com");
		            helper.setTo(u.getEmail());
		            helper.setSubject(mailSubject);
		            helper.setText( mailContent);
		            
		            FileSystemResource file = new FileSystemResource(new File("C://"+u.getMembre_username()+id_Commande+".pdf"));
		 
		            helper.addAttachment(u.getMembre_username()+id_Commande+".pdf", file);

		            mailSender.send(msg);

		        }

		        
		
		
}
	
	

