package com.websocket.app.controller;

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
import org.springframework.web.util.HtmlUtils;

import java.security.Principal;
import java.text.SimpleDateFormat;

@Controller
@CrossOrigin(origins = {"http://localhost:7777", "http://127.0.0.1:8080"})
public class WebSocketController {

    @Autowired
    private SimpMessagingTemplate template;

    private String lastUsername;

    @MessageMapping("/api/web-socket/message")
    @SendTo("/api/web-socket/user-auth-status")
    public WsMessage greeting(WsMessage message) throws Exception {
        System.out.println("Receive: " + message.getMessage());

        Thread.sleep(1000); // simulated delay
        WsMessage wsMessage = new WsMessage();
        wsMessage.setMessage("Andy reply ok");



        return wsMessage;

    }

    @Autowired
    private SimpMessagingTemplate simpMessagingTemplate;

    @MessageMapping("/secured/room")
    public void sendSpecific(@Payload Message msg, Principal user, @Header("simpSessionId") String sessionId) {

        simpMessagingTemplate.convertAndSendToUser(
                user.getName(), "/secured/user/queue/specific-user", "get last user name");
        lastUsername = user.getName();
        System.out.println("lastUsername="+lastUsername);
        System.out.println("msg="+msg.toString());
    }

    @GetMapping(path = "send-from-server")
    public String sendFromServer(){

        simpMessagingTemplate.convertAndSendToUser(
                lastUsername,
                "/secured/user/queue/specific-user",
                "Hi "+lastUsername);
        return "done";

    }



























}
