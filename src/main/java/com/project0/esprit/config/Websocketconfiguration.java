package com.project0.esprit.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.socket.WebSocketHandler;
import org.springframework.web.socket.config.annotation.EnableWebSocket;
import org.springframework.web.socket.config.annotation.WebSocketConfigurer;
import org.springframework.web.socket.config.annotation.WebSocketHandlerRegistry;

import com.project0.esprit.dao.ChatwebsocketHandler;

@Configuration
@EnableWebSocket
public class Websocketconfiguration implements WebSocketConfigurer {
	private static final String Chat_endpoint="/chat";

	@Override
	public void registerWebSocketHandlers(WebSocketHandlerRegistry register) {
		// TODO Auto-generated method stub
		register.addHandler(getChatWebSocketHandler(), Chat_endpoint)
		
		.setAllowedOrigins("http://localhost:4200");
		
		
	}
	@Bean
	public WebSocketHandler getChatWebSocketHandler(){
		return new ChatwebsocketHandler();
	
	
}


}
