package com.websocket.app.config;



import org.springframework.context.annotation.Configuration;
import org.springframework.web.socket.config.annotation.EnableWebSocket;
import org.springframework.web.socket.config.annotation.WebSocketConfigurer;
import org.springframework.web.socket.config.annotation.WebSocketHandlerRegistry;


//@Configuration
//@EnableWebSocket
//public class WebSocketConfigV2 implements WebSocketConfigurer {
//    public void registerWebSocketHandlers(WebSocketHandlerRegistry registry) {
//        registry.addHandler(new SocketHandler(), "/api/websocket-end-point")
//                .setAllowedOrigins("http://127.0.0.1:8080");
//    }
//}
