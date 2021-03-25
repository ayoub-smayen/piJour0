package com.project0.esprit.config;

import org.springframework.context.annotation.Configuration;
//import org.springframework.messaging.simp.config.MessageBrokerRegistry;
import org.springframework.web.socket.config.annotation.AbstractWebSocketMessageBrokerConfigurer;
import org.springframework.web.socket.config.annotation.EnableWebSocketMessageBroker;
import org.springframework.web.socket.config.annotation.StompEndpointRegistry;
import org.springframework.web.socket.config.annotation.WebSocketMessageBrokerConfigurer;


@Configuration
@EnableWebSocketMessageBroker
public class NotificationConfig implements WebSocketMessageBrokerConfigurer {


public void registerStompEndpoints(StompEndpointRegistry registry) {
 

 registry.addEndpoint("/ws").withSockJS();
 
 return;
}

///**
//* Configure the message broker.
//*/
//@Override
//public void configureMessageBroker(MessageBrokerRegistry config) {
//
// // Enable a simple memory-based message broker to send messages to the
// // client on destinations prefixed with "/queue".
// // Simple message broker handles subscription requests from clients, stores
// // them in memory, and broadcasts messages to connected clients with 
// // matching destinations.
// config.enableSimpleBroker("/queue");
//
// return;
//}

} // class WebSocketConfig
