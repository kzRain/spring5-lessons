package kz.cf.spring5.hello.service;

import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class DemoClass {

    @Scheduled(cron = "0 * * * * *")
    public void demoSchedule() {
        System.out.println("Hello World");
    }

}
