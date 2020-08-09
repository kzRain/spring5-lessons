package com.example.demorabbitmq.controller;

import com.example.demorabbitmq.listener.MyListener;
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
        logger.info("Отправка сообщения в очередь codeforce1");
        rabbitTemplate.convertAndSend("codeforce1", message);
        return "Отправил сообщение в очередь codeforce1";
    }

    @RequestMapping("/send2")
    @ResponseBody
    public String queue2() {
        logger.info("Отправка сообщения в очередь codeforce1");
        for (int i = 0; i <10 ; i++) {
            rabbitTemplate.convertAndSend("codeforce1", "message number " + i);
        }
        return "Отправил сообщение в очередь codeforce1";
    }

}
