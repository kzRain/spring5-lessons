package kz.cf.spring5.hello.repo;

import kz.cf.spring5.hello.model.Task;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@SpringBootTest
public class TaskRepositoryTest {

    @Autowired
    private TaskRepository repo;

    @Test
    void firstTest() {
        Task task = new Task(null, "first", new Date(), "qweqwe");
        task = repo.save(task);
        repo.save(new Task(null, "second", new Date(), "qwewvqqwrq"));
        repo.save(new Task(null, "third", new Date(), "qwqqqqwrq"));
        repo.save(new Task(null, "third", new Date(), "qwvqeeqwrq"));
        System.out.println(task.toString());
        Assertions.assertNotNull(task.getId());

        Optional<Task> savedTask = repo.findById((long) 1);

        if (savedTask.isPresent()) {
            Assertions.assertEquals(task, savedTask.get());
        }

        Optional<List<Task>> findTask = repo.findByName("third");
        if (findTask.isPresent()) {
            System.out.println(findTask.get());
            Assertions.assertTrue(findTask.get().get(0).getId()!=1);
        }

        Optional<List<Task>> find2Task = repo.findByDescrLike("v");
        if (find2Task.isPresent()) {
            System.out.println(find2Task.get());
            Assertions.assertTrue(find2Task.get().get(0).getId()!=1);
        }
    }
}
