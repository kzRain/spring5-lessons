package kz.cf.spring5.lesson8.repos;

import kz.cf.spring5.lesson8.entities.Singer;
import org.springframework.data.repository.CrudRepository;

public interface SingerRepository extends CrudRepository<Singer, Long> {

}
