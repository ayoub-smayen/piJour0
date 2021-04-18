package com.project0.esprit.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.socket.config.annotation.EnableWebSocket;
import org.springframework.web.socket.config.annotation.WebSocketConfigurer;
import org.springframework.web.socket.config.annotation.WebSocketHandlerRegistry;

import com.project0.esprit.dao.SocketHandler;

@Configuration
@EnableWebSocket
public class WebsocketVideo implements WebSocketConfigurer {

    @Override
    public void registerWebSocketHandlers(WebSocketHandlerRegistry registry) {
    registry.addHandler(new SocketHandler(), "/videochat").setAllowedOrigins("/*");
    }
}
