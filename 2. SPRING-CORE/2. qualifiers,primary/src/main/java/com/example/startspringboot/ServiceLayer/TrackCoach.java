package com.example.startspringboot.ServiceLayer;

import org.springframework.stereotype.Component;

@Component
// component marks class as spring bean, spring couldnt find it if it isnt marked
public class TrackCoach implements Coach{
    @Override
    public String getDailyWworkout() {
        return "Run a hard 5k";
    }
}
