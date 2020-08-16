package com.camunda.democamundadb.delegate;

import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.JavaDelegate;

import java.util.logging.Logger;

public class LoggerDelegate implements JavaDelegate {

    private Logger logger = Logger.getLogger(LoggerDelegate.class.getName());
    @Override
    public void execute(DelegateExecution delegateExecution) throws Exception {
        logger.info(delegateExecution.getVariable("count").toString());
    }
}
