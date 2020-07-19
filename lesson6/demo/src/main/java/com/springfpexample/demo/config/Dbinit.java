package com.springfpexample.demo.config;


import com.springfpexample.demo.model.GenderEnum;
import com.springfpexample.demo.model.People;
import com.springfpexample.demo.repo.PeopleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;


@Service
public class Dbinit {

    @Autowired
    PeopleRepository peopleRepository;

    @PostConstruct
    public void setup(){

        People p1= new People("Ruslan","Alimbetov", GenderEnum.M,18); peopleRepository.save(p1);
        People p2= new People("VASYA","Frolov", GenderEnum.M,25); peopleRepository.save(p2);
        People p3= new People("FEDOR","Petrov", GenderEnum.M,30); peopleRepository.save(p3);
        People p4= new People("Elena","Sidorova", GenderEnum.F,40); peopleRepository.save(p4);
        People p5= new People("Asia","SINICINa", GenderEnum.F,60); peopleRepository.save(p5);
        People p6= new People("Zoya","ORLOVa", GenderEnum.F,25); peopleRepository.save(p6);


    }
}
