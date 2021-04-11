package com.project0.esprit.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Service;

import com.project0.esprit.entity.Notification;
@Service
public class NotificationService {
  
  // The SimpMessagingTemplate is used to send Stomp over WebSocket messages.
  @Autowired
  private SimpMessagingTemplate messagingTemplate;
  

  public void notify(Notification notification, String username) {
    messagingTemplate.convertAndSendToUser(
      username, 
      "/queue/notify", 
      notification
    );
    return;
  }
  
} // class Notif