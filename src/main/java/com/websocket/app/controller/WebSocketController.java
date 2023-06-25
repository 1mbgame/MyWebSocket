package com.websocket.app.controller;

import com.websocket.app.model.WsMessage;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.util.HtmlUtils;

@Controller
@CrossOrigin(origins = {"http://localhost:7777", "http://127.0.0.1:8080"})
public class WebSocketController {

    @MessageMapping("/api/web-socket/message")
    @SendTo("/api/web-socket/user-auth-status")
    public WsMessage greeting(WsMessage message) throws Exception {
        System.out.println("Receive: " + message.getMessage());

        Thread.sleep(1000); // simulated delay
        WsMessage wsMessage = new WsMessage();
        wsMessage.setMessage("Andy reply ok");

        return wsMessage;

    }

}
