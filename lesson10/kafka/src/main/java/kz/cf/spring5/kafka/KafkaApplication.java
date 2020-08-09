package kz.cf.spring5.kafka;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.telegram.telegrambots.ApiContextInitializer;

@SpringBootApplication
public class KafkaApplication {

    public static void main(String[] args) {
        ApiContextInitializer.init();
        SpringApplication.run(KafkaApplication.class, args);
    }

}
