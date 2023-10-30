package com.example.startspringboot.ServiceLayer;

import org.springframework.stereotype.Component;

@Component
public class CricketCoach implements Coach{

    public CricketCoach(){
        System.out.println("In Constructor: " + getClass().getSimpleName());
    }
    @Override
    public String getDailyWworkout() {
        return "We should daily workout at least once!";
    }
}

// to change automatic reloading, CTRL+ALT+S goto Advance settings and uncheck Allow automake
// also goto build->compiler and uncheck build project automatically