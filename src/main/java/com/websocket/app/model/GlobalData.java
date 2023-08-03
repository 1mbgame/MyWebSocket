package com.websocket.app.model;

public class GlobalData {

    private static final GlobalData ourInstance = new GlobalData();

    public static GlobalData getInstance() {
        return ourInstance;
    }

    private GlobalData() {
        // initialize
    }

    public String lastUsername = "";


}
