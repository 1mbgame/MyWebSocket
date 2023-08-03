package com.websocket.app.model;

public class MyCar {

    private String name;
    private String color;
    private int yearRelease;
    private int runMeter;


    public MyCar(String name, String color, int yearRelease, int runMeter) {
        this.name = name;
        this.color = color;
        this.yearRelease = yearRelease;
        this.runMeter = runMeter;
    }

    @Override
    public String toString() {
        return "MyCar{" +
                "name='" + name + '\'' +
                ", color='" + color + '\'' +
                ", yearRelease=" + yearRelease +
                ", runMeter=" + runMeter +
                '}';
    }
}
