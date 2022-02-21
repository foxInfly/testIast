package com.lp.controller;

import com.lp.entity.Person;
import com.lp.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;

@RestController
public class PersonController {
    @Autowired
    private PersonService personService;


    @GetMapping("getPersonById")
    public ArrayList<Person> getPersonById(Integer id){
        return personService.getPersonById(id);

    }
}
