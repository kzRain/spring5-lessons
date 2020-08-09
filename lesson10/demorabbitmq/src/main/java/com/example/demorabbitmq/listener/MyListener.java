package com.example.demorabbitmq.listener;

import org.springframework.amqp.rabbit.annotation.EnableRabbit;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

import java.util.Random;
import java.util.logging.Logger;

@Component
@EnableRabbit
public class MyListener {

    Logger logger = Logger.getLogger(MyListener.class.getName());

    @RabbitListener(queues = "codeforce1")
    public void process1Queue1(String message) {
        logger.info("1 Получил сообщение из очереди codeforce1("+message+")");
        try {
            Thread.sleep(100 * (new Random().nextInt(20)));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @RabbitListener(queues = "codeforce1")
    public void process2Queue1(String message) {
        logger.info("2 Получил сообщение из очереди codeforce1("+message+")");
        try {
            Thread.sleep(100 * (new Random().nextInt(20)));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
