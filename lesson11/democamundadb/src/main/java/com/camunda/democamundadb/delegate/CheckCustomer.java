package com.camunda.democamundadb.delegate;

import com.camunda.democamundadb.model.Customer;
import com.camunda.democamundadb.model.Movie;
import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.JavaDelegate;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.logging.Logger;

public class CheckCustomer implements JavaDelegate {

    private Logger logger = Logger.getLogger(CheckCustomer.class.getName());

    @Override
    public void execute(DelegateExecution delegateExecution) throws Exception {

        logger.info(delegateExecution.getVariable("customer").toString());

        Customer customer = (Customer) delegateExecution.getVariable("customer");

        List<Movie> movieList = new ArrayList<>();
        int count = new Random().nextInt();
        if (customer.getAge()<16) {
            for (int i = 0; i < count; i++) {
                movieList.add(new Movie("Movie" + i, Genre.Fantasy.name()));
            }
        }
        else {
            for (int i = 0; i < count; i++) {
                movieList.add(new Movie("Movie" + i, Genre.Horror.name()));
            }
        }
        delegateExecution.setVariable("movieList", movieList);
        delegateExecution.setVariable("count", count);

    }
}
