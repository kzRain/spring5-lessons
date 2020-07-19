package com.springfpexample.demo.controller;

import com.springfpexample.demo.model.GenderEnum;
import com.springfpexample.demo.model.People;
import com.springfpexample.demo.repo.PeopleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.*;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/")
public class PeopleCotroller {

    @Autowired
    private PeopleRepository peopleRepository;

    @GetMapping("/all")
    public List<People> all() {
        return peopleRepository.findAll();
    }


    @GetMapping("/female")
    public List<People> female() {
        List<People> people = peopleRepository.findAll();
        List<People> result = new ArrayList<>();
        people.forEach(people1 -> {if (people1.getGender().equals(GenderEnum.F)) result.add(people1);});
        return result;
    }

    @GetMapping("/male")
    public List<People> male() {
        return peopleRepository.findAll().stream()
                .filter(people1 -> people1.getGender().equals(GenderEnum.M))
                .collect(Collectors.toList());
    }



    @GetMapping("/sort")
    public List<People> sort() {
        return peopleRepository.findAll().stream()
                .sorted(Comparator.comparing(People::getAge).reversed().thenComparing(People::getId))
                .collect(Collectors.toList());
    }



    @GetMapping("/allElderThan5")
    public Boolean allMatch() {
        return peopleRepository.findAll().stream()
                .allMatch(people -> people.getAge()>5);
    }

    @GetMapping("/anyMatch")
    public Boolean anyMatch() {
        return peopleRepository.findAll().stream()
                .anyMatch(people -> people.getAge()>5);
    }

    @GetMapping("/noneMatch")
    public Boolean noneMatch() {
        return peopleRepository.findAll().stream()
                .noneMatch(people -> people.getAge()>5);
    }

    @GetMapping("/max")
    public Optional<People> max() {
        return peopleRepository.findAll().stream()
                .max(Comparator.comparing(People::getAge));
    }

    @GetMapping("/min")
    public Optional<People> min() {
        return peopleRepository.findAll().stream()
                .min(Comparator.comparing(People::getAge));
    }

    @GetMapping("/groupByGender")
    public Map<GenderEnum, List<People>> groupByGender() {
        return peopleRepository.findAll().stream()
                .collect(Collectors.groupingBy(People::getGender));
    }

    @GetMapping("/groupOfElder")
    public  List<People> groupOfElder() {
        List<People> all = peopleRepository.findAll();
        List<People> allfm= new ArrayList<>();
             allfm.add(all.stream()
            .filter(people -> people.getGender().equals(GenderEnum.F))
            .sorted(Comparator.comparing(People::getAge).reversed())
            .findFirst()
            .get());
            allfm.add(all.stream()
            .filter(people -> people.getGender().equals(GenderEnum.M))
            .sorted(Comparator.comparing(People::getAge).reversed())
            .findFirst()
            .get());
            return allfm;
    }



}