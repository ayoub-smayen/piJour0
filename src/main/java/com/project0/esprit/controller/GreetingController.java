package com.project0.esprit.controller;

import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;
import org.springframework.web.util.HtmlUtils;

import com.project0.esprit.entity.Greeting;
import com.project0.esprit.entity.HelloMessage;

@Controller
public class GreetingController {


  @MessageMapping("/hello")
  @SendTo("/topic/greetings")
  public Greeting greeting(HelloMessage message) throws Exception {
    Thread.sleep(1000); // simulated delay
    return new Greeting( message.getName() + " "   + HtmlUtils.htmlEscape(message.getMsg()) + "!");
  }

}
