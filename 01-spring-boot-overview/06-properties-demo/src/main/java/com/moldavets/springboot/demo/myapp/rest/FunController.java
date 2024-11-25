package com.moldavets.springboot.demo.myapp.rest;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FunController {

    @Value("${coach.name}")
    private String name;

    @Value("${coach.team}")
    private String team;

    @GetMapping("/")
    public String sayHello() {
        return "Hello World " + name + " " + team;
    }
}
