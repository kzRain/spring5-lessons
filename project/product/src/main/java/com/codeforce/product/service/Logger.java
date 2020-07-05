package com.codeforce.product.service;

import com.codeforce.product.model.LogsDB;
import com.codeforce.product.repo.LogsDBRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class Logger {

    @Autowired
    private LogsDBRepo logsDBRepo;

    public Long getCount() {
        return logsDBRepo.count();
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
        logsDB.setLog(logMessage);
        logsDBRepo.save(logsDB);
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

    public List<LogsDB> getAllLogs() {
        return logsDBRepo.findAll();
    }

    public LogsDB getLogById(Long id) {
        Optional<LogsDB> log = logsDBRepo.findById(id);
        if (log.isPresent()) {
            return log.get();
        }
        else {
            System.out.println("Log by ID not found");
            return null;
        }
    }
}
