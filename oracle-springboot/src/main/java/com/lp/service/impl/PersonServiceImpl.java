package com.lp.service.impl;

import com.lp.dao.PersonDao;
import com.lp.entity.Person;
import com.lp.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
@Service
public class PersonServiceImpl implements PersonService {
    @Autowired
    private PersonDao personDao;


    @Override
    public ArrayList<Person> getPersonById(Integer id) {
        return personDao.getPersonById(id);
    }
}
