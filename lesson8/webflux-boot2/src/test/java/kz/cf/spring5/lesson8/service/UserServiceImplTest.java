package kz.cf.spring5.lesson8.service;

import kz.cf.spring5.lesson8.domain.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import reactor.core.publisher.Flux;

import java.time.Duration;

@RunWith(SpringRunner.class)
@SpringBootTest
public class UserServiceImplTest {

    @Autowired
    public UserService userService;


    @Test
    public void get() {
        Flux<User> result = userService.get();
        System.out.println("*******************************");
        result.subscribe(r -> System.out.println(r.getFirstName()));
        System.out.println("*******************************"+result.blockFirst().getFirstName());

    }
    @Test
    public void getWithDelay() {
        Flux<User> result = userService.get();
        System.out.println("***********Delay***************");
        result.delayElements(Duration.ofSeconds(1))
                .subscribe(System.out::println);
        System.out.println("*******************************"+result.blockFirst().getFirstName());

    }
}
