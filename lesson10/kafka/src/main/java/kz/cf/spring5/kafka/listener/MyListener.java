package kz.cf.spring5.kafka.listener;

import kz.cf.spring5.kafka.model.Human;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

import java.util.logging.Logger;

@Component
public class MyListener {
    Logger logger = Logger.getLogger(MyListener.class.getName());

    @KafkaListener(topics = "codeforce", groupId = "codeforce", containerFactory = "codeForceKafkaListenerContanerFactory")
    public void process1Queue1(String message) {
        logger.info("1 Получил сообщение из очереди codeforce1(" + message + ")");
    }

    @KafkaListener(topics = "codeforce", groupId = "codeforce", containerFactory = "codeHumanForceKafkaListenerContanerFactory")
    public void process1Queue2(Human human) {
        logger.info("1 Получил сообщение из очереди codeforce1(" + human.toString() + ")");
    }

    @KafkaListener(topics = "codeforce", groupId = "student", containerFactory = "studentKafkaListenerContanerFactory")
    public void process1Queue2(String message) {
        logger.info("2 Получил сообщение из очереди codeforce1(" + message + ")");
    }

}