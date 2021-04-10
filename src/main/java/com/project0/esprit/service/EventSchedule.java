package com.project0.esprit.service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Locale;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.project0.esprit.entity.Notification;
import com.project0.esprit.entity.Product1;
import com.project0.esprit.repository.ProductRepository;


class Myproduct {
	
	  List<Product1> product1; 
	  public List<Product1> getProduct1() {
		return product1;
	}
	public void setProduct1(List<Product1> product1) {
		this.product1 = product1;
	}
	public Myproduct(List<Product1> product1) {
		super();
		this.product1 = product1;
	}
	long productcount=0;
	public Myproduct(List<Product1> product1, long productcount) {
		super();
		this.product1 = product1;
		this.productcount = productcount;
	}
	public Myproduct() {
		super();
	}
	public long getProductcount() {
		return productcount;
	}
	public void setProductcount(long productcount) {
		this.productcount = productcount;
	}
	  
	
}


@Service
public class EventSchedule {

	
	private static final Logger LOG = LoggerFactory.getLogger(EventSchedule.class);
	
	
	  @Autowired
	  private SimpMessagingTemplate template;
	@Autowired
	  private NotificationService notificationService;

	@Autowired
	private ProductRepository pr ;
	
	 private Notification notifications = new Notification(0);
	  
	  
	  
	  private Myproduct m =new Myproduct();
	
	@Scheduled(fixedRate = 120000)
    public void create() {
		
		System.out.println(0.1 + 0.2);
		
		Locale arabe = new Locale("ar");
		
		 List<Product1> pr2 = pr.findAll();
		   
		   long count  = pr.count();
		   
		   m.setProduct1(pr2);
		  m.setProductcount(count);
		   
	      // Increment Notification by one
	      notifications.increments();

        final LocalDateTime start = LocalDateTime.now();
     /*   eventRepository.save(
            new Event(new EventKey("An event type", start, UUID.randomUUID()), Math.random() * 1000));
        LOG.debug("Event created!");*/
        
        template.convertAndSend("/topic/products",m);
        
        // Push notifications to front-end
        template.convertAndSend("/topic/notification", notifications);
        

    }
	
	
	
	
}
