package com.moldavets.springcoredemo;

import org.springframework.stereotype.Component;

@Component
public class CricketCoach implements Coach {
    @Override
    public String getDailyWorkout() {
        return "Do 15 min training";
    }
}
