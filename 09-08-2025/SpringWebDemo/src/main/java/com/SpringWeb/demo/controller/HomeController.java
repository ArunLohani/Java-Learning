package com.SpringWeb.demo.controller;


import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeController {

    @RequestMapping("/")
    public String greet(){
        return "Hello , Welcome to our Spring Web.";
    }


@RequestMapping("/about")
    public String about(){
        return "Currently learning SpringBoot";
    }


}
