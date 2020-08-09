package kz.cf.spring5.kafka.controller;


import kz.cf.spring5.kafka.model.Human;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.logging.Logger;

@Controller
public class MyController {
    Logger logger = Logger.getLogger(MyController.class.getName());

    @Autowired
    private KafkaTemplate<String, String> kafkaTemplate;

    @Autowired
    private KafkaTemplate<String, Human> kafkaHumanTemplate;


    @RequestMapping("/send1")
    @ResponseBody
    public String queue1() {
        logger.info("Отправка сообщения в очередь codeforce");
        kafkaTemplate.send("codeforce", "Hello !!");
        return "Отправил сообщение в очередь codeforce1";
    }

    @RequestMapping("/send1/human/{name}/{age}")
    @ResponseBody
    public String queue2(@PathVariable("name") String name, @PathVariable("age") Integer age) {
        logger.info("Отправка сообщения в очередь codeforce");
        Human human = new Human(name,age);
        kafkaHumanTemplate.send("codeforce", human);
        return "Отправил сообщение в очередь codeforce1";
    }

}

