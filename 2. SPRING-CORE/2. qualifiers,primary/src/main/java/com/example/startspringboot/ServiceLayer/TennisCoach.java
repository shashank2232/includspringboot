package com.example.startspringboot.ServiceLayer;

import org.springframework.stereotype.Component;

@Component
public class TennisCoach implements Coach{
    @Override
    public String getDailyWworkout() {
        return "Practice your bandhand volley";
    }
}
