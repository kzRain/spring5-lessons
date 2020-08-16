package com.camunda.democamundadb;

import org.camunda.bpm.spring.boot.starter.annotation.EnableProcessApplication;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@EnableProcessApplication
public class DemocamundadbApplication {

    public static void main(String[] args) {
        SpringApplication.run(DemocamundadbApplication.class, args);
    }

}
