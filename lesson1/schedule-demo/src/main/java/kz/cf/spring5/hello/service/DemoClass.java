package kz.cf.spring5.hello.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class DemoClass {

    @Autowired
    private MessageProvider messageProvider;

    @Scheduled(cron = "0 * * * * *")
    public void demoSchedule() {
        System.out.println(messageProvider.getMessage());
    }

}
