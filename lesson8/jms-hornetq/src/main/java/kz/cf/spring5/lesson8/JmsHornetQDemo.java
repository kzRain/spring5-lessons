package kz.cf.spring5.lesson8;

import kz.cf.spring5.lesson8.config.AppConfig;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.GenericApplicationContext;

import java.util.Arrays;

public class JmsHornetQDemo {
    public static void main(String... args) throws Exception{
        GenericApplicationContext ctx = new AnnotationConfigApplicationContext(AppConfig.class);

        MessageSender messageSender = ctx.getBean("messageSender", MessageSender.class);
        System.out.println(Arrays.toString(ctx.getBeanDefinitionNames()));

//        for(int i=0; i < 10; ++i) {
//            messageSender.sendMessage("Test message: " + i);
//        }

        System.in.read();
        ctx.close();
    }
}
