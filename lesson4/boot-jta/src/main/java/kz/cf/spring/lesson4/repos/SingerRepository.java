package kz.cf.spring.lesson4.repos;

import kz.cf.spring.lesson4.entities.Singer;
import org.springframework.data.repository.CrudRepository;

public interface SingerRepository extends CrudRepository<Singer, Long> {

}
