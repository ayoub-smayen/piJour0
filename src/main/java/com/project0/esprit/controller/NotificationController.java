package com.project0.esprit.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.project0.esprit.entity.Notification;
import com.project0.esprit.service.NotificationService;


@RequestMapping("api")
@CrossOrigin("*")
@RestController
//@Controller
public class NotificationController {

  @Autowired
  private NotificationService notificationService;

  /**
   * GET  /  -> show the index page.
   */
  @RequestMapping("/notif")
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