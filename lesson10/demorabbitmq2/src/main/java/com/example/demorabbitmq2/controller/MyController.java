package com.example.demorabbitmq2.controller;

import com.example.demorabbitmq2.Image;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.logging.Logger;

@Controller
public class MyController {
    Logger logger = Logger.getLogger(MyController.class.getName());

    @Autowired
    RabbitTemplate rabbitTemplate;

    @RequestMapping("/send1/{message}")
    @ResponseBody
    public String queue1(@PathVariable("message") String message) {
        logger.info("Отправка сообщения в очередь excodeforce");
        rabbitTemplate.setExchange("excodeforce");
        Image image = new Image();
        image.setName(message);
        image.setSize(200);
        rabbitTemplate.convertAndSend(image);
        return "Отправил сообщение в очередь excodeforce";
    }

    @RequestMapping("/send2")
    @ResponseBody
    public String queue2() {
        logger.info("Отправка сообщения в очередь excodeforce");
        rabbitTemplate.setExchange("excodeforce");
        for (int i = 0; i < 10; i++) {
            rabbitTemplate.convertAndSend("message " + i);
        }
        return "Отправил сообщение в очередь excodeforce";
    }

}
