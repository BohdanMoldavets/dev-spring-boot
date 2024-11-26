package com.moldavets.springcoredemo.rest;

import com.moldavets.springcoredemo.Coach;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DemoController {
    
    private Coach theCoach;

    @Autowired
    public DemoController(Coach theCoach) {
        this.theCoach = theCoach;
    }

    @GetMapping("/dayliworkout")
    public String dailyWorkout() {
        return theCoach.getDailyWorkout();
    }
}
