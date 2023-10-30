package com.example.startspringboot.ServiceLayer;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import org.springframework.stereotype.Component;

@Component
public class CricketCoach implements Coach{

    public CricketCoach(){
        System.out.println("In Constructor: " + getClass().getSimpleName());
    }

    // define our init method, when app starts this executes
    @PostConstruct
    public void doMyStartupStuff(){
        System.out.println("In doMyStartupStuff: " + getClass().getSimpleName());
    }

    // define our destroy method, when app closes this executes
    @PreDestroy
    public void doMyCleanupStuff(){
        System.out.println("In doMyCleanupStuff: " + getClass().getSimpleName());
    }
    @Override
    public String getDailyWworkout() {
        return "We should daily workout at least once!";
    }
}

// to change automatic reloading, CTRL+ALT+S goto Advance settings and uncheck Allow automake
// also goto build->compiler and uncheck build project automatically