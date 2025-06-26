package com.zeus.demo.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/welcome")
public class welcomeController {

    //@GetMapping("/whoami")
    @RequestMapping(value="/whoami", method = RequestMethod.GET)
    public String whoAmI(){
        return "Welcome to the Zeus Demo Application!";
    }
}
