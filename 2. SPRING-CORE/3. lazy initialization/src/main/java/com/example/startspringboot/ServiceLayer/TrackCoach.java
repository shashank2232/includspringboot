package com.example.startspringboot.ServiceLayer;

import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

@Component
@Lazy
public class TrackCoach implements Coach{

    public TrackCoach(){
        System.out.println("In Constructor: " + getClass().getSimpleName());
    }
    @Override
    public String getDailyWworkout() {
        return "Run a hard 5k";
    }
}
// Since this component TrackCoach is done @Lazy, when app starts it doesn't instantiate it.
// So its constructor isn't printed in CONSOLE.