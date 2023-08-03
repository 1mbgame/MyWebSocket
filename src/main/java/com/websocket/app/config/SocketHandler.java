package com.websocket.app.config;

import com.google.gson.Gson;
import org.springframework.stereotype.Component;
import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketSession;
import org.springframework.web.socket.handler.TextWebSocketHandler;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CopyOnWriteArrayList;

@Component
public class SocketHandler extends TextWebSocketHandler {


    private Map<String,WebSocketSession> webSocketSessionMap = new HashMap<>();
    private Gson gson = new Gson();

    @Override
    public void handleTextMessage(WebSocketSession session, TextMessage message) throws  IOException {

        System.out.println("session.getUri();="+session.getUri());
        
        WebSocketSession webSocketSession = webSocketSessionMap.get(session.getId());
        if(webSocketSession != null){
            webSocketSession.sendMessage(new TextMessage("Hello this is from web server, your message is "+ message.getPayload()));
        }else{
            System.out.println("webSocketSession is null, id: " + webSocketSession.getId());
            System.out.println(webSocketSession.toString());
        }
    }

    @Override
    public void afterConnectionEstablished(WebSocketSession session) throws Exception {
        //the messages will be broadcasting to all users.
        webSocketSessionMap.put(session.getId(),session);
    }
}
