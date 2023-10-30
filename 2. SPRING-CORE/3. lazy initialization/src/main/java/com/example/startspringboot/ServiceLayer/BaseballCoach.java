package com.example.startspringboot.ServiceLayer;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Component
public class BaseballCoach implements Coach{

    public BaseballCoach(){
        System.out.println("In Constructor: " + getClass().getSimpleName());
    }
    @Override
    public String getDailyWworkout() {
        return "Spend 30 minutes in batting practice";
    }
}
