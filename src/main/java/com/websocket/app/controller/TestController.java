package com.websocket.app.controller;

import com.websocket.app.model.GlobalData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {

    @Autowired
    private SimpMessagingTemplate simpMessagingTemplate;

    @GetMapping(path = "send-from-server")
    public String sendFromServer(){

        System.out.println("send to: " + GlobalData.getInstance().lastUsername);
        String username = GlobalData.getInstance().lastUsername;
        simpMessagingTemplate.convertAndSendToUser( username, "/msg", "send for fun");
        return "send to username: " + username;

    }


}
