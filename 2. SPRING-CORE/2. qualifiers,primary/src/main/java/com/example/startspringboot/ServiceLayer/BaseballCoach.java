package com.example.startspringboot.ServiceLayer;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Component
//@Primary
public class BaseballCoach implements Coach{
    @Override
    public String getDailyWworkout() {
        return "Spend 30 minutes in batting practice";
    }
}
