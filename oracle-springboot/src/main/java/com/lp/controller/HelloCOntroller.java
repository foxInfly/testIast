package com.lp.controller;

import com.lp.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloCOntroller {


    @GetMapping("/hello")
    public String hello(){
        return "hello lp";
    }
}
