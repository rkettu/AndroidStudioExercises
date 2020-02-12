package com.example.lab4_hiit;

import java.io.Serializable;

public class WorkoutPart implements Serializable {

    private int seconds;
    private String name;

    public WorkoutPart(int seconds, String name) {
        this.seconds = seconds;
        this.name = name;
    }

    public int getSeconds() {
        return seconds;
    }

    public void setSeconds(int seconds) {
        this.seconds = seconds;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}