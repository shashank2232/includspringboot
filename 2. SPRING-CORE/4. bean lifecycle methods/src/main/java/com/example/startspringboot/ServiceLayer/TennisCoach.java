package com.example.startspringboot.ServiceLayer;

import org.springframework.stereotype.Component;

@Component
public class TennisCoach implements Coach{

    public TennisCoach(){
        System.out.println("In Constructor: " + getClass().getSimpleName());
    }
    @Override
    public String getDailyWworkout() {
        return "Practice your bandhand volley";
    }
}
