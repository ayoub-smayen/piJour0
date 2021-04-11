package com.project0.esprit.service;

import java.io.File;
import java.io.IOException;
import java.security.Principal;
import java.util.List;
import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Multipart;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.FileSystemResource;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import com.project0.esprit.datentity.User;
import com.project0.esprit.entity.Colis;
import com.project0.esprit.entity.Etat;
import com.project0.esprit.entity.Product1;
import com.project0.esprit.repository.ColisRepository;
import com.project0.esprit.repository.ProductRepository;
import com.project0.esprit.repository.UserRepository;

@Service 
public class ColisUpdateEveryOneminute {
	
	
	@Autowired
	ColisRepository colisRepository ;
	@Autowired
    private JavaMailSender emailSender;
	
	@Autowired
	UserRepository userrepo;

	@Autowired
	ProductRepository prodrep;
	@Scheduled(cron = "0 0/2 * 1/1 * ?")
	public void sendNotif() {
		
		for(Colis cv :colisRepository.findAll() )
		System.out.println(cv.getPrenom());
		
	}
	
	@Scheduled(fixedRate = 5000)
	public void  notifyProduct() {
		/*HttpServletRequest req =null;
		Cookie p1 ;
		Cookie []p3 = req.getCookies();
		for(Cookie c  : p3) {
			if( ! c.getValue().equals(null)) {
				p1 = c;
			}
		}
		*/
		
		for(User u  : userrepo.findAll()) {
			
		
		
		for(Product1 p2 :prodrep.findAll()) {
			 //User u = userrepo.findByUsernameAndFetchRoles(p1.getValue());
			 Properties props = new Properties();
			   props.put("mail.smtp.auth", "true");
			   props.put("mail.smtp.starttls.enable", "true");
			   props.put("mail.smtp.host", "smtp.gmail.com");
			   props.put("mail.smtp.port", "587");
			   
			   Session session = Session.getInstance(props, new javax.mail.Authenticator() {
			      protected PasswordAuthentication getPasswordAuthentication() {
			         return new PasswordAuthentication("ayoubjobs.2019@gmail.com", "sahar+ayoub1");
			      }
			   });
			 Message msg = new MimeMessage(session);
			   try {
				msg.setFrom(new InternetAddress("ayoubjobs.2019@gmail.com", false));
			} catch (MessagingException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			 MimeBodyPart messageBodyPart = new MimeBodyPart();
			   try {
				messageBodyPart.setContent("consomi tunsi", "text/html");
			} catch (MessagingException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			   Multipart multipart = new MimeMultipart();
			   try {
				multipart.addBodyPart(messageBodyPart);
			} catch (MessagingException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			   MimeBodyPart attachPart = new MimeBodyPart();

			   try {
				attachPart.attachFile(p2.getProductImg().toString());
				 multipart.addBodyPart(attachPart);
				   msg.setContent(multipart);
				   Transport.send(msg);   
			} catch (IOException | MessagingException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			  
			 
			 SimpleMailMessage message = new SimpleMailMessage(); 
		        message.setFrom("ayoubjobs.2019@gmail.com");
		        message.setTo(u.getEmail()); 
		        message.setSubject(p2.getBrand());
		        
		        message.setText(p2.getProductdescription());
		        emailSender.send(message);
		}
	}
	}
	
	
	
	
	
	/*@Scheduled(cron = "0 0/2 * 1/1 * ?")
	@Transactional
	public List<Colis> ColisEnattent(){
		
		List<Colis> lcol = colisRepository.findAll();
		
		for(Colis b : lcol ) {
			colisRepository.findById(b.getColi_id()).map(etr->{
				// etr.setColi_id(etr.getColi_id());
				 System.out.println(etr.getEtatcolis().toString().equals(Etat.EnAttent.toString()));
				  if(etr.getEtatcolis().toString().equals(Etat.EnAttent.toString())) {
					  System.out.println(etr.getEtatcolis().toString());
					  etr.setEtatcolis(Etat.enCours);
					  System.out.println("update");
					  System.out.println(etr.getEtatcolis());

					  return colisRepository.save(etr);

					  
				  }
				  else {
					  System.out.println("eerrer");
					  return "pass";
				  }
				 // return colisRepository.save(etr);
			});
		}
		
		
		// colisRepository.saveAll(lcol);
		
		for (Colis j : lcol) {
			System.out.println(j.getEtatcolis().toString());
		}
		return lcol;
	}
	*/
	

}
