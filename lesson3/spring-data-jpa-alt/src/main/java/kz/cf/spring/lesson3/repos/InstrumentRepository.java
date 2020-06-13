package kz.cf.spring.lesson3.repos;

import kz.cf.spring.lesson3.entities.Instrument;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by iuliana.cosmina on 5/7/17.
 */
public interface InstrumentRepository extends JpaRepository<Instrument, Long> {

}
