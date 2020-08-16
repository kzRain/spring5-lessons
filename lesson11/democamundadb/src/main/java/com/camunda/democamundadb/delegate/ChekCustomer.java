package com.camunda.democamundadb.delegate;

import com.camunda.democamundadb.model.Customer;
import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.JavaDelegate;

import java.util.logging.Logger;

public class ChekCustomer implements JavaDelegate {

    private Logger logger = Logger.getLogger(ChekCustomer.class.getName());

    @Override
    public void execute(DelegateExecution delegateExecution) throws Exception {

        logger.info(delegateExecution.getVariable("customer").toString());

        Customer customer = (Customer) delegateExecution.getVariable("customer");

        if (customer.getAge()<16) {

        }

    }
}
