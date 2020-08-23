package kz.cf.spring.lesson12.repos;

import kz.cf.spring.lesson12.entities.Singer;
import org.springframework.data.repository.CrudRepository;

public interface SingerRepository extends CrudRepository<Singer, Long> {

}
