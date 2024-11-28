package com.moldavets.springcoredemo.config;

import com.moldavets.springcoredemo.common.Coach;
import com.moldavets.springcoredemo.common.SwimCoach;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SportConfig {

    @Bean("swimBean")
    public Coach swimCoach() {
        return new SwimCoach();
    }
}
