package kz.cf.spring5.hello.repo;

import kz.cf.spring5.hello.model.Task;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface TaskRepository extends CrudRepository<Task, Long> {
    Optional<List<Task>> findByName(String name);

    @Query("from Task t where t.descr like '%:str%'")
    Optional<List<Task>> findByDescrLike(String str);
}
