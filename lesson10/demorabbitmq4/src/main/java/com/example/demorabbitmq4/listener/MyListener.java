package com.example.demorabbitmq4.listener;

import org.springframework.amqp.rabbit.annotation.EnableRabbit;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

import java.util.logging.Logger;

@Component
@EnableRabbit
public class MyListener {

    Logger logger = Logger.getLogger(MyListener.class.getName());

    @RabbitListener(queues = "codeforce1")
    public String process1Queue1(String message) {
        logger.info("1 Получил сообщение из очереди codeforce1("+message+")");
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return "Я 1 Получил сообщение из очереди codeforce1("+message+")";
    }

    @RabbitListener(queues = "codeforce2")
    public void process2Queue1(String message) {
        logger.info("2 Получил сообщение из очереди codeforce2("+message+")");

    }
}
