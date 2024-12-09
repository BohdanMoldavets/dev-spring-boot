package com.moldavets.springboot.thymeleafdemo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class DemoController {

    @GetMapping("/helloworld")
    public String helloWorld(Model model) {
        model.addAttribute("theDate", java.time.LocalDate.now());

        return "helloWorld";
    }

}
