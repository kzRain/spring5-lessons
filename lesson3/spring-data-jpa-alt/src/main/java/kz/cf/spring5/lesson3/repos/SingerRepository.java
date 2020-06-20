package kz.cf.spring5.lesson3.repos;

import java.util.List;

import kz.cf.spring5.lesson3.entities.Singer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SingerRepository extends JpaRepository<Singer, Long> {
    List<Singer> findByFirstName(String firstName);
    List<Singer> findByFirstNameAndLastName(String firstName, String lastName);

}
