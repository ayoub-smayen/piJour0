package com.project0.esprit.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.project0.esprit.entity.Notification;
import com.project0.esprit.entity.Product1;
import com.project0.esprit.repository.ProductRepository;
import com.project0.esprit.service.NotificationService;


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

@RequestMapping("/api")
@CrossOrigin("*")
@RestController
//@Controller
public class NotificationController {

  @Autowired
  private NotificationService notificationService;

  /**
   * GET  /  -> show the index page.
   */
  @RequestMapping("/notif1")
  public String index() {
    return "index";
  }

  /**
   * GET  /notifications  -> show the notifications page.
   */
  @RequestMapping("/notif/notifications")
  public String notifications() {
    return "notifications";
  }

  
  @Autowired 
  private ProductRepository  pr ;
  
  @Autowired
  private SimpMessagingTemplate template;

  // Initialize Notifications
  private Notification notifications = new Notification(0);
  
  
  
  private Myproduct m =new Myproduct();

  @GetMapping("/notify")
  public String getNotification() {
 
	 
	   List<Product1> pr2 = pr.findAll();
	   
	   long count  = pr.count();
	   
	   m.setProduct1(pr2);
	  m.setProductcount(count);
	   
      // Increment Notification by one
      notifications.increments();
      template.convertAndSend("/topic/products",m);
     
      // Push notifications to front-end
      template.convertAndSend("/topic/notification", notifications);

      return "Notifications successfully sent to Angular !";
  }
  /**
   * POST  /some-action  -> do an action.
   * 
   * After the action is performed will be notified UserA.
   */
  @RequestMapping(value = "/notif/some-action", method = RequestMethod.POST)
  @ResponseBody
  public ResponseEntity<?> someAction() {

    // Do an action here
    // ...
    
    // Send the notification to "UserA" (by username)
    notificationService.notify(
      new Notification("hello"), // notification object
      "UserA"                    // username
    );
    
    // Return an http 200 status code
    return new ResponseEntity<>(HttpStatus.OK);
  }

}