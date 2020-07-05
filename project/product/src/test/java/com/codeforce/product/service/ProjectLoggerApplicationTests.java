package com.codeforce.product.service;


import com.codeforce.product.model.LogsDB;
import com.codeforce.product.repo.LogsDBRepo;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
class ProjectLoggerApplicationTests {

    @Autowired
    Logger logger;

    @Test
    void writeLogs() {
        logger.writeLog("Testing logger");
        logger.writeLog("Testing logger 2");
    }

    @Test
    void getExactClassLogsFromDb() {
        List<String> classLogs = logger.getExactClassLogs(ProjectLoggerApplicationTests.class);
        classLogs.forEach(System.out::println);
    }

    @Test
    void getCountFromDb() {
        System.out.println("The count of Logs in database: " + logger.getCount());
    }

    @Test
    void getLogById() {
        LogsDB test = logger.getLogById(1L);
        System.out.println(test.toString());
    }

    @Test
    void getAllLogsFromDb() {
        List<LogsDB> allLogs = logger.getAllLogs();
        allLogs.forEach(x-> System.out.println(x.toString()));
    }

}
