package com.moldavets.springboot.thymeleafdemo.controller;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class HelloController {

    @GetMapping("/showForm")
    public String showForm() {
        return "hellowrold-form";
    }

    @RequestMapping("/processForm")
    public String processForm() {
        return "helloworld";
    }

    @RequestMapping("/processFormSecondVersion")
    public String processFormSecondVersion(HttpServletRequest request, Model model) {
        String name = request.getParameter("name").toUpperCase();

        String response = "I'm glad to see you " + name;

        model.addAttribute("secondResponse", response);

        return "helloworld";
    }

    @GetMapping("/processFormThirdVersion")
    public String processFormSecondVersion(@RequestParam("studentName") String name, Model model) {
        String request = name.toUpperCase();
        String response = "Take some coffee " + request;

        model.addAttribute("thirdResponse", response);
        return "helloworld";
    }

}
