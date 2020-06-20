package com.example.demo;

import com.example.demo.entity.LogsDB;
import com.example.demo.model.Logger;
import com.example.demo.repo.LogsDBRepo;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
class ProjectLoggerApplicationTests {

    @Autowired
    LogsDBRepo logsDBRepo;


    @Test
    void writeLogs() {
        Logger logger = new Logger(logsDBRepo);
        logger.writeLog("Testing logger");
        logger.writeLog("Testing logger 2");
        System.out.println("The count of written logs: " + logger.getCount());
    }

    @Test
    void getLogsFromDb() {
        Logger logger = new Logger(logsDBRepo);
        List<String> classLogs = logger.getExactClassLogs(ProjectLoggerApplication.class);
        classLogs.forEach(System.out::println);
    }



}
