package com.example.startspringboot.Controller;

import com.example.startspringboot.ServiceLayer.Coach;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MyController {
    // defining private field for dependency
    private Coach mycoach;
    // setter injection
    @Autowired
    public void setCoach(Coach theCoach){
        mycoach = theCoach;
    }
    // define constructor for dependency injection
//    @Autowired
//    public MyController(Coach theCoach){
//        mycoach = theCoach;
//    }

    @GetMapping("/dailyworkout")
    public String getDailyWorkout(){
        return mycoach.getDailyWworkout();
    }
// request from browser comes first to the controller, then controller goes to service layer Coach
// Coach interface using its method definition in class implementing it i.e. CricketCoach sends message
// to controller back and controller responses to browser


}
