package com.training.springrestapi.controller;

import com.training.springrestapi.dto.Message;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class WelcomeController {
    //http:localhost:8080/greet
    @GetMapping("/greet")
    public Message greet()
    {
        return new Message("Welcome");
    }
}


//get -
//post-save
//put -update
//delete
//patch-partial update