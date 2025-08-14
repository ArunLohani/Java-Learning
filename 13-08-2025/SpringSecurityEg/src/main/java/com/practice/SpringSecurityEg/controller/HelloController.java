package com.practice.SpringSecurityEg.controller;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {


    @GetMapping("/")
    public String greet(HttpServletRequest req){

        return "Welcome to Spring Security." + req.getSession().getId();

    }


}
