package com.websocket.app.controller;

import com.websocket.app.model.GlobalData;
import com.websocket.app.model.WsMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.Message;
import org.springframework.messaging.handler.annotation.Header;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.socket.WebSocketMessage;
import org.springframework.web.util.HtmlUtils;

import java.security.Principal;
import java.text.SimpleDateFormat;

@Controller
@CrossOrigin(origins = {"http://localhost:7777", "http://127.0.0.1:8080"})
public class WebSocketController {


    @Autowired
    private SimpMessagingTemplate simpMessagingTemplate;


    @MessageMapping("/api/web-socket/message")
    @SendTo("/api/web-socket/user-auth-status")
    public WsMessage greeting(WsMessage message) throws Exception {
        System.out.println("Receive: " + message.getMessage());

        Thread.sleep(1000); // simulated delay
        WsMessage wsMessage = new WsMessage();
        wsMessage.setMessage("Andy reply ok");



        return wsMessage;

    }



    @MessageMapping("/api/web-socket/user-connected")
    public void sendSpecific(String username) {
        GlobalData.getInstance().lastUsername = username;
        System.out.println("username: " + username);
        simpMessagingTemplate.convertAndSendToUser( username, "/api/web-socket/" + username, "registered username");
    }





























}
