package kz.cf.spring5.lesson5.repos;

import kz.cf.spring5.lesson5.entities.Singer;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface SingerRepository extends CrudRepository<Singer, Long> {

	List<Singer> findByFirstName(String firstName);
}
