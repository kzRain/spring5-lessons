package com.example.demo.model;

import com.example.demo.entity.LogsDB;
import com.example.demo.repo.LogsDBRepo;
import org.springframework.stereotype.Service;

import java.lang.reflect.Method;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class Logger {

    private final LogsDBRepo logsDBRepo;

    private static Long count = 0L;

    public Logger(LogsDBRepo logsDBRepo) {
        this.logsDBRepo = logsDBRepo;
    }

    public Long getCount() {
        return count;
    }


    public void writeLog(String log) {
        SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
        Date date = new Date();
        String logMessage = formatter.format(date) +
                            "\nLogging " + Thread.currentThread().getStackTrace()[2].getClassName() +
                            "\nMethod name - " + Thread.currentThread().getStackTrace()[2].getMethodName() +
                            "\nLogging message: " + log +
                            "\n";

        System.out.println(logMessage);
        LogsDB logsDB = new LogsDB();
        logsDB.setId(null);
        logsDB.setLog(logMessage);
        logsDBRepo.save(logsDB);
        count++;
    }

    public List<String> getExactClassLogs (Class clazz) {
        List<LogsDB> allLogs = logsDBRepo.findAll();
        List<String> logs = new ArrayList<>();

        for(LogsDB log : allLogs) {
            if (log.getLog().contains(clazz.getSimpleName())) {
                logs.add(log.getLog());
            }
        }
        return logs;
    }


}
