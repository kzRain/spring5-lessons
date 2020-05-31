package kz.cf.spring5.hello.service;

import org.springframework.stereotype.Component;

@Component
public class HelloWorldMessageProvider implements MessageProvider {

    public HelloWorldMessageProvider(){
        System.out.println(" --> HelloWorldMessageProvider: constructor caled");
    }

    @Override
    public String getMessage() {
        return "Hello World!";
    }
}
