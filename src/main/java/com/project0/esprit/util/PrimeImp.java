package com.project0.esprit.util;







import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailException;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import com.project0.esprit.datentity.Delivery_man0;
import com.project0.esprit.repository.DeliveryManRepository;





@Service 
public class PrimeImp  implements Prime{

	
	@Autowired
	DeliveryManRepository deliv ;
	
	
	
	private JavaMailSender javaMailSender;
	@Autowired
	public PrimeImp(JavaMailSender javaMailSender) {
		this.javaMailSender = javaMailSender;
	}
	int prime=100;
	@Scheduled(fixedDelay=1000*60)
public void primeLiv() throws MailException{
//	List <Delivery_Man> liv= deliv.findAll();
			for(Delivery_man0 del :  deliv.findAll()){
				if(del.getWorkLoad()>100){
					del.setSalaire(del.getSalaire()+prime);
					deliv.save(del);
					SimpleMailMessage mail = new SimpleMailMessage();
					
					mail.setTo(del.getEmail());
					mail.setSubject("Prime");
					mail.setText("La communauté Consommi Tounsi vous remercie pour vos efforts et vous offre une prime de 100DT");

					/*
					 * This send() contains an Object of SimpleMailMessage as an Parameter
					 */
					javaMailSender.send(mail);
				}
				
				
				
				
			}
	
	

			
			
}

}




