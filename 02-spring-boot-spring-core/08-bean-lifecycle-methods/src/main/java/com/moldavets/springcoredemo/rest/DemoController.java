package com.moldavets.springcoredemo.rest;

import com.moldavets.springcoredemo.common.Coach;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DemoController {
    
    private final Coach theCoach;

    @Autowired
    public DemoController(@Qualifier("cricketCoach") Coach theCoach) {
        System.out.println("In constructor: " + getClass().getSimpleName());
        this.theCoach = theCoach;
    }

    @GetMapping("/dayliworkout")
    public String dailyWorkout() {
        return theCoach.getDailyWorkout();
    }
}
