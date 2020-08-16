package com.camunda.democamundadb.controller;

import com.camunda.democamundadb.model.Customer;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.logging.Logger;


@Controller
public class CustumerController {

    private Logger logger = Logger.getLogger(CustumerController.class.getName());
    
    @GetMapping("/customer")
    @ResponseBody
    public Customer customerparam(@RequestParam String name, @RequestParam Integer age) {

        final String uri = "http://localhost:8080/rest/process-definition/key/Cinema_Proc_ID/start";

        RestTemplate restTemplate = new RestTemplate();

        logger.info("name="+name +" ; age="+age);
        
        Customer customer = new Customer(name,age);

        Customer customeresult = restTemplate.getForObject(uri, Customer.class);



        return customer;
    }







}
