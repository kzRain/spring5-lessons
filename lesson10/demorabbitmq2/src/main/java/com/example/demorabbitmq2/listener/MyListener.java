package com.example.demorabbitmq2.listener;

import com.example.demorabbitmq2.Image;
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
    public void process1Queue1(Image message) {
        logger.info("1 Получил сообщение из очереди codeforce1("+message.toString()+")");
        try {
            Thread.sleep(100 * (new Random().nextInt(20)));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @RabbitListener(queues = "codeforce2")
    public void process2Queue1(Image message) {
        logger.info("2 Получил сообщение из очереди codeforce2("+message.toString()+")");
        try {
            Thread.sleep(100 * (new Random().nextInt(20)));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
