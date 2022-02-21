package com.lp.dao;

import com.lp.entity.Person;
import org.apache.ibatis.annotations.Mapper;

import java.util.ArrayList;

@Mapper
public interface PersonDao {
    public ArrayList<Person> getPersonById(Integer id);
}