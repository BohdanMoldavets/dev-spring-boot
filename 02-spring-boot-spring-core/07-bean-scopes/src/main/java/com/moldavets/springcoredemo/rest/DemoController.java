package com.moldavets.springcoredemo.rest;

import com.moldavets.springcoredemo.common.Coach;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DemoController {
    
    private final Coach theCoach;
    private final Coach anotherCoach;

    @Autowired
    public DemoController(@Qualifier("cricketCoach") Coach theCoach,
                          @Qualifier("cricketCoach") Coach anotherCoach) {
        this.theCoach = theCoach;
        this.anotherCoach = anotherCoach;
    }

    @GetMapping("/check")
    public String check() {
        return "Comparing beans theCoach==anotherCoach: " + (theCoach==anotherCoach);
    }

    @GetMapping("/dayliworkout")
    public String dailyWorkout() {
        return theCoach.getDailyWorkout();
    }
}
