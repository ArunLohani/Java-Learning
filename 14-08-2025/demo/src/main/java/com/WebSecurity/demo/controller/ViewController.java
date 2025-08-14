package com.WebSecurity.demo.controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ViewController {

    @GetMapping("/home")
    public String home(){

        return "home";

    }

    @GetMapping("/")
    public String index(){

        return "index";

    }

    @GetMapping("/greet")
    public String greet(){

        return "greet";
    }

    @GetMapping("/login")
    public String login() {
        return "login";
    }


}
