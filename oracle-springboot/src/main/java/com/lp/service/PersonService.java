package com.lp.service;

import com.lp.entity.Person;

import java.util.ArrayList;

public interface PersonService {
    public ArrayList<Person> getPersonById(Integer id);
}