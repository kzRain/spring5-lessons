package kz.cf.spring5.lesson3.repos;

import kz.cf.spring5.lesson3.entities.Instrument;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created  on 5/7/17.
 */
public interface InstrumentRepository extends JpaRepository<Instrument, Long> {

}
