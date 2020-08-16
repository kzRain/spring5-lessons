package com.camunda.democamundadb.controller;

import com.camunda.democamundadb.delegate.LoggerDelegate;
import com.camunda.democamundadb.model.Customer;
import org.springframework.web.bind.annotation.*;

import java.util.logging.Logger;


@org.springframework.stereotype.Controller
public class Controller {


    private Logger logger = Logger.getLogger(Controller.class.getName());
    
    @GetMapping("/customer")
    @ResponseBody
    public Customer customerparam(@RequestParam String name, @RequestParam Integer age) {

        logger.info("name="+name +" ; age="+age);
        
        Customer customer = new Customer(name,age);

        return customer;
    }

}
