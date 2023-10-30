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
    public void setCoach(@Qualifier("cricketCoach") Coach theCoach){
        System.out.println("In Constructor: " + getClass().getSimpleName());
        mycoach = theCoach;
    }

    @GetMapping("/dailyworkout")
    public String getDailyWorkout(){
        return mycoach.getDailyWworkout();
    }

}
