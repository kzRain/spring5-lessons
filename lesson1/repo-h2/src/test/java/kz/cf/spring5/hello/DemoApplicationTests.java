package kz.cf.spring5.hello;

import kz.cf.spring5.hello.repo.TaskRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class DemoApplicationTests {

    @Autowired
    private TaskRepository repo;

    @Test
    void contextLoads() {
        Assertions.assertNotNull(repo);
    }

}
