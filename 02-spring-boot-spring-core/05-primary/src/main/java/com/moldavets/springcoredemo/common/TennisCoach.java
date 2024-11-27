package com.moldavets.springcoredemo.common;

import org.springframework.stereotype.Component;

@Component
public class TennisCoach implements Coach {

    public String getDailyWorkout() {
        return "Practice tennis for 20 minutes";
    }
}
