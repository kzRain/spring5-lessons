package com.camunda.democamundadb.model;


import java.util.List;

public class Customer  {
    private String name;
    private Integer age;
    private List<String> GenerList ;

    public Customer(String name, Integer age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public List<String> getGenerList() {
        return GenerList;
    }

    public void setGenerList(List<String> generList) {
        GenerList = generList;
    }
}
