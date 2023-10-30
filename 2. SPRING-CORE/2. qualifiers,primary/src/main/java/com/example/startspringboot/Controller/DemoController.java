package com.example.startspringboot.Controller;

import com.example.startspringboot.ServiceLayer.Coach;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DemoController {
    private Coach mycoach;

    @Autowired
    public void setCoach(@Qualifier("baseballCoach") Coach theCoach){
        mycoach = theCoach;
    }
// there is more than 1 bean of Coach type, so use @Qualifier to specify which one to use

    @GetMapping("/dailyworkout")
    public String getDailyWorkout(){
        return mycoach.getDailyWworkout();
    }

}
