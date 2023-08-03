package com.websocket.app.controller;

import com.websocket.app.model.MyCar;

public class MyMain {
    
    public static void main(String[] args) {
        MyCar myCar = new MyCar(
                "Andy Car",
                "Red",
                2020,
                100
        );
        
        System.out.println(myCar);
        
    }
    
}
