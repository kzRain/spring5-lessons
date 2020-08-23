package com.camunda.democamundadb.delegate;

import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.JavaDelegate;

import java.util.logging.Logger;

public class LoggerDelegate implements JavaDelegate {

    private Logger logger = Logger.getLogger(LoggerDelegate.class.getName());
    @Override
    public void execute(DelegateExecution execution) throws Exception {
        logger.info("... execution(processDefinitionId = " + execution.getProcessDefinitionId() +
                " currentActivityName = " + execution.getCurrentActivityName() +
                " currentActivityId = " + execution.getCurrentActivityId() +
                " processInstanceId = " + execution.getProcessInstanceId() +
                " processBusinessKey = " + execution.getProcessBusinessKey() +
                " currentTransitionId = " + execution.getCurrentTransitionId() +
                " id = " + execution.getId() +
                " list = " + execution.getVariable("customer") +
                " token = " + execution.getVariable("count") +
                ")");
    }
}
